package gxc.service.impl;

import java.util.Date;
import java.util.List;

import gxc.dao.TopicDao;
import gxc.dao.impl.TopicDaoImpl;
import gxc.domain.Topic;
import gxc.domain.User;
import gxc.service.TopicService;

public class TopicServiceImpl implements TopicService{
	TopicDao topicDao = new TopicDaoImpl();
	
	public void addTopic(User user, Topic topic) {
		//初始化
		topic.setCreateDate(new Date());
		topic.setLastReplyDate(topic.getCreateDate());
		topic.setVisitNum(1);
		topic.setZanNum(0);
		topicDao.addTopic(user,topic);
	}

	@Override
	public List<Topic> findAllTopic() {
		List<Topic> topicList = topicDao.findAllTopic("desc");
		return topicList;
	}

	@Override
	public List<Topic> findAllTopicByAsc() {
		List<Topic> topicList = topicDao.findAllTopic("asc");
		return topicList;
	}

}
