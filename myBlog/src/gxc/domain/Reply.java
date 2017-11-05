package gxc.domain;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
	private static final long serialVersionUID = -6040127168657838624L;
	
	private Integer rid;
	private String replyContent;	//回复内容
	private Date replyDate;			//回复时间
	
	/*
	 *  Reply 和 Topic 多对一关系
	 * 	Reply 和 User  多对一关系
	 */
	
	private User user;
	private Topic topic;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
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
	
	
	
}
