package com.gxc.user.service;

import com.gxc.user.domain.User;

public interface UserService {

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 根据userId查询用户
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);

	/**
	 * 注册
	 * @param user
	 */
	void regist(User user);

}
