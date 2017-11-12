package com.gxc.topic.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gxc.reply.domain.Reply;
import com.gxc.user.domain.User;

public class Topic implements Serializable {
	private static final long serialVersionUID = -8949781435257805552L;

	private Integer topicId;
	private String toicTitle;
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
	User user;
	Set<Reply> replySet = new HashSet<Reply>();
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getToicTitle() {
		return toicTitle;
	}
	public void setToicTitle(String toicTitle) {
		this.toicTitle = toicTitle;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Reply> getReplySet() {
		return replySet;
	}
	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}
	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", toicTitle=" + toicTitle
				+ ", topicContent=" + topicContent + ", sendTopicDate="
				+ sendTopicDate + ", lastReplyDate=" + lastReplyDate
				+ ", visitNum=" + visitNum + ", zanNum=" + zanNum + "]";
	}
	
}
