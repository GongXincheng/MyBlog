package com.gxc.message.dao;

import java.util.List;

import com.gxc.message.domain.Message;

public interface MessageDao {

	/**
	 * 添加留言
	 * @param message 
	 */
	void save(Message message);

	/**
	 * 查询所有Message
	 * @return
	 */
	List<Message> findAllMessage();

	/**
	 * 根据Order排序 显示message列表
	 * @param order
	 * @return
	 */
	List<Message> findAllByOrder(String order);

}
