package gxc.service.impl;

import java.util.Date;
import java.util.List;

import gxc.dao.BoardDao;
import gxc.dao.impl.BoardDaoImpl;
import gxc.domain.Board;
import gxc.service.BoardService;

public class BoardServiceImpl implements BoardService {

	BoardDao boardDao = new BoardDaoImpl();

	/**
	 * 添加留言
	 */
	@Override
	public void addBoard(Board board) {
		board.setCreateDate(new Date());
		boardDao.save(board);
	}

	/**
	 * 时间降序排序
	 */
	@Override
	public List<Board> getAllByDesc() {
		String orderBy = "desc";
		List<Board> boardList = boardDao.findAllByDate(orderBy);
		return boardList;
	}

	/**
	 *  时间升序排列
	 */
	@Override
	public List<Board> getAllByAsc() {
		String orderBy = "asc";
		List<Board> boardList = boardDao.findAllByDate(orderBy);
		return boardList;
	}
	
	
	
}
