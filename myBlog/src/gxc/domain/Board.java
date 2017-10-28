package gxc.domain;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
	private static final long serialVersionUID = 7960485363539460207L;

	private Integer bid;
	private String title;	//标题
	private String message;	//内容
	private Date createDate;//时间
	
	/*
	 *  Board 和 User 多对一关系
	 */
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
