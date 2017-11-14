package com.gxc.message.service;

import java.util.List;

import com.gxc.message.domain.Message;

public interface MessageService {

	/**
	 * 添加留言
	 * @param message
	 */
	void addMessage(Message message);

	/**
	 * 查询所有留言
	 * @return
	 */
	List<Message> findAllMessage();

	/**
	 * 根据Order排序 显示message列表
	 * @param string
	 * @return
	 */
	List<Message> findAllByOrder(String order);

}
