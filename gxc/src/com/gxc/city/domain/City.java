package com.gxc.city.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.gxc.province.domain.Province;
import com.gxc.user.domain.User;

public class City implements Serializable{
	private static final long serialVersionUID = 3458337493867089207L;
	
	private String cityId;
	private String cityName;
	
	/*
	 * 关系：
	 * 		City -> User ：一对多
	 * 		City -> Province : 多对一
	 */
	Set<User> userSet = new HashSet<User>();
	Province province;
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
	
}
