package gxc.web.action;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String result;
	private String username;
	private String password;
	private String rePassword;
	private String validate;
	
	public String regist(){
		JSONObject json = new JSONObject();
		username = username.trim();
		//获取验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String captchaStr = (String)session.getAttribute("login_captcha");

		//用户名格式
		if(username.length()>10 || username.length()<5){
			json.put("msg", "用户名格式不正确");
		}
		//判断验证码是否正确
		else if(captchaStr.equals(validate)){
			//保存操作
			json.put("msg", "success");
		}
		else
			json.put("msg", "验证码错误");
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
}
