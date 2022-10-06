package Board;

import java.time.LocalDateTime;

public class BoardWriteService {
	
	private BoardDao boardDao;
	
	public BoardWriteService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public Long write(BoardRequest req, String EMAIL, String writer) {
		Board newBoard = new Board(req.getTitle(), req.getContent(), LocalDateTime.now());
		newBoard.setEMAIL(EMAIL);
		newBoard.setWriter(writer);
		newBoard.setView(1L);
		boardDao.insert(newBoard);
		return newBoard.getBoard_no();
	}
}
