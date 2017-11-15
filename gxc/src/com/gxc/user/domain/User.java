package com.gxc.user.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gxc.city.domain.City;
import com.gxc.message.domain.Message;
import com.gxc.reply.domain.Reply;
import com.gxc.topic.domain.Topic;

public class User implements Serializable{
	private static final long serialVersionUID = 4683360266603963974L;
	
	private String userId;
	private String username;
	private String password;
	private String realname;
	private String gender;	
	private String sign;
	private String telephone; 
	private String email;
	private String note;
	private String face;
	private Date registDate;
	private Date lastLoginDate;
	private Integer loginNum;
	private Integer role;
	
	/*
	 * 关系:
	 * 		User -> Topic 一对多
	 * 		User -> Message 一对多
	 *  	User -> City  多对一
	 *  	User -> Reply 一对多
	 */
	City city;
	Set<Topic> topicSet = new HashSet<Topic>();
	Set<Reply> replySet = new HashSet<Reply>();
	Set<Message> messageSet = new HashSet<Message>();
	
	//暂时
	private String validate;
	private String rePassword;
	
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Integer getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Set<Topic> getTopicSet() {
		return topicSet;
	}
	public void setTopicSet(Set<Topic> topicSet) {
		this.topicSet = topicSet;
	}
	public Set<Message> getMessageSet() {
		return messageSet;
	}
	public void setMessageSet(Set<Message> messageSet) {
		this.messageSet = messageSet;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public City getCity() {
		return city;
	}
	public Set<Reply> getReplySet() {
		return replySet;
	}
	public void setReplySet(Set<Reply> replySet) {
		this.replySet = replySet;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", realname=" + realname
				+ ", gender=" + gender + ", sign=" + sign + ", telephone="
				+ telephone + ", email=" + email + ", note=" + note + ", face="
				+ face + ", registDate=" + registDate + ", lastLoginDate="
				+ lastLoginDate + ", loginNum=" + loginNum + ", role=" + role
				+ "]";
	}
	
	
}
