/**
 * @filename:UserService 2019.12.20
 * @project viewwork2019  V1.0
 * Copyright(c) 2018 HuangJunWei Co. Ltd. 
 * All right reserved. 
 */
package com.buybit.wm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.buybit.wm.entity.User;
/**   
 *  
 * @Description:  用户����SERVICE
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
public interface UserService {
	
	/**
	 * @explain ��ѯ用户����
	 * @param   ���������id
	 * @return  User
	 * @author  HuangJunWei
	 */
	public User selectByPrimaryKey(Long id);
	
	/**
	 * @explain ɾ��用户����
	 * @param   ���������id
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * @explain ���用户����
	 * @param   ���������User
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int insertSelective(User user);
	
	/**
	 * @explain �޸�用户����
	 * @param   ���������User
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int updateByPrimaryKeySelective(User user);
	
	/**
	 * @explain ��ѯ用户����
	 * @param   ���������User
	 * @return  List<User>
	 * @author  HuangJunWei
	 */
	public List<User> queryUserList(User user);
	
	/**
	 * @explain ��ҳ��ѯ用户
	 * @param   ���������User
	 * @return  PageInfo<User>
	 * @author  HuangJunWei
	 */
	public PageInfo<User> getUserBySearch(AppPage<User> page);
}