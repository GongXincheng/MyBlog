package com.gxc.topic.dao.web.action;

import java.util.List;

import com.gxc.topic.domain.Topic;
import com.gxc.topic.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TopicAction extends ActionSupport implements ModelDriven<Topic>{

	private static final long serialVersionUID = 1L;
	
	//模型驱动
	private Topic topic = new Topic();
	@Override
	public Topic getModel() {
		return topic ;
	}

	TopicService topicService;
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	/******************************************/
	
	/**
	 * 发帖
	 * @return
	 */
	public String sendTopic(){
		topicService.addTopic(topic);
		return "allTopic";
	}
	
	/**
	 * 查询所有的主题 Desc排序(最晚发布)
	 * @return
	 */
	public String AllTopic(){
		List<Topic> allTopic = topicService.findAllTopic("desc");
		ActionContext.getContext().getValueStack().set("allTopic", allTopic);
		return "UITopic";
	}
	
	/**
	 * 查询所有的主题 Asc排序(最早发布)
	 */
	public String AllTopicByAsc(){
		List<Topic> allTopic = topicService.findAllTopic("asc");
		ActionContext.getContext().getValueStack().set("allTopic", allTopic);
		return "UITopic";
	}
	
	/**
	 * 根据查看数量排序
	 */
	public String findAllByVisiteNum(){
		List<Topic> allTopic = topicService.findAllByVisiteNum();
		ActionContext.getContext().getValueStack().set("allTopic", allTopic);
		return "UITopic";
	}
	
	/**
	 * 查看主题内容
	 * @return
	 */
	public String showTopic(){
		Topic dbTopic = topicService.findTopicById(topic.getTopicId());
		topicService.updateVisitNum(dbTopic);
		ActionContext.getContext().getValueStack().push(dbTopic);
		return "TopicDetail";
	}
	
}
