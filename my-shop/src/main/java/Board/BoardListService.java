package Board;

import java.util.List;

public class BoardListService {

	private BoardDao boardDao;
	
	public BoardListService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public List<Board> listPage(int displayPost, int postNum) {
		return boardDao.selectAll(displayPost, postNum);
	}
}
