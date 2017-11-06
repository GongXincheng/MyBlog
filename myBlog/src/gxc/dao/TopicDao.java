package gxc.dao;

import java.util.List;

import gxc.domain.Topic;
import gxc.domain.User;

public interface TopicDao {

	void addTopic(User user, Topic topic);

	List<Topic> findAllTopic(String order);

	List<Topic> findAllByVisiteNum();

	Topic findTopicById(Integer tid);

}
