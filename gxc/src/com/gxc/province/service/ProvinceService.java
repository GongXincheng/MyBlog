package com.gxc.province.service;

import java.util.List;

import com.gxc.province.domain.Province;

public interface ProvinceService {

	/**
	 * 查询所有的省份
	 * @return
	 */
	List<Province> findAllProvince();

}
