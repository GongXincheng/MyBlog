package com.gxc.user.dao;

import com.gxc.user.domain.User;

public interface UserDao{

	/**
	 * 根据用户名和密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findUserByUsernamePwd(String username, String password);

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

	/**
	 * 更新用户信息
	 * @param dbUser
	 */
	void update(User dbUser);

}
