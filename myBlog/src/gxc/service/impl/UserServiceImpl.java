package gxc.service.impl;

import java.util.Date;
import java.util.List;

import gxc.dao.UserDao;
import gxc.dao.impl.UserDaoImpl;
import gxc.domain.User;
import gxc.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void addUser(User user) {
		//设置注册时间,权限,登录次数
		user.setRegistDate(new Date());
		user.setRole(0);
		user.setLoginNum(0);
		userDao.saveUser(user);
	}

	@Override
	public User findUserByUsernameAndPassword(User user) {
		User user1 = userDao.findUserByUsernameAndPassword(user);
		return user1;
	}

	@Override
	public User findUserById(Integer id) {
		User user1 = userDao.findUserById(id);
		return user1;
	}
	
	@Override
	public User findUserByUsername(String username) {
		User user = userDao.findUserByUsername(username);
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> list = userDao.findAllUser();
		return list;
	}

	@Override
	public int editUser(User user) {
		int count = userDao.updateUser(user);
		return count;
	}

	@Override
	public int removeUser(int uid) {
		int count = userDao.deleteUser(uid);
		return count;
	}

	@Override
	public void updateLoginNum(String username) {
		userDao.updateLoginNum(username);
	}

	@Override
	public void updateLastLoginDate(String username) {
		userDao.updateLastLoginDate(username);
	}

}
