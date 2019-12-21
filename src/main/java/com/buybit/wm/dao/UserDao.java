/**
 * @filename:UserDao 2019.12.20
 * @project viewwork2019  V1.0
 * Copyright(c) 2018 HuangJunWei Co. Ltd. 
 * All right reserved. 
 */
package com.buybit.wm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.buybit.wm.entity.User;

/**   
 *  
 * @Description:  ç”¨æˆ·¡ª¡ªDAO
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
@Mapper
public interface UserDao {
	
	public User selectByPrimaryKey(Long id);
	
	public int deleteByPrimaryKey(Long id);
	
	public int insertSelective(User user);
	
	public int updateByPrimaryKeySelective(User user);
	
	public List<User> queryUserList(User user);
}
