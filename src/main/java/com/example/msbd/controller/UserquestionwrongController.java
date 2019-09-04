package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Userquestionwrong;
import com.example.msbd.service.UserquestionwrongService;

import javax.validation.Valid;

@Api(value = "userquestionwrong模块接口",description = "这是一个用户错题模块的接口文档")
@RestController
@Slf4j
public class UserquestionwrongController {

	@Autowired
    UserquestionwrongService userquestionwrongService;

	@ApiOperation("查询所有用户错题 支持多条件分页排序查询")
    @PostMapping("/getAllUserquestionwrong")
    public Object getAllUserquestionwrong(@RequestBody PageParam<Userquestionwrong> pageParam){
        return MyRsp.success(userquestionwrongService.getAllUserquestionwrong(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有用户错题 支持分页和排序")
    @PostMapping("/superSearchUserquestionwrong")
    public Object superSearch(@RequestBody PageParam<Userquestionwrong> pageParam){
        return MyRsp.success(userquestionwrongService.getAllUserquestionwrong(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除用户错题，同时会清空redis缓存")
    @GetMapping("/removeUserquestionwrongById/{id}")
    public Object removeUserquestionwrongByUserquestionwrongName(@PathVariable("id") int id){

        return userquestionwrongService.removeUserquestionwrongById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addUserquestionwrong")
    public Object addUserquestionwrong(@RequestBody @Valid Userquestionwrong userquestionwrongParam){
        Userquestionwrong userquestionwrong=(Userquestionwrong)userquestionwrongService.addUserquestionwrong(userquestionwrongParam);

        return userquestionwrong!=null?MyRsp.success(userquestionwrong).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateUserquestionwrong")
    public Object updateUserquestionwrong(@RequestBody@Valid Userquestionwrong userquestionwrong){
        return userquestionwrongService.updateUserquestionwrong(userquestionwrong)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getUserquestionwrongById/{id}")
    public Object getUserquestionwrongById(@PathVariable("id") int id){

        Userquestionwrong userquestionwrong=userquestionwrongService.getUserquestionwrongById(id);
        return userquestionwrong!=null?MyRsp.success(userquestionwrong):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteUserquestionwrongByIds")
    public Object batchDeleteUserquestionwrongByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (userquestionwrongService.removeUserquestionwrongById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}