package com.gxc.user.service.impl;

import java.util.Date;

import com.gxc.user.dao.UserDao;
import com.gxc.user.domain.User;
import com.gxc.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 登录
	 */
	@Override
	public User login(User user) {
		User dbUser = userDao.findUserByUsernamePwd(user.getUsername(),user.getPassword());
		
		if(dbUser!=null){
			dbUser.setLoginNum(dbUser.getLoginNum()+1);
			dbUser.setLastLoginDate(new Date());
		}
		
		return dbUser;
	}

	/**
	 * 根据userId查询用户
	 */
	@Override
	public User findUserById(String userId) {
		User user = userDao.findUserById(userId);
		return user;
	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	/**
	 * 注册
	 */
	@Override
	public void regist(User user) {
		//设置注册时间,权限,登录次数
		user.setRegistDate(new Date());
		user.setGender("男");
		user.setRole(0);
		user.setLoginNum(0);
		user.setFace("head_00.jpg");
		userDao.regist(user);
	}
	
	
}
