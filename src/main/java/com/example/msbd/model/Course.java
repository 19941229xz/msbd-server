package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Course" ,description = "课程")
@Data  // 自动生成get set 和构造器
public class Course implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 课程名称
    @ApiModelProperty(value = "课程名称" ,name = "courseName")
	private String courseName;
	// 课程介绍图片1
    @ApiModelProperty(value = "课程介绍图片1" ,name = "coursePic1")
	private String coursePic1;
	// 课程介绍图片2
    @ApiModelProperty(value = "课程介绍图片2" ,name = "coursePic2")
	private String coursePic2;
	// 课程介绍图片3
    @ApiModelProperty(value = "课程介绍图片3" ,name = "coursePic3")
	private String coursePic3;
	// 课程介绍图片4
    @ApiModelProperty(value = "课程介绍图片4" ,name = "coursePic4")
	private String coursePic4;
	// 所需积分
    @ApiModelProperty(value = "所需积分" ,name = "pointsNeed")
	private String pointsNeed;
	// 创建人id
    @ApiModelProperty(value = "创建人id" ,name = "createUserId")
	private Integer createUserId;
	// 创建人真实姓名
    @ApiModelProperty(value = "创建人真实姓名" ,name = "createUserRealName")
	private String createUserRealName;
	// 创建人昵称
    @ApiModelProperty(value = "创建人昵称" ,name = "createUserNickName")
	private String createUserNickName;
	// 审核人账号
    @ApiModelProperty(value = "审核人账号" ,name = "createUserName")
	private String createUserName;
	// 创建时间
    @ApiModelProperty(value = "创建时间" ,name = "createDate")
	private Date createDate;
	// 审核人id
    @ApiModelProperty(value = "审核人id" ,name = "checkUserId")
	private Integer checkUserId;
	// 审核人真实姓名
    @ApiModelProperty(value = "审核人真实姓名" ,name = "checkUserRealName")
	private String checkUserRealName;
	// 审核人昵称
    @ApiModelProperty(value = "审核人昵称" ,name = "checkUserNickName")
	private String checkUserNickName;
	// 审核人账号
    @ApiModelProperty(value = "审核人账号" ,name = "checkUserName")
	private String checkUserName;
	// 是否审核  1未审核 2已审核
    @ApiModelProperty(value = "是否审核  1未审核 2已审核" ,name = "isChecked")
	private Integer isChecked;
	// 审核时间
    @ApiModelProperty(value = "审核时间" ,name = "checkDate")
	private Date checkDate;
	// 网盘下载链接
    @ApiModelProperty(value = "网盘下载链接" ,name = "downloadUrl")
	private String downloadUrl;
	// 网盘下载密码
    @ApiModelProperty(value = "网盘下载密码" ,name = "downloadPwd")
	private String downloadPwd;
	// 课程二维码
    @ApiModelProperty(value = "课程二维码" ,name = "courseQrcode")
	private String courseQrcode;
	// 浏览次数
    @ApiModelProperty(value = "浏览次数" ,name = "viewNum")
	private Integer viewNum;
	// 购买次数
    @ApiModelProperty(value = "购买次数" ,name = "buyNum")
	private Integer buyNum;
	// 长按识别次数
    @ApiModelProperty(value = "长按识别次数" ,name = "longTabNum")
	private Integer longTabNum;
	// 备注
    @ApiModelProperty(value = "备注" ,name = "remark")
	private String remark;
	// 课程所属岗位id
    @ApiModelProperty(value = "课程所属岗位id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;
	// 课程所属岗位名称
    @ApiModelProperty(value = "课程所属岗位名称" ,name = "questionJobTypeName")
	private String questionJobTypeName;

}