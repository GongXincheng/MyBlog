package com.gxc.user.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 4683360266603963974L;
	
	private String userId;
	private String username;
	private String password;
	private String realname;
	private String gender;	
	private String sign;	//签名
	private String telephone; 
	private String email;
	private String province;
	private String city;
	private String note;	//简介
	private String face;	//头像
	private Date registDate;	//注册时间
	private Date lastLoginDate;	//最后登陆时间
	private Integer loginNum;	//登录次数
	private Integer role;
	
	/*
	 * 关系:
	 * 		User -> City  多对一
	 * 		User -> Topic 一对多
	 * 		User -> Message 一对多
	 */
	
	
	
	
	
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", realname=" + realname
				+ ", gender=" + gender + ", sign=" + sign + ", telephone="
				+ telephone + ", email=" + email + ", province=" + province
				+ ", city=" + city + ", note=" + note + ", face=" + face
				+ ", registDate=" + registDate + ", lastLoginDate="
				+ lastLoginDate + ", loginNum=" + loginNum + ", role=" + role
				+ "]";
	}
}
