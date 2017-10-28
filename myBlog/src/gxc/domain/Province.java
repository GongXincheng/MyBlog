package gxc.domain;

import java.io.Serializable;

public class Province implements Serializable{
	private static final long serialVersionUID = 5594142865454233382L;

	private Integer pid;
	private String provinceid;
	private String province;
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
