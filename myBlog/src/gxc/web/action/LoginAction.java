package gxc.web.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private String result;
	private String username;
	private String password;
	private String validate;
	
	
	public String login(){
		System.out.println("用户名：" + username);
		System.out.println("密码：" + password);
		System.out.println("验证码：" + validate);
		
		//从session中获取验证码
		Map<String, Object> session = ActionContext.getContext().getSession();
		String captcha = (String)session.get("login_captcha");
		System.out.println("验证码是否正确："+captcha.equals(validate.toLowerCase()));
		
		//验证用户名密码是否正确
		
		
		//将用户放在session中
		session.put("loginName", username);
		
		JSONObject json = new JSONObject();
		json.put("msg", "success");
		result = json.toString();
		
		return "loginSuccess";
	}
	
	/**
	 * 判断用户是否已经登录
	 * @return
	 */
	public String hasLogin(){
		JSONObject json = new JSONObject();
		
		//获取session中的loginUser
		Object loginUser = ActionContext.getContext().getSession().get("loginName");
		
		if(loginUser!=null)
			json.put("msg", true);
		else
			json.put("msg", false);
		
		result = json.toString();
		return "hasLogined";
	}
	
	/**
	 * 判断验证码是否正确
	 */
	public String captcha(){
		JSONObject json = new JSONObject();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String captcha = (String)session.get("login_captcha");
		if( captcha.equals(validate.toLowerCase()) ){
			json.put("msg", true);
		}
		else{
			json.put("msg", false);
		}
		result = json.toString();
		return "loginCapthca";
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	public String out(){
		
		JSONObject json = new JSONObject();
		//获取
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		
		json.put("msg", true);
		result = json.toString();
		
		return "userLeave";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
