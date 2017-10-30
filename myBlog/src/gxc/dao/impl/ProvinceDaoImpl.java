package gxc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gxc.dao.ProvinceDao;
import gxc.domain.Province;
import gxc.utils.HibernateUtil;

public class ProvinceDaoImpl implements ProvinceDao {

	/**
	 * 查询全部省份
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Province> getAllProvince() {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from Province");
		List<Province> list = query.list();
		
		return list;
	}

	/**
	 * 通过省号得到省份
	 */
	@Override
	public Province getProvinceById(String provinceid) {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from Province p where p.provinceid=:provinceid");
		query.setString("provinceid", provinceid);
		Province province = (Province)query.uniqueResult();
		
		return province;
	}

}
