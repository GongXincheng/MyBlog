package com.gxc.message.domain;

import java.io.Serializable;
import java.util.Date;

import com.gxc.user.domain.User;

public class Message implements Serializable {
	private static final long serialVersionUID = 6656986995131961281L;

	private Integer messageId;
	private String messageTitle; //标题
	private String messageContent;	//内容
	private Date sendMessageDate;//时间
	
	/*
	 * 关系：
	 * 		Message -> User : 多对一
	 */
	User user;
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getSendMessageDate() {
		return sendMessageDate;
	}
	public void setSendMessageDate(Date sendMessageDate) {
		this.sendMessageDate = sendMessageDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
