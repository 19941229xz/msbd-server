package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Questioncollection" ,description = "试题收藏")
@Data  // 自动生成get set 和构造器
public class Questioncollection implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 收藏人id
    @ApiModelProperty(value = "收藏人id" ,name = "collectUserId")
	private Integer collectUserId;
	// 被收藏的试题id
    @ApiModelProperty(value = "被收藏的试题id" ,name = "questionId")
	private Integer questionId;
	// 收藏时间
    @ApiModelProperty(value = "收藏时间" ,name = "collectDate")
	private Date collectDate;
	// 试题类型  1选择题 2判断题
    @ApiModelProperty(value = "试题类型  1选择题 2判断题" ,name = "questionTypeId")
	private Integer questionTypeId;
	// 问题所属得岗位类型id
    @ApiModelProperty(value = "问题所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;

}