package gxc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gxc.dao.TopicDao;
import gxc.domain.Topic;
import gxc.domain.User;
import gxc.utils.HibernateUtil;

public class TopicDaoImpl implements TopicDao {

	@Override
	public void addTopic(User user, Topic topic) {
		Session session = HibernateUtil.getCurrentSession();
		topic.setUser(user);
		session.save(topic);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Topic> findAllTopic(String order) {
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery("from Topic t order by t.createDate "+order);
		List<Topic> list = (List<Topic>)query.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Topic> findAllByVisiteNum() {
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery("from Topic t order by visitNum desc");
		List<Topic> list = (List<Topic>)query.list();
		return list;
	}

	@Override
	public Topic findTopicById(Integer tid) {
		Session session = HibernateUtil.getCurrentSession();
		Topic topic = (Topic)session.get(Topic.class, tid);
		return topic;
	}

}
