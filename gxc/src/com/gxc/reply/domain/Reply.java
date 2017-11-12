package com.gxc.reply.domain;

import java.io.Serializable;
import java.util.Date;

import com.gxc.topic.domain.Topic;

public class Reply implements Serializable {
	private static final long serialVersionUID = -2676596825815613687L;

	private Integer replyId;
	private String replyContent;	//回复内容
	private Date replyDate;
	
	/*
	 * 关系：
	 * 		Reply -> Topic : 多对一
	 */
	Topic topic;
	 
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}	
	
	
	
	
}
