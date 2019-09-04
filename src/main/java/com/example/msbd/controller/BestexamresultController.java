package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Bestexamresult;
import com.example.msbd.service.BestexamresultService;

import javax.validation.Valid;

@Api(value = "bestexamresult模块接口",description = "这是一个考试结果模块的接口文档")
@RestController
@Slf4j
public class BestexamresultController {

	@Autowired
    BestexamresultService bestexamresultService;

	@ApiOperation("查询所有考试结果 支持多条件分页排序查询")
    @PostMapping("/getAllBestexamresult")
    public Object getAllBestexamresult(@RequestBody PageParam<Bestexamresult> pageParam){
        return MyRsp.success(bestexamresultService.getAllBestexamresult(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有考试结果 支持分页和排序")
    @PostMapping("/superSearchBestexamresult")
    public Object superSearch(@RequestBody PageParam<Bestexamresult> pageParam){
        return MyRsp.success(bestexamresultService.getAllBestexamresult(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除考试结果，同时会清空redis缓存")
    @GetMapping("/removeBestexamresultById/{id}")
    public Object removeBestexamresultByBestexamresultName(@PathVariable("id") int id){

        return bestexamresultService.removeBestexamresultById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addBestexamresult")
    public Object addBestexamresult(@RequestBody @Valid Bestexamresult bestexamresultParam){
        Bestexamresult bestexamresult=(Bestexamresult)bestexamresultService.addBestexamresult(bestexamresultParam);

        return bestexamresult!=null?MyRsp.success(bestexamresult).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateBestexamresult")
    public Object updateBestexamresult(@RequestBody@Valid Bestexamresult bestexamresult){
        return bestexamresultService.updateBestexamresult(bestexamresult)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getBestexamresultById/{id}")
    public Object getBestexamresultById(@PathVariable("id") int id){

        Bestexamresult bestexamresult=bestexamresultService.getBestexamresultById(id);
        return bestexamresult!=null?MyRsp.success(bestexamresult):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteBestexamresultByIds")
    public Object batchDeleteBestexamresultByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (bestexamresultService.removeBestexamresultById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}