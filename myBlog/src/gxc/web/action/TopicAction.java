package gxc.web.action;

import gxc.domain.Topic;
import gxc.domain.User;
import gxc.service.TopicService;
import gxc.service.impl.TopicServiceImpl;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TopicAction extends ActionSupport implements ModelDriven<Topic> {
	private static final long serialVersionUID = -2843415472682501116L;
	
	private Topic topic = new Topic();
	
	@Override
	public Topic getModel() {
		return topic ;
	}

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
	
	//根据查看数量查询
	public String findAllByVisiteNum(){
		List<Topic> topicList = topicService.findAllByVisiteNum();
		ActionContext.getContext().getValueStack().set("topicList", topicList);
		return "all";
	}
	
	//查看帖子
	public String showTopic(){
		
		Topic showTopic = topicService.findTopicById(topic.getTid());
		showTopic.setVisitNum(showTopic.getVisitNum()+1);
		ActionContext.getContext().getValueStack().push(showTopic);
		/*
		List<Reply> replyList = replyService.findReplyByTid(topic.getTid(),"desc");
		for (Reply reply : replyList) {
			System.out.println(reply);
		}
		ActionContext.getContext().put("replyList", replyList);*/
		return "showTopic";
	}
	
	/////////////////////////////////////////////////
	
	public TopicService getTopicService() {
		return topicService;
	}
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
}
