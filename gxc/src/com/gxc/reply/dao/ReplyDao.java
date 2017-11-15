package com.gxc.reply.dao;

import com.gxc.reply.domain.Reply;

public interface ReplyDao {

	/**
	 * 添加回复
	 * @param reply
	 */
	void saveReply(Reply reply);

}
