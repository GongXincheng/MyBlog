package gxc.web.action;

import gxc.domain.Topic;
import gxc.domain.User;
import gxc.service.TopicService;
import gxc.service.UserService;
import gxc.service.impl.TopicServiceImpl;
import gxc.service.impl.UserServiceImpl;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TopicAction extends ActionSupport implements ModelDriven<Topic> {
	private static final long serialVersionUID = -2843415472682501116L;
	
	private Topic topic = new Topic();
	public Topic getModel() {
		return topic ;
	}
	
	private List<Topic> topicList;
	
	private UserService userService = new UserServiceImpl();
	private TopicService topicService = new TopicServiceImpl();
	//////////////////////////////////////////////////
	
	//发帖
	public String sendTopic(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		
		if(user!=null){
			topicService.addTopic(user,topic);
			return "hasSend";
		}
		
		return "input";
	}

	//查询所有主题 Desc
	public String findAll(){
		topicList = topicService.findAllTopic();
		return "all";
	}
	public String findAllAsc(){
		topicList = topicService.findAllTopicByAsc();
		return "all";
	}
	
	
	
	
	
	/////////////////////////////////////////////////
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
}
