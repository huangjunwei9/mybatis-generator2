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
 * @Description:  鐢ㄦ埛——SERVICE
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
public interface UserService {
	
	/**
	 * @explain 查询鐢ㄦ埛对象
	 * @param   对象参数：id
	 * @return  User
	 * @author  HuangJunWei
	 */
	public User selectByPrimaryKey(Long id);
	
	/**
	 * @explain 删除鐢ㄦ埛对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * @explain 添加鐢ㄦ埛对象
	 * @param   对象参数：User
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int insertSelective(User user);
	
	/**
	 * @explain 修改鐢ㄦ埛对象
	 * @param   对象参数：User
	 * @return  int
	 * @author  HuangJunWei
	 */
	public int updateByPrimaryKeySelective(User user);
	
	/**
	 * @explain 查询鐢ㄦ埛集合
	 * @param   对象参数：User
	 * @return  List<User>
	 * @author  HuangJunWei
	 */
	public List<User> queryUserList(User user);
	
	/**
	 * @explain 分页查询鐢ㄦ埛
	 * @param   对象参数：User
	 * @return  PageInfo<User>
	 * @author  HuangJunWei
	 */
	public PageInfo<User> getUserBySearch(AppPage<User> page);
}