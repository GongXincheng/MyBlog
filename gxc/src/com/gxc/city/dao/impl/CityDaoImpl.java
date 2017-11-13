package com.gxc.city.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.city.dao.CityDao;
import com.gxc.city.domain.City;
import com.gxc.province.domain.Province;

public class CityDaoImpl extends HibernateDaoSupport implements CityDao {

	/**
	 * 根据省查询全部城市
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> findAllCities(Province province) {
		return this.getHibernateTemplate().find("from City where province = ?",province);
	}

}
