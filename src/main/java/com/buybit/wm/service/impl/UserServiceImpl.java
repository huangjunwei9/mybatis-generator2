/**
 * @filename:UserServiceImpl 2019.12.20
 * @project viewwork2019  V1.0
 * Copyright(c) 2018 HuangJunWei Co. Ltd. 
 * All right reserved. 
 */
package com.buybit.wm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.buybit.wm.entity.User;
import com.buybit.wm.dao.UserDao;
import com.buybit.wm.service.UserService;

/**   
 *  
 * @Description:  用户����SERVICEIMPL
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;
	
	//��ѯ����
	@Override
	public User selectByPrimaryKey(Long id) {
		return userDao.selectByPrimaryKey(id);
	}
	
	//ɾ������
	@Override
	public int deleteByPrimaryKey(Long id) {
		return userDao.deleteByPrimaryKey(id);
	}
	
	//��Ӷ���
	@Override
	public int insertSelective(User user) {
		return userDao.insertSelective(user);
	}
	
	//�޸Ķ���
	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}
	
	//��ѯ����
	@Override
	public List<User> queryUserList(User user) {
		return userDao.queryUserList(user);
	}
	
	//��ҳ��ѯ
	@Override
	public PageInfo<User> getUserBySearch(AppPage<User> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<User> list=userDao.queryUserList(page.getParam());
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}
}