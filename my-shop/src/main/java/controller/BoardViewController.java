package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import Board.Board;
import Board.BoardDao;

@Controller
public class BoardViewController {

	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@GetMapping("/board/content")
	public String detail(Model model, @RequestParam("board_no") Long board_no) {
		Board board = boardDao.selectByBoardN(board_no);
		model.addAttribute("board",board);
		return "board/content";
	}
	
}
