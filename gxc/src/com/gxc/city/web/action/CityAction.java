package com.gxc.city.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

import com.gxc.city.domain.City;
import com.gxc.city.service.CityService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CityAction extends ActionSupport implements ModelDriven<City> {
	private static final long serialVersionUID = -2844403770554079665L;
	
	//模型驱动
	private City city = new City();
	
	@Override
	public City getModel() {
		return city ;
	}

	//service
	CityService cityService;
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	
	/**********************************************/
	
	/**
	 * 根据
	 * @return
	 * @throws Exception 
	 */
	public String findAllCitiesByProvince() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		//根据省查询全部城市
		List<City> allCity = cityService.findAllCities(city.getProvince());
		
		//排除不需要的数据
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"province","userSet"});
		
		//返回json字符串
		response.getWriter().write(JSONArray.fromObject(allCity,jsonConfig).toString());
		
		return "none";
	}
	
}
