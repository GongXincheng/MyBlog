package com.gxc.province.service.impl;

import java.util.List;

import com.gxc.province.dao.ProvinceDao;
import com.gxc.province.domain.Province;
import com.gxc.province.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {

	ProvinceDao provinceDao;
	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}
	
	/**
	 * 查询所有的省份
	 */
	@Override
	public List<Province> findAllProvince() {
		return provinceDao.findAllProvince();
	}

}
