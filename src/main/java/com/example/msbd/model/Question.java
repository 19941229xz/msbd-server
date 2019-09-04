package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Question" ,description = "试题")
@Data  // 自动生成get set 和构造器
public class Question implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 问题
    @ApiModelProperty(value = "问题" ,name = "question")
	private String question;
	// 答案
    @ApiModelProperty(value = "答案" ,name = "answer")
	private String answer;
	// 问题分类：1选择题  2判断题
    @ApiModelProperty(value = "问题分类：1选择题  2判断题" ,name = "questionTypeId")
	private Integer questionTypeId;
	// 问题所属得岗位类型id
    @ApiModelProperty(value = "问题所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;
	// 所属岗位名称
    @ApiModelProperty(value = "所属岗位名称" ,name = "questionJobTypeName")
	private String questionJobTypeName;
	// 题目解析
    @ApiModelProperty(value = "题目解析" ,name = "explaination")
	private String explaination;
	// 题目解析配图1
    @ApiModelProperty(value = "题目解析配图1" ,name = "explainationImg1")
	private String explainationImg1;
	// 题目解析配图2
    @ApiModelProperty(value = "题目解析配图2" ,name = "explainationImg2")
	private String explainationImg2;
	// 题目解析配图3
    @ApiModelProperty(value = "题目解析配图3" ,name = "explainationImg3")
	private String explainationImg3;
	// 题目解析配图4
    @ApiModelProperty(value = "题目解析配图4" ,name = "explainationImg4")
	private String explainationImg4;
	// 选项A
    @ApiModelProperty(value = "选项A" ,name = "optionA")
	private String optionA;
	// 选项B
    @ApiModelProperty(value = "选项B" ,name = "optionB")
	private String optionB;
	// 选项C
    @ApiModelProperty(value = "选项C" ,name = "optionC")
	private String optionC;
	// 选项D
    @ApiModelProperty(value = "选项D" ,name = "optionD")
	private String optionD;
	// 正确选项
    @ApiModelProperty(value = "正确选项" ,name = "rightOption")
	private String rightOption;
	// 问题配图1
    @ApiModelProperty(value = "问题配图1" ,name = "questionImg1")
	private String questionImg1;
	// 问题配图2
    @ApiModelProperty(value = "问题配图2" ,name = "questionImg2")
	private String questionImg2;
	// 问题配图3
    @ApiModelProperty(value = "问题配图3" ,name = "questionImg3")
	private String questionImg3;
	// 问题配图4
    @ApiModelProperty(value = "问题配图4" ,name = "questionImg4")
	private String questionImg4;
	// 详细解释
    @ApiModelProperty(value = "详细解释" ,name = "fullExplaination")
	private String fullExplaination;
	// 详细解释配图1
    @ApiModelProperty(value = "详细解释配图1" ,name = "fullExplainationImg1")
	private String fullExplainationImg1;
	// 详细解释配图2
    @ApiModelProperty(value = "详细解释配图2" ,name = "fullExplainationImg2")
	private String fullExplainationImg2;
	// 详细解释配图3
    @ApiModelProperty(value = "详细解释配图3" ,name = "fullExplainationImg3")
	private String fullExplainationImg3;
	// 详细解释配图4
    @ApiModelProperty(value = "详细解释配图4" ,name = "fullExplainationImg4")
	private String fullExplainationImg4;
	// 所属试卷id
    @ApiModelProperty(value = "所属试卷id" ,name = "examPaperId")
	private Integer examPaperId;
	// 所属试卷名称
    @ApiModelProperty(value = "所属试卷名称" ,name = "examPaperName")
	private String examPaperName;
	// 试题创建人id
    @ApiModelProperty(value = "试题创建人id" ,name = "createUserId")
	private Integer createUserId;
	// 试题创建人头像
    @ApiModelProperty(value = "试题创建人头像" ,name = "createUserHeadPic")
	private String createUserHeadPic;
	// 试题创建人真实姓名
    @ApiModelProperty(value = "试题创建人真实姓名" ,name = "createUserRealName")
	private String createUserRealName;
	// 试题创建人昵称
    @ApiModelProperty(value = "试题创建人昵称" ,name = "createUserNickName")
	private String createUserNickName;
	// 试题评论数
    @ApiModelProperty(value = "试题评论数" ,name = "commentNum")
	private Integer commentNum;
	// 是否审核通过 1未通过 2已通过
    @ApiModelProperty(value = "是否审核通过 1未通过 2已通过" ,name = "isChecked")
	private Integer isChecked;
	// 审核人id
    @ApiModelProperty(value = "审核人id" ,name = "checkUserId")
	private Integer checkUserId;
	// 审核人真实姓名
    @ApiModelProperty(value = "审核人真实姓名" ,name = "checkUserRealName")
	private String checkUserRealName;
	// 审核人昵称
    @ApiModelProperty(value = "审核人昵称" ,name = "checkUserNickName")
	private String checkUserNickName;
	// 审核时间
    @ApiModelProperty(value = "审核时间" ,name = "checkDate")
	private Date checkDate;
	// 试题创建时间
    @ApiModelProperty(value = "试题创建时间" ,name = "createDate")
	private Date createDate;
	// 被回答次数
    @ApiModelProperty(value = "被回答次数" ,name = "answeredNum")
	private Integer answeredNum;
	// 浏览次数
    @ApiModelProperty(value = "浏览次数" ,name = "viewNum")
	private Integer viewNum;
	// 回答错误的次数
    @ApiModelProperty(value = "回答错误的次数" ,name = "answerIsFalseNum")
	private Integer answerIsFalseNum;

}