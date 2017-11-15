package com.gxc.topic.service.impl;

import java.util.Date;
import java.util.List;

import com.gxc.topic.dao.TopicDao;
import com.gxc.topic.domain.Topic;
import com.gxc.topic.service.TopicService;

public class TopicServiceImpl implements TopicService {

	TopicDao topicDao;
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	
	/**
	 * 发帖
	 */
	@Override
	public void addTopic(Topic topic) {
		topic.setZanNum(0);
		topic.setVisitNum(1);
		topic.setSendTopicDate(new Date());
		topic.setLastReplyDate(topic.getSendTopicDate());
		topicDao.save(topic);
	}

	/**
	 * 获取所有主题
	 */
	@Override
	public List<Topic> findAllTopic(String order) {
		List<Topic> allTopic = topicDao.findAllTopicByOrder(order);
		return allTopic;
	}

	/**
	 * 根据查看数量排序
	 */
	@Override
	public List<Topic> findAllByVisiteNum() {
		List<Topic> allTopic = topicDao.findAllByVisiteNum();
		return allTopic;
	}

	/**
	 * 查看主题内容
	 */
	@Override
	public Topic findTopicById(Integer topicId) {
		Topic topic = topicDao.findTopicById(topicId);
		return topic;
	}

	/**
	 * 更新帖子查看人数
	 */
	@Override
	public void updateVisitNum(Topic dbTopic) {
		Topic topic = topicDao.findTopicById(dbTopic.getTopicId());
		topic.setVisitNum(dbTopic.getVisitNum()+1);
	}
	
}
