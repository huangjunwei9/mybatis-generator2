/**
 * @filename:UserController 2019.12.20
 * @project viewwork2019  V1.0
 * Copyright(c) 2018 HuangJunWei Co. Ltd. 
 * All right reserved. 
 */
package com.buybit.wm.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.item.util.JsonResult;
import com.buybit.wm.entity.User;
import com.buybit.wm.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
 * 
 * @Description:  用户�ӿڲ�
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
@Api(description = "用户",value="用户" )
@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public UserService userServiceImpl;
	
	/**
	 * @explain ��ѯ用户����  <swagger GET����>
	 * @param   ���������id
	 * @return  user
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@GetMapping("/getUserById/{id}")
	@ApiOperation(value = "��ȡ用户��Ϣ", notes = "��ȡ用户��Ϣ[user]�����ߣ�HuangJunWei")
	@ApiImplicitParam(paramType="path", name = "id", value = "用户id", required = true, dataType = "Long")
	public JsonResult<User> getUserById(@PathVariable("id")Long id){
		JsonResult<User> result=new JsonResult<User>();
		try {
			User user=userServiceImpl.selectByPrimaryKey(id);
			if (user!=null) {
				result.setCode(1);
				result.setMessage("�ɹ�");
				result.setData(user);
			} else {
				logger.error("��ȡ用户ʧ��ID��"+id);
				result.setCode(-1);
				result.setMessage("���ȡ��用户������");
			}
		} catch (Exception e) {
			logger.error("��ȡ用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
	
	/**
	 * @explain ���用户����
	 * @param   ���������user
	 * @return  int
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "���用户", notes = "���用户[user],���ߣ�HuangJunWei")
	public JsonResult<User> insertSelective(User user){
		JsonResult<User> result=new JsonResult<User>();
		try {
			int rg=userServiceImpl.insertSelective(user);
			if (rg>0) {
				result.setCode(1);
				result.setMessage("�ɹ�");
				result.setData(user);
			} else {
				logger.error("���用户ִ��ʧ�ܣ�"+user.toString());
				result.setCode(-1);
				result.setMessage("ִ��ʧ�ܣ����Ժ�����");
			}
		} catch (Exception e) {
			logger.error("���用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
	
	/**
	 * @explain ɾ��用户����
	 * @param   ���������id
	 * @return  int
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "ɾ��用户", notes = "ɾ��用户,���ߣ�HuangJunWei")
	@ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = true, dataType = "Long")
	public JsonResult<Object> deleteByPrimaryKey(Long id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			int reg=userServiceImpl.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("�ɹ�");
				result.setData(id);
			} else {
				logger.error("ɾ��用户ʧ��ID��"+id);
				result.setCode(-1);
				result.setMessage("ִ�д������Ժ�����");
			}
		} catch (Exception e) {
			logger.error("ɾ��用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
	
	/**
	 * @explain �޸�用户����
	 * @param   ���������user
	 * @return  user
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@ApiOperation(value = "�޸�用户", notes = "�޸�用户[user],���ߣ�HuangJunWei")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult<User> updateByPrimaryKeySelective(User user){
		JsonResult<User> result=new JsonResult<User>();
		try {
			int reg = userServiceImpl.updateByPrimaryKeySelective(user);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("�ɹ�");
				result.setData(user);
			} else {
				logger.error("�޸�用户ʧ��ID��"+user.toString());
				result.setCode(-1);
				result.setMessage("ִ�д������Ժ�����");
			}
		} catch (Exception e) {
			logger.error("�޸�用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
	
	/**
	 * @explain ��ȡƥ��用户
	 * @param   ���������user
	 * @return  List<User>
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@ApiOperation(value = "������ѯ用户", notes = "������ѯ[user],���ߣ�HuangJunWei")
	@PostMapping("/queryUserList")
	public JsonResult<List<User>> queryUserList(User user){
		JsonResult<List<User>> result=new JsonResult<List<User>>();
		try {
			List<User> list = userServiceImpl.queryUserList(user);
			result.setCode(1);
			result.setMessage("�ɹ�");
			result.setData(list);
		} catch (Exception e) {
			logger.error("��ȡ用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
	
	/**
	 * @explain ��ҳ������ѯ用户   
	 * @param   ���������AppPage<User>
	 * @return  PageInfo<User>
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@GetMapping("/getPageUser")
	@ApiOperation(value = "��ҳ��ѯ", notes = "��ҳ��ѯ���ض���[PageInfo<User>],���ߣ�����")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "��ǰҳ", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "ҳ����", required = true, dataType = "int")
    })
	public JsonResult<PageInfo<User>> getUserBySearch(Integer pageNum,Integer pageSize){
		JsonResult<PageInfo<User>> result=new JsonResult<PageInfo<User>>();
		AppPage<User> page =new AppPage<User>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		//��������
		User user=new User();
		page.setParam(user);
		//��ҳ����
		try {
			PageInfo<User> pageInfo = userServiceImpl.getUserBySearch(page);
			result.setCode(1);
			result.setMessage("�ɹ�");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("��ҳ��ѯ用户ִ���쳣��"+e.getMessage());
			result.setCode(-1);
			result.setMessage("ִ���쳣�����Ժ�����");
		}
		return result;
	}
}