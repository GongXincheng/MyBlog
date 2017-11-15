package com.gxc.reply.web.action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.gxc.reply.domain.Reply;
import com.gxc.reply.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {
	private static final long serialVersionUID = 2342470891463712249L;
	
	//模型驱动
	private Reply reply = new Reply();;
	@Override
	public Reply getModel() {
		return reply ;
	}

	//service
	ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	/****************************************************/
	/**
	 * 添加回复
	 * @throws IOException 
	 */
	public String sendReply() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		replyService.addReply(reply);
		//跳转
		response.sendRedirect("topicAction_showTopic?topicId="+reply.getTopic().getTopicId());
		return "none";
	}
	
}
