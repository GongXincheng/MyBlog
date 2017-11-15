package com.gxc.topic.service;

import java.util.List;

import com.gxc.topic.domain.Topic;

public interface TopicService {

	/**
	 * 发帖
	 * @param topic
	 */
	void addTopic(Topic topic);

	/**
	 * 获取所有主题 (Order)
	 * @param order 
	 * @return
	 */
	List<Topic> findAllTopic(String order);

	/**
	 * 根据查看数量排序
	 * @return
	 */
	List<Topic> findAllByVisiteNum();

	/**
	 * 
	 * @param topicId
	 * @return
	 */
	Topic findTopicById(Integer topicId);

	/**
	 * 更新帖子查看人数
	 * @param dbTopic
	 */
	void updateVisitNum(Topic dbTopic);

}
