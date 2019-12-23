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
 * @Description:  用户
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
	@ApiModelProperty(name = "username" , value = "�û�id����ѧ�ţ��ʺ��п��ܴ����ַ���")
	private String username;
	@ApiModelProperty(name = "password" , value = "�û�����")
	private String password;
	@ApiModelProperty(name = "realname" , value = "�û�����")
	private String realname;
	@ApiModelProperty(name = "identitySign" , value = "�û���ݣ� 1��ѧ�� 2����ʦ 3������Ա��")
	private Integer identitySign;
	@ApiModelProperty(name = "collegeName" , value = "ѧԺ����")
	private String collegeName;
	@ApiModelProperty(name = "majorName" , value = "רҵ����")
	private String majorName;
	@ApiModelProperty(name = "className" , value = "�༶����")
	private String className;
	@ApiModelProperty(name = "email" , value = "����")
	private String email;
	@ApiModelProperty(name = "phone" , value = "�ֻ�����")
	private String phone;
	@ApiModelProperty(name = "status" , value = "��¼״̬")
	private Integer status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@ApiModelProperty(name = "operateTime" , value = "���һ�θ���ʱ��")
	private Date operateTime;
	@ApiModelProperty(name = "operateIp" , value = "��¼�����ߵ�ip")
	private String operateIp;
	@ApiModelProperty(name = "operator" , value = "�����ߣ��洢����user���id��")
	private Long operator;
	@ApiModelProperty(name = "delFlag" , value = "ɾ����־����ɾ����0��δɾ������id��ͬ�����֣���ʾ��ɾ����")
	private Long delFlag;
	@ApiModelProperty(name = "remark" , value = "��ע����")
	private String remark;
}
