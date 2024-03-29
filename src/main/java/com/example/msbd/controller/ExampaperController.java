package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Exampaper;
import com.example.msbd.service.ExampaperService;

import javax.validation.Valid;

@Api(value = "exampaper模块接口",description = "这是一个试卷模块的接口文档")
@RestController
@Slf4j
public class ExampaperController {

	@Autowired
    ExampaperService exampaperService;

	@ApiOperation("查询所有试卷 支持多条件分页排序查询")
    @PostMapping("/getAllExampaper")
    public Object getAllExampaper(@RequestBody PageParam<Exampaper> pageParam){
        return MyRsp.success(exampaperService.getAllExampaper(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有试卷 支持分页和排序")
    @PostMapping("/superSearchExampaper")
    public Object superSearch(@RequestBody PageParam<Exampaper> pageParam){
        return MyRsp.success(exampaperService.getAllExampaper(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除试卷，同时会清空redis缓存")
    @GetMapping("/removeExampaperById/{id}")
    public Object removeExampaperByExampaperName(@PathVariable("id") int id){

        return exampaperService.removeExampaperById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addExampaper")
    public Object addExampaper(@RequestBody @Valid Exampaper exampaperParam){
        Exampaper exampaper=(Exampaper)exampaperService.addExampaper(exampaperParam);

        return exampaper!=null?MyRsp.success(exampaper).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateExampaper")
    public Object updateExampaper(@RequestBody@Valid Exampaper exampaper){
        return exampaperService.updateExampaper(exampaper)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getExampaperById/{id}")
    public Object getExampaperById(@PathVariable("id") int id){

        Exampaper exampaper=exampaperService.getExampaperById(id);
        return exampaper!=null?MyRsp.success(exampaper):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteExampaperByIds")
    public Object batchDeleteExampaperByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (exampaperService.removeExampaperById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}