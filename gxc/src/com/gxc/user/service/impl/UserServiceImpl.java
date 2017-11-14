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
		User loginUser = userDao.findUserByUsernamePwd(user.getUsername(),user.getPassword());
		
		//判断用户是否存在
		if(loginUser!=null){
			//更新登录次数，和登陆时间
			loginUser.setLoginNum(loginUser.getLoginNum()+1);
			loginUser.setLastLoginDate(new Date());
			userDao.update(loginUser);
			
			User dbUser = userDao.findUserById(loginUser.getUserId());
			return dbUser;
		}
		else{
			return null;
		}
		
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

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser(User user) {
		User dbUser = userDao.findUserById(user.getUserId());
		dbUser.setRealname(user.getRealname());
		dbUser.setGender(user.getGender());
		dbUser.setSign(user.getSign());
		dbUser.setTelephone(user.getTelephone());
		dbUser.setEmail(user.getEmail());
		dbUser.setNote(user.getNote());
		dbUser.setCity(user.getCity());
	}

	/**
	 * 修改头像
	 */
	@Override
	public void updateHead(User user) {
		User dbUser = userDao.findUserById(user.getUserId());
		dbUser.setFace(user.getFace());
	}
	
	
}
