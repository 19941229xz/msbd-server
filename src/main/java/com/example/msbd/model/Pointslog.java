package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Pointslog" ,description = "积分记录表")
@Data  // 自动生成get set 和构造器
public class Pointslog implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 积分变化类型 1消费 2充值 3奖励 4提现
    @ApiModelProperty(value = "积分变化类型 1消费 2充值 3奖励 4提现" ,name = "changeType")
	private Integer changeType;
	// 创建时间
    @ApiModelProperty(value = "创建时间" ,name = "createDate")
	private Date createDate;
	// 积分所属用户id
    @ApiModelProperty(value = "积分所属用户id" ,name = "belongUserId")
	private Integer belongUserId;
	// 积分所属用户账号
    @ApiModelProperty(value = "积分所属用户账号" ,name = "belongUserName")
	private String belongUserName;
	// 积分所属用户昵称
    @ApiModelProperty(value = "积分所属用户昵称" ,name = "belongUserNIckName")
	private String belongUserNIckName;
	// 积分所属用户真实姓名
    @ApiModelProperty(value = "积分所属用户真实姓名" ,name = "belongUserRealName")
	private String belongUserRealName;
	// 积分所属用户头像
    @ApiModelProperty(value = "积分所属用户头像" ,name = "belongUserHeadPic")
	private String belongUserHeadPic;
	// 消费类型 1购买课程 2开通详细解释
    @ApiModelProperty(value = "消费类型 1购买课程 2开通详细解释" ,name = "consumeType")
	private Integer consumeType;
	// 消费类型解释
    @ApiModelProperty(value = "消费类型解释" ,name = "consumeTypeStr")
	private String consumeTypeStr;
	// 积分变化量
    @ApiModelProperty(value = "积分变化量" ,name = "changePoints")
	private Integer changePoints;
	// 购买的课程id
    @ApiModelProperty(value = "购买的课程id" ,name = "buyCourseId")
	private Integer buyCourseId;
	// 购买的课程的名称
    @ApiModelProperty(value = "购买的课程的名称" ,name = "buyCourseName")
	private String buyCourseName;

}