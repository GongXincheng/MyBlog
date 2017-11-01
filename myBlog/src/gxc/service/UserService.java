package gxc.service;

import java.util.List;

import gxc.domain.User;

public interface UserService {

	/**
	 * 保存用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 通过用户名和密码查询用户
	 * @param user
	 * @return
	 */
	public User findUserByUsernameAndPassword(User user);
	
	/**
	 * 根据用户ID查询用户
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据用户名查询用户(判断用户名是否存在)
	 * @param username
	 * @return
	 */
	public User findUserByUsername(String username);
	
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<User> findAllUser();
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int editUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public int removeUser(int uid);
	
	/**
	 * 修改登录次数
	 * @param uid
	 */
	public void updateLoginNum(String username);
	
	/**
	 * 修改上次登录时间
	 * @param uid
	 */
	public void updateLastLoginDate(String username);

	/**
	 * 修改头像
	 * @param user
	 */
	public void editHead(User user);
}
