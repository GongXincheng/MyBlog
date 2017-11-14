package com.gxc.message.service.impl;

import java.util.Date;
import java.util.List;

import com.gxc.message.dao.MessageDao;
import com.gxc.message.domain.Message;
import com.gxc.message.service.MessageService;

public class MessageServiceImpl implements MessageService {

	MessageDao messageDao;
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	/**
	 * 添加留言
	 */
	@Override
	public void addMessage(Message message) {
		message.setSendMessageDate(new Date());
		messageDao.save(message);
	}

	/**
	 * 查询所有Message
	 */
	@Override
	public List<Message> findAllMessage() {
		List<Message> allMessage = messageDao.findAllMessage();
		return allMessage;
	}

	/**
	 * 根据Order排序 显示message列表
	 */
	@Override
	public List<Message> findAllByOrder(String order) {
		List<Message> allMessage = messageDao.findAllByOrder(order);
		return allMessage;
	}
	
	
	
}
