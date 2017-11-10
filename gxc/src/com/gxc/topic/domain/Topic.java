package com.gxc.topic.domain;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {
	private static final long serialVersionUID = -8949781435257805552L;

	private Integer topicId;
	private String title;
	private String topicContent;//帖子内容
	private	Date sendTopicDate;	//发帖时间
	private Date lastReplyDate;	//最后回复时间
	private	Integer visitNum;	//查看人数
	private Integer zanNum;		//点赞个数
	
	/*
	 * 关系：
	 * 		Topic -> User : 多对一
	 * 		Topic -> Reply: 一对多
	 */
	
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public Date getSendTopicDate() {
		return sendTopicDate;
	}
	public void setSendTopicDate(Date sendTopicDate) {
		this.sendTopicDate = sendTopicDate;
	}
	public Date getLastReplyDate() {
		return lastReplyDate;
	}
	public void setLastReplyDate(Date lastReplyDate) {
		this.lastReplyDate = lastReplyDate;
	}
	public Integer getVisitNum() {
		return visitNum;
	}
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	public Integer getZanNum() {
		return zanNum;
	}
	public void setZanNum(Integer zanNum) {
		this.zanNum = zanNum;
	}
	
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title
				+ ", topicContent=" + topicContent + ", sendTopicDate="
				+ sendTopicDate + ", lastReplyDate=" + lastReplyDate
				+ ", visitNum=" + visitNum + ", zanNum=" + zanNum + "]";
	}
	
}
