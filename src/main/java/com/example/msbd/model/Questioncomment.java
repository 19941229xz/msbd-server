package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Questioncomment" ,description = "试题评论表")
@Data  // 自动生成get set 和构造器
public class Questioncomment implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 评论内容
    @ApiModelProperty(value = "评论内容" ,name = "commentContent")
	private String commentContent;
	// 评论用户id
    @ApiModelProperty(value = "评论用户id" ,name = "commentUserId")
	private Integer commentUserId;
	// 评论时间
    @ApiModelProperty(value = "评论时间" ,name = "commentDate")
	private Date commentDate;
	// 评论用户头像
    @ApiModelProperty(value = "评论用户头像" ,name = "commentUserHeadPic")
	private String commentUserHeadPic;
	// 评论用户昵称
    @ApiModelProperty(value = "评论用户昵称" ,name = "commentUserNickName")
	private String commentUserNickName;
	// 评论用户真实姓名
    @ApiModelProperty(value = "评论用户真实姓名" ,name = "commentUserRealName")
	private String commentUserRealName;
	// 评论用户性别 1男 2女
    @ApiModelProperty(value = "评论用户性别 1男 2女" ,name = "commentUserGender")
	private Integer commentUserGender;
	// 点赞数
    @ApiModelProperty(value = "点赞数" ,name = "favorNum")
	private Integer favorNum;
	// 评论所属问题id
    @ApiModelProperty(value = "评论所属问题id" ,name = "questionId")
	private Integer questionId;
	// 评论所属问题
    @ApiModelProperty(value = "评论所属问题" ,name = "questionName")
	private String questionName;
	// 该题的创建者id
    @ApiModelProperty(value = "该题的创建者id" ,name = "questionCreateUserId")
	private Integer questionCreateUserId;
	// 该题创建者真实姓名
    @ApiModelProperty(value = "该题创建者真实姓名" ,name = "questionCreateUserRealName")
	private String questionCreateUserRealName;
	// 该题创建者昵称
    @ApiModelProperty(value = "该题创建者昵称" ,name = "questionCreateUserNickName")
	private String questionCreateUserNickName;

}