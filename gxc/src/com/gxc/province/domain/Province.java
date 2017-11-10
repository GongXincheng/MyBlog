package com.gxc.province.domain;

import java.io.Serializable;

public class Province implements Serializable {
	private static final long serialVersionUID = 7932222307608014767L;

	private String provinceId;
	private String provinceName;
	
	/*
	 *  关系:
	 *  	Province -> City ： 对多
	 */
	
	
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
	
	@Override
	public String toString() {
		return "Province [provinceId=" + provinceId + ", provinceName="
				+ provinceName + "]";
	}
	
}
