package gxc.service.impl;

import java.util.List;

import gxc.dao.ReplyDao;
import gxc.dao.impl.ReplyDaoImpl;
import gxc.domain.Reply;
import gxc.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{

	private ReplyDao replyDao = new ReplyDaoImpl();
	
	@Override
	public void addReply(Integer uid, Integer tid, Reply reply) {
		replyDao.addReply(uid,tid,reply);
	}

	@Override
	public List<Reply> findReplyByTid(Integer tid, String order) {
		return replyDao.findReplyByTid(tid,order);
	}

}
