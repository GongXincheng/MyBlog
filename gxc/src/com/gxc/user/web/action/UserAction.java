package com.gxc.user.web.action;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.gxc.province.domain.Province;
import com.gxc.province.service.ProvinceService;
import com.gxc.user.domain.User;
import com.gxc.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -2698719294496587185L;
	
	//模型驱动
	private User user = new User();
	@Override
	public User getModel() {
		return user ;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ProvinceService provinceService;
	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}
	/******************************************/
	

	/**
	 * 判断用户是否已经登录
	 * @return
	 * @throws Exception 
	 */
	public String hasLogin() throws Exception{
		JSONObject json = new JSONObject();
		
		//从session中获取登录的user
		Object loginUser = ActionContext.getContext().getSession().get("loginUser");
		
		if(loginUser!=null){
			json.put("msg", true);
		}
		else{
			json.put("msg", false);
		}
		
		ServletActionContext.getResponse().getWriter().print(json.toString());
		return "none";
	}
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception 
	 */
	public String login() throws Exception{
		//设置编码，创建session，json对象
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		HttpSession session = ServletActionContext.getRequest().getSession();
		JSONObject json = new JSONObject();
		
		boolean isVali = this.isValidate(user.getValidate());
		
		//验证错误
		if(!isVali){
			json.put("login_msg", "验证码错误");
		}
		//验证码成功
		else{
			//验证用户名密码是否正确
			User dbUser = userService.login(user);
			
			//用户名密码不匹配
			if(dbUser==null){
				json.put("login_msg", "用户名或密码错误");
			}
			//登录成功
			else{
				//TODO 更新登录次数和上次登陆时间
				
				//将user放入session中
				session.setAttribute("loginUser", dbUser);
				json.put("login_msg", "success");
			}
		}
		ServletActionContext.getResponse().getWriter().print(json.toString());
		return "none";
	}
	
	/**
	 * 用户注册
	 * @return
	 * @throws Exception 
	 */
	public String regist() throws Exception{
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		JSONObject json = new JSONObject();
		
		//判断用户名是否存在
		User dbUser = userService.findUserByUsername(user.getUsername());
		
		//后台验证
		if(user.getUsername().length()>10 || user.getUsername().length()<3){
			json.put("msg", "用户名格式不正确");
		}
		else if( ! (user.getRePassword().equals(user.getPassword())) ){
			json.put("msg", "密码不一致");
		}
		else if( ! this.isValidate(user.getValidate()) ){
			json.put("msg", "验证码不正确");
		}
		else if(dbUser!=null){
			json.put("msg", "用户名已存在");
		}
		else{
			userService.regist(user);
			json.put("msg", "success");
		}
		
		ServletActionContext.getResponse().getWriter().print(json.toString());
		return "none";
	}
	
	/**
	 * 用户注销
	 * @throws Exception 
	 */
	public String out() throws Exception{
		JSONObject json = new JSONObject();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		session.removeAttribute("loginUser");
		session.invalidate();
		json.put("msg", true);
		
		ServletActionContext.getResponse().getWriter().print(json.toString());
		return "none";
	}
	
	/**
	 * 注册时判断用户是否已经存在
	 * @return
	 * @throws IOException
	 */
	public String hasUser() throws IOException{
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		JSONObject json = new JSONObject();
		
		User findUser = this.userService.findUserByUsername(user.getUsername());
		if(findUser==null){
			//用户名不存在
			json.put("msg", "success");
		}
		else{
			json.put("msg", "用户名已存在");
		}
		ServletActionContext.getResponse().getWriter().print(json.toString());
		return "none";
	}
	
	
	/**
	 * 用户主页
	 * @return
	 */
	public String userHome(){
		//通过userId获取User，压入值栈栈顶
		User dbUser = this.userService.findUserById(user.getUserId());
		ActionContext.getContext().getValueStack().push(dbUser);
		
		return "userHome";
	}
	
	/**
	 * 用户信息页
	 * @return
	 */
	public String userDetail(){
		//通过userId获取User，压入值栈栈顶
		User dbUser = this.userService.findUserById(user.getUserId());
		ActionContext.getContext().getValueStack().push(dbUser);
		
		//查找所有的省,放入值栈
		List<Province> allProvince = provinceService.findAllProvince();
		ActionContext.getContext().getValueStack().set("allProvince", allProvince);
		
		return "userDetail";
	}
	
	
	
	
	
	
	
	
	/**
	 * 判断验证码是否正确
	 * @param validate
	 * @return
	 */
	public boolean isValidate(String validate){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String captchaStr = (String)session.getAttribute("captcha");
		return captchaStr.equals(validate.toLowerCase());
	}
}
