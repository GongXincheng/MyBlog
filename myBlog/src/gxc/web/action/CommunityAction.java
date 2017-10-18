package gxc.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommunityAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String validate;
	
	public String list(){
		System.out.println(username);
		System.out.println(password);
		System.out.println(validate);
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("username", username);
		
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
// Get & Set
	
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
	
}
