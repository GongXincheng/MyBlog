package gxc.service;

import java.util.List;

import gxc.domain.Topic;
import gxc.domain.User;

public interface TopicService {

	void addTopic(User user, Topic topic);

	List<Topic> findAllTopic();

	List<Topic> findAllTopicByAsc();

}
