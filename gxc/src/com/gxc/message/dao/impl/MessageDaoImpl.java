package com.gxc.message.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.message.dao.MessageDao;
import com.gxc.message.domain.Message;

public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao{

	/**
	 * 添加留言
	 */
	@Override
	public void save(Message message) {
		this.getHibernateTemplate().save(message);
	}

	/**
	 * 查询所有Message
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findAllMessage() {
		return this.getHibernateTemplate().find("from Message");
	}

	/**
	 * 根据Order排序 显示message列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findAllByOrder(String order) {
		return this.getHibernateTemplate().find("from Message order by sendMessageDate "+order);
	}

}
