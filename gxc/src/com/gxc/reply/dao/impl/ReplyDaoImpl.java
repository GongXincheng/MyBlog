package com.gxc.reply.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.reply.dao.ReplyDao;
import com.gxc.reply.domain.Reply;

public class ReplyDaoImpl extends HibernateDaoSupport implements ReplyDao {

	/**
	 * 添加回复
	 */
	@Override
	public void saveReply(Reply reply) {
		this.getHibernateTemplate().save(reply);
	}

}
