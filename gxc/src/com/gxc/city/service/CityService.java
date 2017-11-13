package com.gxc.city.service;

import java.util.List;

import com.gxc.city.domain.City;
import com.gxc.province.domain.Province;

public interface CityService {

	/**
	 * 根据省查询全部城市
	 * @param province
	 * @return
	 */
	List<City> findAllCities(Province province);
	
}
