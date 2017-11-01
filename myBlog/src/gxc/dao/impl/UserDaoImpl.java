package gxc.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import gxc.dao.UserDao;
import gxc.domain.User;
import gxc.utils.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	/**
	 * 添加
	 */
	@Override
	public void saveUser(User user) {
		Session session = HibernateUtil.getCurrentSession();
		session.save(user);
	}

	/**
	 *  登录
	 */
	@Override
	public User findUserByUsernameAndPassword(User user) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "from User u where u.username = :name and u.password = :pwd";
		Query query = session.createQuery(hql);
		query.setString("name", user.getUsername());
		query.setString("pwd", user.getPassword());
		
		User dbUser = (User) query.uniqueResult();
		
		return dbUser;
	}
	
	/**
	 * 根据id获取用户
	 */
	@Override
	public User findUserById(Integer id) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "from User u where u.uid = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		User user = (User) query.uniqueResult();
		
		return user;
	}

	/**
	 * 根据用户名查询用户(判断用户名是否存在)
	 */
	@Override
	public User findUserByUsername(String username) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "from User u where u.username = :username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	/**
	 * 查询全部用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUser() {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from User");
		List<User> list = (List<User>)query.list();
		
		return list;
	}

	/**
	 * 更新
	 */
	@Override
	public int updateUser(User user) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "update User u set "
				+ " u.realname = :realname,"
				+ " u.gender = :gender ,"
				+ " u.sign = :sign ,"
				+ " u.province = :province ,"
				+ " u.city = :city ,"
				+ " u.email = :email ,"
				+ " u.telephone = :telephone ,"
				+ " u.note =:note "
				+ " where u.uid = :id";
		
		Query query = session.createQuery(hql);
		query.setString("realname", user.getRealname());
		query.setInteger("gender", user.getGender());
		query.setString("sign", user.getSign());
		query.setString("province", user.getProvince());
		query.setString("city", user.getCity());
		query.setString("email", user.getEmail());
		query.setString("telephone", user.getTelephone());
		query.setString("note", user.getNote());
		query.setInteger("id", user.getUid());
		
		int count = query.executeUpdate();
		return count;
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteUser(int uid) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "delete from User u where u.uid = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", uid);
		
		int count = query.executeUpdate();
		
		return count;
	}

	/**
	 * 修改登录次数
	 */
	@Override
	public void updateLoginNum(String username) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "update User u set u.loginNum = u.loginNum + 1 where u.username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		
		query.executeUpdate();
	}

	/**
	 * 修改上次登录时间
	 * @param uid
	 */
	@Override
	public void updateLastLoginDate(String username) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "update User u set u.lastLoginDate=:date where username=:username";
		Query query = session.createQuery(hql);
		query.setTimestamp("date", new Date());
		query.setString("username", username);
		
		query.executeUpdate();
		
	}

	/**
	 * 修改头像
	 */
	@Override
	public void updateFace(User user) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "update User u set u.face=:face where u.uid=:id";
		Query query = session.createQuery(hql);
		query.setString("face", user.getFace());
		query.setInteger("id", user.getUid());
		
		query.executeUpdate();
	}

}
