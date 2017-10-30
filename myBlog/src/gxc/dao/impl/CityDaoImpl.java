package gxc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gxc.dao.CityDao;
import gxc.domain.City;
import gxc.utils.HibernateUtil;

public class CityDaoImpl implements CityDao {

	/**
	 * 查询全部城市
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCity() {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from City");
		List<City> list = (List<City>)query.list();
		
		return list;
	}

	/**
	 * 根据provinceid查询所有的城市
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitysByProvinceid(String provinceid) {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from City c where c.provinceid = :provinceid");
		query.setString("provinceid", provinceid);
		List<City> list = (List<City>)query.list();
		
		return list;
	}

	/**
	 * 根据cityid查询city
	 */
	@Override
	public City getCityByCityid(String cityid) {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from City c where c.cityid = :cityid");
		query.setString("cityid", cityid);
		City city = (City)query.uniqueResult();
		
		return city;
	}

}
