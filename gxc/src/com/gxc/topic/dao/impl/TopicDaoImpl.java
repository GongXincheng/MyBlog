package com.gxc.topic.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.topic.dao.TopicDao;
import com.gxc.topic.domain.Topic;

public class TopicDaoImpl extends HibernateDaoSupport implements TopicDao {

	/**
	 * 发帖
	 */
	@Override
	public void save(Topic topic) {
		this.getHibernateTemplate().save(topic);
	}

	/**
	 * 获取所有主题(Order)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllTopicByOrder(String order) {
		List<Topic> allTopic = (List<Topic>)this.getHibernateTemplate().find("from Topic order by sendTopicDate "+order);
		return allTopic;
	}

	/**
	 * 根据查看数量排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllByVisiteNum() {
		List<Topic> allTopic = (List<Topic>)this.getHibernateTemplate().find("from Topic order by visitNum desc");
		return allTopic;
	}

	/**
	 * 查看主题内容
	 */
	@Override
	public Topic findTopicById(Integer topicId) {
		Topic topic = this.getHibernateTemplate().get(Topic.class, topicId);
		return topic;
	}
}
