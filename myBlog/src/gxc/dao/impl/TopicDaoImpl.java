package gxc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gxc.dao.TopicDao;
import gxc.domain.Topic;
import gxc.domain.User;
import gxc.utils.HibernateUtil;

public class TopicDaoImpl implements TopicDao {

	public void addTopic(User user, Topic topic) {
		Session session = HibernateUtil.getCurrentSession();
		topic.setUser(user);
		session.save(topic);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllTopic(String order) {
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery("from Topic t order by t.createDate "+order);
		List<Topic> list = (List<Topic>)query.list();
		return list;
	}

}
