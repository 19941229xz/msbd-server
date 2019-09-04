package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Question;
import com.example.msbd.service.QuestionService;

import javax.validation.Valid;

@Api(value = "question模块接口",description = "这是一个试题模块的接口文档")
@RestController
@Slf4j
public class QuestionController {

	@Autowired
    QuestionService questionService;

	@ApiOperation("查询所有试题 支持多条件分页排序查询")
    @PostMapping("/getAllQuestion")
    public Object getAllQuestion(@RequestBody PageParam<Question> pageParam){
        return MyRsp.success(questionService.getAllQuestion(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有试题 支持分页和排序")
    @PostMapping("/superSearchQuestion")
    public Object superSearch(@RequestBody PageParam<Question> pageParam){
        return MyRsp.success(questionService.getAllQuestion(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除试题，同时会清空redis缓存")
    @GetMapping("/removeQuestionById/{id}")
    public Object removeQuestionByQuestionName(@PathVariable("id") int id){

        return questionService.removeQuestionById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addQuestion")
    public Object addQuestion(@RequestBody @Valid Question questionParam){
        Question question=(Question)questionService.addQuestion(questionParam);

        return question!=null?MyRsp.success(question).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateQuestion")
    public Object updateQuestion(@RequestBody@Valid Question question){
        return questionService.updateQuestion(question)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getQuestionById/{id}")
    public Object getQuestionById(@PathVariable("id") int id){

        Question question=questionService.getQuestionById(id);
        return question!=null?MyRsp.success(question):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteQuestionByIds")
    public Object batchDeleteQuestionByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (questionService.removeQuestionById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}