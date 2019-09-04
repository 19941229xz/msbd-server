package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Pointslog;
import com.example.msbd.service.PointslogService;

import javax.validation.Valid;

@Api(value = "pointslog模块接口",description = "这是一个积分记录表模块的接口文档")
@RestController
@Slf4j
public class PointslogController {

	@Autowired
    PointslogService pointslogService;

	@ApiOperation("查询所有积分记录表 支持多条件分页排序查询")
    @PostMapping("/getAllPointslog")
    public Object getAllPointslog(@RequestBody PageParam<Pointslog> pageParam){
        return MyRsp.success(pointslogService.getAllPointslog(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有积分记录表 支持分页和排序")
    @PostMapping("/superSearchPointslog")
    public Object superSearch(@RequestBody PageParam<Pointslog> pageParam){
        return MyRsp.success(pointslogService.getAllPointslog(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除积分记录表，同时会清空redis缓存")
    @GetMapping("/removePointslogById/{id}")
    public Object removePointslogByPointslogName(@PathVariable("id") int id){

        return pointslogService.removePointslogById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addPointslog")
    public Object addPointslog(@RequestBody @Valid Pointslog pointslogParam){
        Pointslog pointslog=(Pointslog)pointslogService.addPointslog(pointslogParam);

        return pointslog!=null?MyRsp.success(pointslog).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updatePointslog")
    public Object updatePointslog(@RequestBody@Valid Pointslog pointslog){
        return pointslogService.updatePointslog(pointslog)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getPointslogById/{id}")
    public Object getPointslogById(@PathVariable("id") int id){

        Pointslog pointslog=pointslogService.getPointslogById(id);
        return pointslog!=null?MyRsp.success(pointslog):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeletePointslogByIds")
    public Object batchDeletePointslogByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (pointslogService.removePointslogById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}