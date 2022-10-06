package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Board.Board;
import Board.BoardDao;
import Board.BoardListService;
import Board.BoardRequest;
import Board.BoardWriteService;
import Login.AuthInfo;

@Controller
public class BoardWriteController {

	private BoardWriteService boardWriteService;
	private BoardListService boardListService;
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public void setBoardWriteService(BoardWriteService boardWriteService) {
		this.boardWriteService = boardWriteService;
	}
	public void setBoardListService(BoardListService boardListService) {
		this.boardListService = boardListService;
	}
	
	@RequestMapping("/board")
	public String handleStep1(Model model, @RequestParam("num") int num) {
		
		int cnt = boardDao.count();
		
		int postNum = 10;
		
		int pageNum = (int)Math.ceil((double)cnt/postNum);
		
		int pageNum_cnt = 10;
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt)*pageNum_cnt);
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		int endPageNum_tmp = (int)(Math.ceil((double)cnt / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= cnt ? false : true;
		
		int displayPost = (num - 1)*postNum;
		
		List<Board> list = boardListService.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		return "board/board";
	}
	
	@PostMapping("/board/write")
		public String handleStep2(BoardRequest regReq) {
			return "board/write";
		}
	@GetMapping("/board/write")
		public String handleStep2Get(BoardRequest regReq) {
		return "board/write";
	}
	
	@PostMapping("/board/write2")
		public String handleStep3(BoardRequest regReq, HttpSession session){
				AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
				boardWriteService.write(regReq, authInfo.getEmail(), authInfo.getName());
				return "redirect:/board?num=1";

}
}