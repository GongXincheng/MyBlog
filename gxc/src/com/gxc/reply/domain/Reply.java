package com.gxc.reply.domain;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
	private static final long serialVersionUID = -2676596825815613687L;

	private Integer replyId;
	private String replyContent;	//回复内容
	private Date replyDate;	
	
	/*
	 * 关系：
	 * 		Reply -> Topic : 多对一
	 */
	
}
