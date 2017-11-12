package com.gxc.web.action;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;
import cn.dsna.util.images.ValidateCode;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public class CaptchaAction extends StrutsResultSupport{
	private static final long serialVersionUID = -125984826912344227L;

	private Integer width;
	private Integer height;
	private String time;
	
	@Override
	protected void doExecute(String arg0, ActionInvocation invocation)
			throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		//生成验证码
		ValidateCode vc = new ValidateCode(width, height, 4, 50);
		
		//将验证码封装到session中
		ActionContext.getContext().getSession().put("captcha", vc.getCode().toLowerCase());
		
		vc.write(response.getOutputStream());
		
	}
	
	/********************************************/
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
