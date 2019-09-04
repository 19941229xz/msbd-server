package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Userquestionwrong" ,description = "用户错题")
@Data  // 自动生成get set 和构造器
public class Userquestionwrong implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 用户id
    @ApiModelProperty(value = "用户id" ,name = "userId")
	private Integer userId;
	// 试题id
    @ApiModelProperty(value = "试题id" ,name = "questionId")
	private Integer questionId;
	// 错题时间
    @ApiModelProperty(value = "错题时间" ,name = "createDate")
	private Date createDate;
	// 错题次数
    @ApiModelProperty(value = "错题次数" ,name = "wrongCount")
	private Integer wrongCount;
	// 试题类型  1选择题 2判断题
    @ApiModelProperty(value = "试题类型  1选择题 2判断题" ,name = "questionTypeId")
	private Integer questionTypeId;
	// 试题所属得岗位类型id
    @ApiModelProperty(value = "试题所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;

}