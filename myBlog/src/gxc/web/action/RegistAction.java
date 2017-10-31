package gxc.web.action;

import gxc.domain.User;
import gxc.service.UserService;
import gxc.service.impl.UserServiceImpl;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegistAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -747723349145565851L;
	
	User user = new User();
	private String result;
	private String rePassword;
	private String validate;
	
	private UserService userService;
	
	public String regist(){
		/*user.setUsername(URLDecoder.decode(user.getUsername(),"UTF-8"));*/
		
		JSONObject json = new JSONObject();
		userService = new UserServiceImpl();
		
		//获取验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String captchaStr = (String)session.getAttribute("login_captcha");
		
		//判断用户名是否存在
		User dbUser = userService.findUserByUsername(user.getUsername());
		
		//后台验证
		if(user.getUsername().length()>10 || user.getUsername().length()<3){
			json.put("msg", "用户名格式不正确");
		}
		else if( !rePassword.equals(user.getPassword()) ){
			json.put("msg", "密码不一致");
		}
		else if( !validate.equals(captchaStr) ){
			json.put("msg", "验证码不正确");
		}
		else if(dbUser!=null){
			json.put("msg", "用户名已存在");
		}
		else{
			userService.addUser(user);
			json.put("msg", "success");
		}
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	public String hasUser() throws Exception{
		//解码
		/*user.setUsername(URLDecoder.decode(user.getUsername(),"UTF-8"));*/
		
		JSONObject json = new JSONObject();
		userService = new UserServiceImpl();
		
		//查询数据库是否有该用户
		User dbUser = userService.findUserByUsername(user.getUsername());
		
		//判断dbUser是否为空
		if(dbUser!=null){
			json.put("msg", "用户名已存在");
		}
		else{
			json.put("msg", "success");
		}
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
