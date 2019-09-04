package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Questioncomment;
import com.example.msbd.service.QuestioncommentService;

import javax.validation.Valid;

@Api(value = "questioncomment模块接口",description = "这是一个试题评论表模块的接口文档")
@RestController
@Slf4j
public class QuestioncommentController {

	@Autowired
    QuestioncommentService questioncommentService;

	@ApiOperation("查询所有试题评论表 支持多条件分页排序查询")
    @PostMapping("/getAllQuestioncomment")
    public Object getAllQuestioncomment(@RequestBody PageParam<Questioncomment> pageParam){
        return MyRsp.success(questioncommentService.getAllQuestioncomment(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有试题评论表 支持分页和排序")
    @PostMapping("/superSearchQuestioncomment")
    public Object superSearch(@RequestBody PageParam<Questioncomment> pageParam){
        return MyRsp.success(questioncommentService.getAllQuestioncomment(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除试题评论表，同时会清空redis缓存")
    @GetMapping("/removeQuestioncommentById/{id}")
    public Object removeQuestioncommentByQuestioncommentName(@PathVariable("id") int id){

        return questioncommentService.removeQuestioncommentById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addQuestioncomment")
    public Object addQuestioncomment(@RequestBody @Valid Questioncomment questioncommentParam){
        Questioncomment questioncomment=(Questioncomment)questioncommentService.addQuestioncomment(questioncommentParam);

        return questioncomment!=null?MyRsp.success(questioncomment).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateQuestioncomment")
    public Object updateQuestioncomment(@RequestBody@Valid Questioncomment questioncomment){
        return questioncommentService.updateQuestioncomment(questioncomment)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getQuestioncommentById/{id}")
    public Object getQuestioncommentById(@PathVariable("id") int id){

        Questioncomment questioncomment=questioncommentService.getQuestioncommentById(id);
        return questioncomment!=null?MyRsp.success(questioncomment):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteQuestioncommentByIds")
    public Object batchDeleteQuestioncommentByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (questioncommentService.removeQuestioncommentById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}