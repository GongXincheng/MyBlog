package gxc.service;

import java.util.List;

import gxc.domain.Reply;

public interface ReplyService {

	/**
	 * 回复
	 * @param uid
	 * @param tid
	 * @param reply
	 */
	void addReply(Integer uid, Integer tid, Reply reply);

	/**
	 * 根据帖子的ID，查询所有的回复(顺序)
	 * @param tid
	 * @return
	 */
	List<Reply> findReplyByTid(Integer tid,String order);

}
