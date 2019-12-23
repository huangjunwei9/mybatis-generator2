/**
 * @filename:User 2019.12.20
 * @project viewwork2019  V1.0
 * Copyright(c) 2018 HuangJunWei Co. Ltd. 
 * All right reserved. 
 */
package com.buybit.wm.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**   
 *  
 * @Description:  鐢ㄦ埛
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1576893969271L;
	
	@ApiModelProperty(name = "id" , value = "")
	private Long id;
	@ApiModelProperty(name = "username" , value = "用户id，即学号（帐号中可能存在字符）")
	private String username;
	@ApiModelProperty(name = "password" , value = "用户密码")
	private String password;
	@ApiModelProperty(name = "realname" , value = "用户姓名")
	private String realname;
	@ApiModelProperty(name = "identitySign" , value = "用户身份（ 1：学生 2：教师 3：管理员）")
	private Integer identitySign;
	@ApiModelProperty(name = "collegeName" , value = "学院名称")
	private String collegeName;
	@ApiModelProperty(name = "majorName" , value = "专业名称")
	private String majorName;
	@ApiModelProperty(name = "className" , value = "班级名称")
	private String className;
	@ApiModelProperty(name = "email" , value = "邮箱")
	private String email;
	@ApiModelProperty(name = "phone" , value = "手机号码")
	private String phone;
	@ApiModelProperty(name = "status" , value = "登录状态")
	private Integer status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "operateTime" , value = "最后一次更新时间")
	private Date operateTime;
	@ApiModelProperty(name = "operateIp" , value = "记录操作者的ip")
	private String operateIp;
	@ApiModelProperty(name = "operator" , value = "操作者（存储的是user表的id）")
	private Long operator;
	@ApiModelProperty(name = "delFlag" , value = "删除标志（软删除。0：未删除；与id相同的数字：表示已删除）")
	private Long delFlag;
	@ApiModelProperty(name = "remark" , value = "备注内容")
	private String remark;
}
