package gxc.dao;

import java.util.List;

import gxc.domain.Board;

public interface BoardDao {

	void save(Board board);

	List<Board> findAllByDate(String orderBy);

}
