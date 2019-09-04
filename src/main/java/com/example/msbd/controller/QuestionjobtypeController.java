package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Questionjobtype;
import com.example.msbd.service.QuestionjobtypeService;

import javax.validation.Valid;

@Api(value = "questionjobtype模块接口",description = "这是一个试题所属职位模块的接口文档")
@RestController
@Slf4j
public class QuestionjobtypeController {

	@Autowired
    QuestionjobtypeService questionjobtypeService;

	@ApiOperation("查询所有试题所属职位 支持多条件分页排序查询")
    @PostMapping("/getAllQuestionjobtype")
    public Object getAllQuestionjobtype(@RequestBody PageParam<Questionjobtype> pageParam){
        return MyRsp.success(questionjobtypeService.getAllQuestionjobtype(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有试题所属职位 支持分页和排序")
    @PostMapping("/superSearchQuestionjobtype")
    public Object superSearch(@RequestBody PageParam<Questionjobtype> pageParam){
        return MyRsp.success(questionjobtypeService.getAllQuestionjobtype(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除试题所属职位，同时会清空redis缓存")
    @GetMapping("/removeQuestionjobtypeById/{id}")
    public Object removeQuestionjobtypeByQuestionjobtypeName(@PathVariable("id") int id){

        return questionjobtypeService.removeQuestionjobtypeById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addQuestionjobtype")
    public Object addQuestionjobtype(@RequestBody @Valid Questionjobtype questionjobtypeParam){
        Questionjobtype questionjobtype=(Questionjobtype)questionjobtypeService.addQuestionjobtype(questionjobtypeParam);

        return questionjobtype!=null?MyRsp.success(questionjobtype).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateQuestionjobtype")
    public Object updateQuestionjobtype(@RequestBody@Valid Questionjobtype questionjobtype){
        return questionjobtypeService.updateQuestionjobtype(questionjobtype)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getQuestionjobtypeById/{id}")
    public Object getQuestionjobtypeById(@PathVariable("id") int id){

        Questionjobtype questionjobtype=questionjobtypeService.getQuestionjobtypeById(id);
        return questionjobtype!=null?MyRsp.success(questionjobtype):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteQuestionjobtypeByIds")
    public Object batchDeleteQuestionjobtypeByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (questionjobtypeService.removeQuestionjobtypeById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}