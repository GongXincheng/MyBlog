package gxc.web.action;

import java.util.Map;

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
		System.out.println(username);
		System.out.println(password);
		System.out.println(validate);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("loginName", username);
		
		JSONObject json = new JSONObject();
		json.put("msg", "success");
		json.put("loginName", username);
		result = json.toString();
		
		return SUCCESS;
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
