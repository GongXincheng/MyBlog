package com.gxc.city.service.impl;

import java.util.List;

import com.gxc.city.dao.CityDao;
import com.gxc.city.domain.City;
import com.gxc.city.service.CityService;
import com.gxc.province.domain.Province;

public class CityServiceImpl implements CityService {

	CityDao cityDao;
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	/**
	 * 根据省查询全部城市
	 */
	@Override
	public List<City> findAllCities(Province province) {
		return cityDao.findAllCities(province);
	}
	
	
}
