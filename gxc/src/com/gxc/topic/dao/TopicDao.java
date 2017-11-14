package com.gxc.topic.dao;

import java.util.List;

import com.gxc.topic.domain.Topic;

public interface TopicDao {

	/**
	 * 发帖
	 * @param topic
	 */
	void save(Topic topic);

	/**
	 * 获取所有主题(Order)
	 * @param string
	 * @return
	 */
	List<Topic> findAllTopicByOrder(String string);

	/**
	 * 根据查看数量排序
	 * @return
	 */
	List<Topic> findAllByVisiteNum();

	/**
	 * 查看主题内容
	 * @param topicId
	 * @return
	 */
	Topic findTopicById(Integer topicId);

}
