package com.gxc.message.web.action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import com.gxc.message.domain.Message;
import com.gxc.message.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message> {
	private static final long serialVersionUID = 106990010429468480L;
	
	//模型驱动
	private Message message = new Message();
	@Override
	public Message getModel() {
		return message ;
	}

	MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	/***********************************************/
	
	/**
	 * 保存留言
	 * @return
	 * @throws IOException
	 */
	public String saveMessage() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject json = new JSONObject();
		
		messageService.addMessage(message);
		
		json.put("msg", "success");
		response.getWriter().write(json.toString());
		return "none";
	}
	
	
	
}
