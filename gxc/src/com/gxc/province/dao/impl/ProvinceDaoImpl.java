package com.gxc.province.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gxc.province.dao.ProvinceDao;
import com.gxc.province.domain.Province;

public class ProvinceDaoImpl extends HibernateDaoSupport implements ProvinceDao{

	/**
	 * 查询所有的省份
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Province> findAllProvince() {
		List<Province> all = (List<Province>)this.getHibernateTemplate().find("from Province");
		return all;
	}
	
}
