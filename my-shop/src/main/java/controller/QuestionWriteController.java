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
import Login.AuthInfo;
import Question.Question;
import Question.QuestionDao;
import Question.QuestionListService;
import Question.QuestionRequest;
import Question.QuestionWriteService;

@Controller
public class QuestionWriteController {
	private QuestionWriteService questionWriteService;
	private QuestionListService questionListService;
	private QuestionDao questionDao;
	
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	public void setQuestionWriteService(QuestionWriteService questionWriteService) {
		this.questionWriteService = questionWriteService;
	}
	public void setQuestionListService(QuestionListService questionListService) {
		this.questionListService = questionListService;
	}
	
	@RequestMapping("/mypage/question")
	public String handleStep1(Model model, @RequestParam("num") int num) {
		
		int cnt = questionDao.count();
		
		int postNum = 6;
		
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
		
		List<Question> list = questionListService.listPage(displayPost, postNum);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		return "mypage/qnaview";
	}
	
	@GetMapping("/mypage/question/content")
	public String detail(Model model, @RequestParam("question_no") int question_no) {
		Question question = questionDao.selectByQuestionN(question_no);
		model.addAttribute("question",question);
		return "question/content";
	}
	
	@PostMapping("/question/write")
		public String handleStep2(QuestionRequest regReq) {
			return "question/write";
		}
	@GetMapping("/question/write")
		public String handleStep2Get(QuestionRequest regReq) {
		return "question/write";
	}
	@PostMapping("/mypage/question/update")
		public String questionUpdate(QuestionRequest regReq) {
		questionWriteService.update(regReq);
		return "redirect:/mypage/question?num=1";
	}
	@PostMapping("/mypage/question/delete")
	public String questionDelete(QuestionRequest regReq) {
	questionWriteService.delete(regReq);
	return "redirect:/mypage/question?num=1";
}
	@PostMapping("/question/write2")
		public String handleStep3(QuestionRequest regReq, HttpSession session){
				AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
				questionWriteService.write(regReq, authInfo.getEmail(), authInfo.getName());
				return "redirect:/";

}
}
