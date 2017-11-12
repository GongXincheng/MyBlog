package com.gxc.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.user.dao.UserDao;
import com.gxc.user.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	/**
	 * 根据用户名和密码查找用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsernamePwd(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> list = this.getHibernateTemplate().find(hql,username,password);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据userId查询用户
	 */
	@Override
	public User findUserById(String userId) {
		User user = this.getHibernateTemplate().get(User.class, userId);
		return user;
	}

	/**
	 * 根据用户名查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ?",username);
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 注册
	 */
	@Override
	public void regist(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	
}
