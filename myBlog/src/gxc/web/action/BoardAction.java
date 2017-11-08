package gxc.web.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;
import gxc.domain.Board;
import gxc.service.BoardService;
import gxc.service.impl.BoardServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BoardAction extends ActionSupport implements ModelDriven<Board>{
	private static final long serialVersionUID = 2863174411228225921L;
	
	private Board board = new Board();
	private List<Board> boardList;
	private String result;
	
	private BoardService boardService = new BoardServiceImpl();
	
	/**
	 * 保存留言
	 * @return
	 */
	public String saveBoard(){
		JSONObject json = new JSONObject();
		
		//判断留言格式
		if(StringUtils.isBlank(board.getUsername())){
			board.setUsername("匿名");
		}
		if(board.getMsgTitle().length()>40){
			board.setMsgTitle(board.getMsgTitle().substring(0, 20));
		}
		if(board.getMessage().length()>200){
			board.setMessage(board.getMessage().substring(0, 100));
		}
			
		
		//添加
		try {
			boardService.addBoard(board);
			json.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
			json.put("msg", "未知错误，请联系开发人员");
		}
		result = json.toString();
		return SUCCESS;
	}
	
	
	/**
	 * 根据留言时间查询(最近)
	 */
	public String allBoardByDesc(){
		boardList = boardService.getAllByDesc();
		return "allBoard";
	}
	
	/**
	 * 根据最早留言(最早)
	 */
	public String allBoardByAsc(){
		boardList = boardService.getAllByAsc();
		return "allBoard";
	}
	
	
	@Override
	public Board getModel() {
		return board;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public BoardService getBoardService() {
		return boardService;
	}
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
}
