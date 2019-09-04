package com.example.msbd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msbd.common.*;
import com.example.msbd.model.Useranserquestion;
import com.example.msbd.service.UseranserquestionService;

import javax.validation.Valid;

@Api(value = "useranserquestion模块接口",description = "这是一个用户答题记录模块的接口文档")
@RestController
@Slf4j
public class UseranserquestionController {

	@Autowired
    UseranserquestionService useranserquestionService;

	@ApiOperation("查询所有用户答题记录 支持多条件分页排序查询")
    @PostMapping("/getAllUseranserquestion")
    public Object getAllUseranserquestion(@RequestBody PageParam<Useranserquestion> pageParam){
        return MyRsp.success(useranserquestionService.getAllUseranserquestion(pageParam)).msg("查询成功");
    }
    
    @ApiOperation("按照关键字高级检索所有用户答题记录 支持分页和排序")
    @PostMapping("/superSearchUseranserquestion")
    public Object superSearch(@RequestBody PageParam<Useranserquestion> pageParam){
        return MyRsp.success(useranserquestionService.getAllUseranserquestion(pageParam)).msg("检索成功");
    }

	@ApiOperation("通过id删除用户答题记录，同时会清空redis缓存")
    @GetMapping("/removeUseranserquestionById/{id}")
    public Object removeUseranserquestionByUseranserquestionName(@PathVariable("id") int id){

        return useranserquestionService.removeUseranserquestionById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

	@ApiOperation("添加{table.comment}，成功会将该数据放入redis缓存")
    @PostMapping("/addUseranserquestion")
    public Object addUseranserquestion(@RequestBody @Valid Useranserquestion useranserquestionParam){
        Useranserquestion useranserquestion=(Useranserquestion)useranserquestionService.addUseranserquestion(useranserquestionParam);

        return useranserquestion!=null?MyRsp.success(useranserquestion).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

	@ApiOperation("修改{table.comment}，成功会将清除该数据的redis缓存")
    @PutMapping("/updateUseranserquestion")
    public Object updateUseranserquestion(@RequestBody@Valid Useranserquestion useranserquestion){
        return useranserquestionService.updateUseranserquestion(useranserquestion)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

	@ApiOperation("通过id获取{table.comment}，优先从redis缓存中查")
    @GetMapping("/getUseranserquestionById/{id}")
    public Object getUseranserquestionById(@PathVariable("id") int id){

        Useranserquestion useranserquestion=useranserquestionService.getUseranserquestionById(id);
        return useranserquestion!=null?MyRsp.success(useranserquestion):MyRsp.wrapper(new MyException(HttpCode.ITEM_NOT_FOUND));
    }
    
    @ApiOperation("通过id数组批量删除{table.comment}，删除成功也会清空redis缓存数据")
    @PostMapping("/batchDeleteUseranserquestionByIds")
    public Object batchDeleteUseranserquestionByIds(@RequestBody int[] ids){
	    int affectedNum=0;
        for (int id:ids){
            affectedNum+= (useranserquestionService.removeUseranserquestionById(id)?1:0);
        }
	    return affectedNum==ids.length?MyRsp.success(null).msg("批量删除成功"):
                MyRsp.error().msg("批量删除失败");
    }
	
}