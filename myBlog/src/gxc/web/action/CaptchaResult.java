package gxc.web.action;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import cn.dsna.util.images.ValidateCode;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * 自定义结果类型验证码
 * @author Administrator
 */
public class CaptchaResult extends StrutsResultSupport {
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		
		ValidateCode vc = new ValidateCode(width, height, 4, 50);
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("login_captcha", vc.getCode().toLowerCase());
		
		vc.write(response.getOutputStream());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
