package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Useranserquestion" ,description = "用户答题记录")
@Data  // 自动生成get set 和构造器
public class Useranserquestion implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 试题id
    @ApiModelProperty(value = "试题id" ,name = "questionId")
	private Integer questionId;
	// 试题类型  1选择题（单选） 2判断题 3多选题
    @ApiModelProperty(value = "试题类型  1选择题（单选） 2判断题 3多选题" ,name = "questionTypeId")
	private Integer questionTypeId;
	// 问题所属得岗位类型id
    @ApiModelProperty(value = "问题所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;
	// 答题人id
    @ApiModelProperty(value = "答题人id" ,name = "answerUserId")
	private Integer answerUserId;
	// 答题时间
    @ApiModelProperty(value = "答题时间" ,name = "answerDate")
	private Date answerDate;
	// 是否回答正确  1 正确  2错误
    @ApiModelProperty(value = "是否回答正确  1 正确  2错误" ,name = "answerIsRight")
	private Integer answerIsRight;

}