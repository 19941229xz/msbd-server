package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Examresult" ,description = "考试结果")
@Data  // 自动生成get set 和构造器
public class Examresult implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 考试用户id
    @ApiModelProperty(value = "考试用户id" ,name = "userId")
	private Integer userId;
	// 用户昵称
    @ApiModelProperty(value = "用户昵称" ,name = "userNickName")
	private String userNickName;
	// 用户真实姓名
    @ApiModelProperty(value = "用户真实姓名" ,name = "userRealName")
	private String userRealName;
	// 账号
    @ApiModelProperty(value = "账号" ,name = "userName")
	private String userName;
	// 用户头像
    @ApiModelProperty(value = "用户头像" ,name = "userHeadImg")
	private String userHeadImg;
	// 问题所属得岗位类型id
    @ApiModelProperty(value = "问题所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;
	// 考试分数
    @ApiModelProperty(value = "考试分数" ,name = "score")
	private Integer score;
	// 班级id
    @ApiModelProperty(value = "班级id" ,name = "banjiId")
	private Integer banjiId;
	// 班级名称
    @ApiModelProperty(value = "班级名称" ,name = "banjiName")
	private String banjiName;
	// 公司id
    @ApiModelProperty(value = "公司id" ,name = "companyId")
	private Integer companyId;
	// 公司名称
    @ApiModelProperty(value = "公司名称" ,name = "companyName")
	private String companyName;
	// 试题总数
    @ApiModelProperty(value = "试题总数" ,name = "totalQuestionCount")
	private Integer totalQuestionCount;
	// 答错题目数
    @ApiModelProperty(value = "答错题目数" ,name = "wrongAnswerCount")
	private Integer wrongAnswerCount;
	// 学校id
    @ApiModelProperty(value = "学校id" ,name = "schoolId")
	private Integer schoolId;
	// 学校名称
    @ApiModelProperty(value = "学校名称" ,name = "schoolName")
	private String schoolName;
	// 考试是否完成 1未完成 2已完成
    @ApiModelProperty(value = "考试是否完成 1未完成 2已完成" ,name = "isFinished")
	private Integer isFinished;
	// 完成时长
    @ApiModelProperty(value = "完成时长" ,name = "finishTimeLong")
	private Long finishTimeLong;
	// 完成时间
    @ApiModelProperty(value = "完成时间" ,name = "finishiDate")
	private Date finishiDate;
	// 是否最高分 1不是 2是
    @ApiModelProperty(value = "是否最高分 1不是 2是" ,name = "isBest")
	private Integer isBest;
	// 所属试卷id
    @ApiModelProperty(value = "所属试卷id" ,name = "exampaperId")
	private Integer exampaperId;
	// 所属试卷名称
    @ApiModelProperty(value = "所属试卷名称" ,name = "exampaperName")
	private String exampaperName;

}