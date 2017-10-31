package gxc.web.action;

import gxc.domain.User;
import gxc.service.UserService;
import gxc.service.impl.UserServiceImpl;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	private String result;
	private String validate;
	private UserService userService = new UserServiceImpl();
	
	/**
	 * 登录验证
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String login(){
		JSONObject json = new JSONObject();
		/*user.setUsername(URLDecoder.decode(user.getUsername(),"UTF-8"));*/
		
		//从session中获取验证码,判断验证码是否正确
		HttpSession session = ServletActionContext.getRequest().getSession();
		String captchaStr = (String)session.getAttribute("login_captcha");
		boolean isValidate = captchaStr.equals(validate.toLowerCase());
		
		//验证用户名密码是否正确
		User dbUser = userService.findUserByUsernameAndPassword(user);
		
		if(!isValidate){
			json.put("login_msg", "验证码错误");
		}
		else if(dbUser==null){
			json.put("login_msg", "用户名或密码错误");
		}
		else{
			//登陆成功,登录次数+1,和登录时间
			userService.updateLoginNum(user.getUsername());
			userService.updateLastLoginDate(user.getUsername());
			
			//将user放入session中
			session.setAttribute("user", dbUser);
			json.put("login_msg", "success");
		}
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	/**
	 * 判断用户是否已经登录
	 * @return
	 */
	public String hasLogin(){
		JSONObject json = new JSONObject();
		
		//获取session中的loginUser
		User dnUser = (User) ActionContext.getContext().getSession().get("user");
		
		if(dnUser!=null)
			json.put("msg", true);
		else
			json.put("msg", false);
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	/**
	 * 用户注销
	 * @return
	 */
	public String out(){
		JSONObject json = new JSONObject();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		//销毁session
		session.invalidate();
		json.put("msg", true);
		
		result = json.toString();
		return SUCCESS;
	}
	
	
	
	//Get & Set
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
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
