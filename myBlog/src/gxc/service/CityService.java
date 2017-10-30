package gxc.service;

import gxc.domain.City;

import java.util.List;

public interface CityService {
	/**
	 * 查询全部城市
	 * @return
	 */
	public List<City> getAllCity();
	
	/**
	 * 根据provinceid查询所有的城市
	 * @param provinceid
	 * @return
	 */
	public List<City> getCitysByProvinceid(String provinceid);
	
	/**
	 * 根据cityid查询city
	 * @param cityid
	 * @return
	 */
	public City getCityByCityid(String cityid);
}
