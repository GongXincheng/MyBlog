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
	public int removeUser(User user);
	
}
