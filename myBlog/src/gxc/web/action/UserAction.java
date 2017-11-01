package gxc.web.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
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
	private String result;
	private String proCode;
	
	private UserService userService = new UserServiceImpl();
	private ProvinceService provinceService = new ProvinceServiceImpl();
	private CityService cityService = new CityServiceImpl();
	
	//返回主页
	public String goUserHome(){
		user = userService.findUserById(user.getUid());
		return "userhome";
	}
	
	//返回详细信息
	public String goUserDetail(){
		user = userService.findUserById(user.getUid());
		
		//获取省市
		pro = provinceService.getProvinceById(user.getProvince());
		cit = cityService.getCityByCityid(user.getCity());
		
		return "userdetail";
	}
	
	//修改
	public void edit(){
		int info = userService.editUser(user);
		if(info>0){
			//修改完之后，把session的user内容改掉
			User sessioUser = userService.findUserById(user.getUid());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("user");
			session.setAttribute("user", sessioUser);
			try {
				ServletActionContext.getResponse().sendRedirect("User_goUserDetail?uid="+user.getUid());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//查询全部省份
	public String getAllProvince(){
		List<Province> provinces = provinceService.getAllProvince();
		JSONArray json = JSONArray.fromObject(provinces);
		
		result = json.toString();
		return "success";
	}
	
	//根据省份查询对应的城市
	public String getCity(){
		List<City> list = cityService.getCitysByProvinceid(proCode);
		
		JSONArray json = JSONArray.fromObject(list);
		result = json.toString();
		return SUCCESS;
	}
	
	//修改头像
	public String editHead(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		User sessioUser = (User)session.getAttribute("user");
		int sessionId = sessioUser.getUid();
		int userId =  user.getUid();
		
		System.out.println(sessionId + "-----" + user.getUid()+ "->" + (sessionId == userId));
		
		if(sessionId == userId){
			//数据库修改
			userService.editHead(user);
			refreshSession(user.getUid());
		}
		
		return SUCCESS;
	}
	
	
	//更新session
	public void refreshSession(Integer uid){
		User sessioUser = userService.findUserById(uid);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		session.setAttribute("user", sessioUser);
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ProvinceService getProvinceService() {
		return provinceService;
	}

	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	public CityService getCityService() {
		return cityService;
	}

	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	
}
