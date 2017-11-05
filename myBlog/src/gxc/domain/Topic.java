package gxc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic implements Serializable{
	private static final long serialVersionUID = 566892783351806711L;

	private Integer tid;
	private String title;
	private String topicContent;//帖子内容
	private	Date createDate;	//发帖时间
	private Date lastReplyDate;	//最后回复时间
	private	Integer visitNum;	//查看人数
	private Integer zanNum;		//点赞个数
	
	/*
	 * 	Topic 和 Reply 一对多关系
	 *  Topic 和 User  多对一关系
	 */
	private Set<Reply> replySet = new HashSet<Reply>();
	private User user;
	
	public Set<Reply> getReplySet() {
		return replySet;
	}
	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
}
