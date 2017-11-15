package com.gxc.reply.service.impl;

import java.util.Date;

import com.gxc.reply.dao.ReplyDao;
import com.gxc.reply.domain.Reply;
import com.gxc.reply.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	
	/**
	 * 添加回复
	 */
	@Override
	public void addReply(Reply reply) {
		reply.setReplyDate(new Date());
		replyDao.saveReply(reply);
	}
	
	
	
}
