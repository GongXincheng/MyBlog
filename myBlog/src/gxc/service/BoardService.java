package gxc.service;

import java.util.List;

import gxc.domain.Board;

public interface BoardService {

	void addBoard(Board board);

	List<Board> getAllByDesc();

	List<Board> getAllByAsc();

}
