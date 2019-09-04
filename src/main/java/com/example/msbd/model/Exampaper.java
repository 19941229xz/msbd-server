package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Exampaper" ,description = "试卷")
@Data  // 自动生成get set 和构造器
public class Exampaper implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 试卷名称
    @ApiModelProperty(value = "试卷名称" ,name = "examPaperName")
	private String examPaperName;
	// 出题人id
    @ApiModelProperty(value = "出题人id" ,name = "createUserId")
	private Integer createUserId;
	// 命题时间
    @ApiModelProperty(value = "命题时间" ,name = "createDate")
	private Date createDate;
	// 出题人头像
    @ApiModelProperty(value = "出题人头像" ,name = "userHeadPic")
	private String userHeadPic;
	// 出题人昵称
    @ApiModelProperty(value = "出题人昵称" ,name = "userNickName")
	private String userNickName;
	// 出题人真实姓名
    @ApiModelProperty(value = "出题人真实姓名" ,name = "userRealName")
	private String userRealName;
	// 试卷所属得岗位类型id
    @ApiModelProperty(value = "试卷所属得岗位类型id" ,name = "questionJobTypeId")
	private Integer questionJobTypeId;
	// 所属岗位名称
    @ApiModelProperty(value = "所属岗位名称" ,name = "questionJobTypeName")
	private String questionJobTypeName;
	// 考试规定时长（单位秒）
    @ApiModelProperty(value = "考试规定时长（单位秒）" ,name = "examTime")
	private Long examTime;
	// 试卷所属班级id
    @ApiModelProperty(value = "试卷所属班级id" ,name = "banjiId")
	private Integer banjiId;
	// 所属班级
    @ApiModelProperty(value = "所属班级" ,name = "banjiName")
	private String banjiName;
	// 所属公司id
    @ApiModelProperty(value = "所属公司id" ,name = "companyId")
	private Integer companyId;
	// 所属学校id
    @ApiModelProperty(value = "所属学校id" ,name = "schoolId")
	private Integer schoolId;
	// 试卷可浏览级别 1完全公开 2对学校或公司公开 3只对班级公开
    @ApiModelProperty(value = "试卷可浏览级别 1完全公开 2对学校或公司公开 3只对班级公开" ,name = "publicLevel")
	private Integer publicLevel;
	// 试卷是否审核 1 未审核  2已审核
    @ApiModelProperty(value = "试卷是否审核 1 未审核  2已审核" ,name = "isChecked")
	private Integer isChecked;
	// 审核人id
    @ApiModelProperty(value = "审核人id" ,name = "checkUserId")
	private Integer checkUserId;
	// 审核时间
    @ApiModelProperty(value = "审核时间" ,name = "checkDate")
	private Date checkDate;
	// 审核人真实姓名
    @ApiModelProperty(value = "审核人真实姓名" ,name = "checkUserRealName")
	private String checkUserRealName;
	// 审核人昵称
    @ApiModelProperty(value = "审核人昵称" ,name = "checkUserNickName")
	private String checkUserNickName;

}