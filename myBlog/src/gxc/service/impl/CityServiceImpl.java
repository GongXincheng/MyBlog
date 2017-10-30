package gxc.service.impl;

import java.util.List;
import gxc.dao.CityDao;
import gxc.dao.impl.CityDaoImpl;
import gxc.domain.City;
import gxc.service.CityService;

public class CityServiceImpl implements CityService {

	private CityDao cityDao = new CityDaoImpl();
	
	@Override
	public List<City> getAllCity() {
		List<City> list = cityDao.getAllCity();
		return list;
	}

	@Override
	public List<City> getCitysByProvinceid(String provinceid) {
		List<City> list = cityDao.getCitysByProvinceid(provinceid);
		return list;
	}

	@Override
	public City getCityByCityid(String cityid) {
		City city = cityDao.getCityByCityid(cityid);
		return city;
	}

}
