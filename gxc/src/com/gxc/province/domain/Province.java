package com.gxc.province.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.gxc.city.domain.City;

public class Province implements Serializable {
	private static final long serialVersionUID = 7932222307608014767L;

	private String provinceId;
	private String provinceName;
	
	/*
	 *  关系:
	 *  	Province -> City ： 一对多
	 */
	Set<City> citySet = new HashSet<City>();
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Set<City> getCitySet() {
		return citySet;
	}
	public void setCitySet(Set<City> citySet) {
		this.citySet = citySet;
	}
	
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName="
				+ provinceName + "]";
	}
	
}
