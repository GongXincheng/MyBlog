package gxc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import gxc.dao.BoardDao;
import gxc.domain.Board;
import gxc.utils.HibernateUtil;

public class BoardDaoImpl implements BoardDao {

	/**
	 * 保存建议(留言)
	 */
	@Override
	public void save(Board board) {
		Session session = HibernateUtil.getCurrentSession();
		session.save(board);
	}

	/**
	 * 根据时间排序
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Board> findAllByDate(String orderBy) {
		Session session = HibernateUtil.getCurrentSession();
		
		String hql = "from Board b order by b.createDate "+orderBy;
		Query query = session.createQuery(hql);
		List<Board> list = (List<Board>)query.list();
		
		return list;
	}

}
