package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Login.AuthInfo;
import spring.Member;
import spring.MemberDao;


@Controller
public class MypageViewController {

	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@GetMapping("/mypage")
	public String detail(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Member member = memberDao.selectByEmail(authInfo.getEmail());
		model.addAttribute("member",member);
		return "mypage/myinfo";
	}

	
}
