package com.gxc.web.action;

import java.util.List;

import com.gxc.message.domain.Message;
import com.gxc.message.service.MessageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAdminAction extends ActionSupport {
	private static final long serialVersionUID = 2825698558000522216L;

	MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	/**********************************************/
	
	/**
	 * 留言列表 DESC 排序
	 */
	public String allMessageByDesc(){
		List<Message> allMessage = messageService.findAllByOrder("desc");
		ActionContext.getContext().getValueStack().set("allMessage", allMessage);
		return "messageList";
	}
	
	/**
	 * 留言列表 Asc 排序
	 */
	public String allMessageByAsc(){
		List<Message> allMessage = messageService.findAllByOrder("asc");
		ActionContext.getContext().getValueStack().set("allMessage", allMessage);
		return "messageList";
	}
}
