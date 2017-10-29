package gxc.service.impl;

import java.util.List;

import gxc.dao.UserDao;
import gxc.dao.impl.UserDaoImpl;
import gxc.domain.User;
import gxc.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void addUser(User user) {
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
	public int removeUser(User user) {
		int count = userDao.deleteUser(user);
		return count;
	}

}
