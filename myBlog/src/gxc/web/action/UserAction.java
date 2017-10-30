package gxc.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import gxc.domain.City;
import gxc.domain.Province;
import gxc.domain.User;
import gxc.service.CityService;
import gxc.service.ProvinceService;
import gxc.service.UserService;
import gxc.service.impl.CityServiceImpl;
import gxc.service.impl.ProvinceServiceImpl;
import gxc.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1308715284893927375L;
	
	private User user = new User();
	private Province pro;
	private City cit;
	private UserService userService = new UserServiceImpl();
	
	//返回主页
	public String goUserHome(){
		user = userService.findUserById(user.getUid());
		return "userhome";
	}
	
	//返回详细信息
	public String goUserDetail(){
		
		user = userService.findUserById(user.getUid());
		
		//获取省市
		ProvinceService provinceService = new ProvinceServiceImpl();
		CityService cityService = new CityServiceImpl();
		
		pro = provinceService.getProvinceById(user.getProvince());
		cit = cityService.getCityByCityid(user.getCity());
		
		return "userdetail";
	}
	
	//修改
	public String edit(){
		int info = userService.editUser(user);
		if(info>0){
			//修改完之后，把session的user内容改掉
			User sessioUser = userService.findUserById(user.getUid());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("user");
			session.setAttribute("user", sessioUser);
			return "useredit";
		}
		else
			return "input";
	}
	
	
	@Override
	public User getModel() {
		return user;
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

	public Province getPro() {
		return pro;
	}

	public void setPro(Province pro) {
		this.pro = pro;
	}

	public City getCit() {
		return cit;
	}

	public void setCit(City cit) {
		this.cit = cit;
	}
}
