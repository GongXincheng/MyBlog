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
		List<Topic> topicList = topicService.findAllTopic();
		ActionContext.getContext().getValueStack().set("topicList", topicList);
		return "all";
	}
	public String findAllAsc(){
		List<Topic> topicList = topicService.findAllTopicByAsc();
		ActionContext.getContext().getValueStack().set("topicList", topicList);
		return "all";
	}
	
	//TODO
	//根据查看数量查询
	public String findAllByVisiteNum(){
		List<Topic> topicList = topicService.findAllByVisiteNum();
		ActionContext.getContext().getValueStack().set("topicList", topicList);
		return "all";
	}
	
	//查看帖子
	public String showTopic(){
		
		Topic showTopic = topicService.findTopicById(topic.getTid());
		ActionContext.getContext().getValueStack().push(showTopic);
		
		return "showTopic";
	}
	
	/////////////////////////////////////////////////
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
}
