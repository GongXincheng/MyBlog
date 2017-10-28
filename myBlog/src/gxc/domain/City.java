package gxc.domain;

import java.io.Serializable;

public class City implements Serializable{
	private static final long serialVersionUID = -3819041367951693852L;

	private Integer cid;
	private String cityid;
	private String city;
	private String provinceid;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
}
