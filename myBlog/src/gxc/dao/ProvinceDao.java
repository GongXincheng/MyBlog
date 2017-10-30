package gxc.dao;

import gxc.domain.Province;

import java.util.List;

public interface ProvinceDao {

	/**
	 * 查询全部省份
	 * @return
	 */
	public List<Province> getAllProvince();
	
	/**
	 * 通过省号得到省份
	 * @param provinceid
	 * @return
	 */
	public Province getProvinceById(String provinceid);
	
}
