package com.example.msbd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "Questionjobtype" ,description = "试题所属职位")
@Data  // 自动生成get set 和构造器
public class Questionjobtype implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 问题所属职位名称
    @ApiModelProperty(value = "问题所属职位名称" ,name = "questionJobTypeName")
	private String questionJobTypeName;
	// 是否审核  1未审核  2已审核
    @ApiModelProperty(value = "是否审核  1未审核  2已审核" ,name = "isChecked")
	private Integer isChecked;

}