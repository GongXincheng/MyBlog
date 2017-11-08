package gxc.dao.impl;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import gxc.dao.ReplyDao;
import gxc.dao.TopicDao;
import gxc.dao.UserDao;
import gxc.domain.Reply;
import gxc.domain.Topic;
import gxc.domain.User;
import gxc.utils.HibernateUtil;

public class ReplyDaoImpl implements ReplyDao {

	/**
	 * UserDao、TopicDao
	 */
	UserDao userDao = new UserDaoImpl();
	TopicDao topicDao = new TopicDaoImpl();
	
	/**
	 *  添加回复
	 */
	@Override
	public void addReply(Integer uid, Integer tid, Reply reply) {
		Session session = HibernateUtil.getCurrentSession();
		
		User user = userDao.findUserById(uid);
		Topic topic = topicDao.findTopicById(tid);
		reply.setUser(user);
		reply.setTopic(topic);
		
		session.save(reply);
	}

	/**
	 * 根据帖子的ID，查询所有的回复(顺序)
	 * 暂时不可用
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> findReplyByTid(Integer tid, String order) {
		/*Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery("from Reply r where r.topic.tid = :tid");
		query.setInteger("tid", tid);
		List<Reply> list = (List<Reply>)query.list();
		return list;*/
		Session session = HibernateUtil.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM reply WHERE tid = :tid ORDER BY replyDate desc");
		sqlQuery.setInteger("tid", tid);
		
		List<Reply> list = sqlQuery.list();
		return list;
	}

}
