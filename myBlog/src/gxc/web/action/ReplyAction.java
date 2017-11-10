package gxc.web.action;

import java.util.Date;
import org.apache.struts2.ServletActionContext;
import gxc.domain.Reply;
import gxc.domain.User;
import gxc.service.ReplyService;
import gxc.service.impl.ReplyServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author GXC
 */
public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {
	private static final long serialVersionUID = 976864136984222687L;
	
	/**
	 * 模型驱动
	 */
	private Reply reply = new Reply();
	
	@Override
	public Reply getModel() {
		return reply;
	}
	
	/**
	 * 在哪一个主题下回复的
	 */
	private Integer tid;

	/**
	 * Service层
	 */
	private ReplyService replyService = new ReplyServiceImpl();
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	/**********************************************/
	
	/**
	 * 发帖
	 * @return
	 * @throws Exception 
	 */
	public String sendReply() throws Exception{
		//回复人
		User loginUser = (User)ActionContext.getContext().getSession().get("user");
		//在 tid 的主题回复
		//回复内容为reply
		reply.setReplyDate(new Date());
		replyService.addReply(loginUser.getUid(),tid,reply);
		ServletActionContext.getResponse().sendRedirect("TopicAction_showTopic?tid="+tid);
		
		return "none";
	}
	
	
	
/**********************************************/
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
}
