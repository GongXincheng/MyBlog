package gxc.service.impl;

import java.util.List;
import gxc.dao.ProvinceDao;
import gxc.dao.impl.ProvinceDaoImpl;
import gxc.domain.Province;
import gxc.service.ProvinceService;

public class ProvinceServiceImpl implements ProvinceService {

	private ProvinceDao provinceDao = new ProvinceDaoImpl();
	
	@Override
	public List<Province> getAllProvince() {
		List<Province> list = provinceDao.getAllProvince();
		return list;
	}

	@Override
	public Province getProvinceById(String provinceid) {
		Province province = provinceDao.getProvinceById(provinceid);
		return province;
	}

}
