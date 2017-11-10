package com.gxc.city.domain;

import java.io.Serializable;

public class City implements Serializable{
	private static final long serialVersionUID = 3458337493867089207L;
	
	private String cityId;
	private String cityName;
	
	/*
	 * 关系：
	 * 		City -> User ：一对多
	 * 		City -> Province : 多对一
	 */
	
	
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
	
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	
	
}
