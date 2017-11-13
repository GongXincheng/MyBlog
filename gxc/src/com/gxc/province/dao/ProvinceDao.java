package com.gxc.province.dao;

import java.util.List;

import com.gxc.province.domain.Province;

public interface ProvinceDao {

	/**
	 * 查询所有的省份
	 * @return
	 */
	List<Province> findAllProvince();

}
