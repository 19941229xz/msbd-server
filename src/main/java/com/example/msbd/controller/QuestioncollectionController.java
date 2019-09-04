package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Questioncollection;
import com.example.msbd.service.QuestioncollectionService;

import javax.validation.Valid;

@Api(value = "questioncollection模块接口",description = "这是一个试题收藏模块的接口文档")
@RestController
@Slf4j
public class QuestioncollectionController {

	@Autowired
    QuestioncollectionService questioncollectionService;

	@ApiOperation("查询所有试题收藏 支持多条件分页排序查询")
    @PostMapping("/getAllQuestioncollection")
    public Object getAllQuestioncollection(@RequestBody PageParam<Questioncollection> pageParam){
        return MyRsp.success(questioncollectionService.getAllQuestioncollection(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有试题收藏 支持分页和排序")
    @PostMapping("/superSearchQuestioncollection")
    public Object superSearch(@RequestBody PageParam<Questioncollection> pageParam){
        return MyRsp.success(questioncollectionService.getAllQuestioncollection(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除试题收藏，同时会清空redis缓存")
    @GetMapping("/removeQuestioncollectionById/{id}")
    public Object removeQuestioncollectionByQuestioncollectionName(@PathVariable("id") int id){

        return questioncollectionService.removeQuestioncollectionById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addQuestioncollection")
    public Object addQuestioncollection(@RequestBody @Valid Questioncollection questioncollectionParam){
        Questioncollection questioncollection=(Questioncollection)questioncollectionService.addQuestioncollection(questioncollectionParam);

        return questioncollection!=null?MyRsp.success(questioncollection).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateQuestioncollection")
    public Object updateQuestioncollection(@RequestBody@Valid Questioncollection questioncollection){
        return questioncollectionService.updateQuestioncollection(questioncollection)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getQuestioncollectionById/{id}")
    public Object getQuestioncollectionById(@PathVariable("id") int id){

        Questioncollection questioncollection=questioncollectionService.getQuestioncollectionById(id);
        return questioncollection!=null?MyRsp.success(questioncollection):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteQuestioncollectionByIds")
    public Object batchDeleteQuestioncollectionByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (questioncollectionService.removeQuestioncollectionById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}