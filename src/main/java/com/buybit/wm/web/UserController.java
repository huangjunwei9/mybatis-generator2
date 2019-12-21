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
 * @Description:  鐢ㄦ埛接口层
 * @Author:       HuangJunWei   
 * @CreateDate:   2019.12.20
 * @Version:      V1.0
 *    
 */
@Api(description = "鐢ㄦ埛",value="鐢ㄦ埛" )
@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public UserService userServiceImpl;
	
	/**
	 * @explain 查询鐢ㄦ埛对象  <swagger GET请求>
	 * @param   对象参数：id
	 * @return  user
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@GetMapping("/getUserById/{id}")
	@ApiOperation(value = "获取鐢ㄦ埛信息", notes = "获取鐢ㄦ埛信息[user]，作者：HuangJunWei")
	@ApiImplicitParam(paramType="path", name = "id", value = "鐢ㄦ埛id", required = true, dataType = "Long")
	public JsonResult<User> getUserById(@PathVariable("id")Long id){
		JsonResult<User> result=new JsonResult<User>();
		try {
			User user=userServiceImpl.selectByPrimaryKey(id);
			if (user!=null) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(user);
			} else {
				logger.error("获取鐢ㄦ埛失败ID："+id);
				result.setCode(-1);
				result.setMessage("你获取的鐢ㄦ埛不存在");
			}
		} catch (Exception e) {
			logger.error("获取鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 添加鐢ㄦ埛对象
	 * @param   对象参数：user
	 * @return  int
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加鐢ㄦ埛", notes = "添加鐢ㄦ埛[user],作者：HuangJunWei")
	public JsonResult<User> insertSelective(User user){
		JsonResult<User> result=new JsonResult<User>();
		try {
			int rg=userServiceImpl.insertSelective(user);
			if (rg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(user);
			} else {
				logger.error("添加鐢ㄦ埛执行失败："+user.toString());
				result.setCode(-1);
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 删除鐢ㄦ埛对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除鐢ㄦ埛", notes = "删除鐢ㄦ埛,作者：HuangJunWei")
	@ApiImplicitParam(paramType="query", name = "id", value = "鐢ㄦ埛id", required = true, dataType = "Long")
	public JsonResult<Object> deleteByPrimaryKey(Long id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			int reg=userServiceImpl.deleteByPrimaryKey(id);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除鐢ㄦ埛失败ID："+id);
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 修改鐢ㄦ埛对象
	 * @param   对象参数：user
	 * @return  user
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@ApiOperation(value = "修改鐢ㄦ埛", notes = "修改鐢ㄦ埛[user],作者：HuangJunWei")
	@PostMapping("/updateByPrimaryKeySelective")
	public JsonResult<User> updateByPrimaryKeySelective(User user){
		JsonResult<User> result=new JsonResult<User>();
		try {
			int reg = userServiceImpl.updateByPrimaryKeySelective(user);
			if (reg>0) {
				result.setCode(1);
				result.setMessage("成功");
				result.setData(user);
			} else {
				logger.error("修改鐢ㄦ埛失败ID："+user.toString());
				result.setCode(-1);
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("修改鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 获取匹配鐢ㄦ埛
	 * @param   对象参数：user
	 * @return  List<User>
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@ApiOperation(value = "条件查询鐢ㄦ埛", notes = "条件查询[user],作者：HuangJunWei")
	@PostMapping("/queryUserList")
	public JsonResult<List<User>> queryUserList(User user){
		JsonResult<List<User>> result=new JsonResult<List<User>>();
		try {
			List<User> list = userServiceImpl.queryUserList(user);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(list);
		} catch (Exception e) {
			logger.error("获取鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询鐢ㄦ埛   
	 * @param   对象参数：AppPage<User>
	 * @return  PageInfo<User>
	 * @author  HuangJunWei
	 * @time    2019.12.20
	 */
	@GetMapping("/getPageUser")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[PageInfo<User>],作者：边鹏")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult<PageInfo<User>> getUserBySearch(Integer pageNum,Integer pageSize){
		JsonResult<PageInfo<User>> result=new JsonResult<PageInfo<User>>();
		AppPage<User> page =new AppPage<User>();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		//其他参数
		User user=new User();
		page.setParam(user);
		//分页数据
		try {
			PageInfo<User> pageInfo = userServiceImpl.getUserBySearch(page);
			result.setCode(1);
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询鐢ㄦ埛执行异常："+e.getMessage());
			result.setCode(-1);
			result.setMessage("执行异常，请稍后重试");
		}
		return result;
	}
}