package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Login.AuthInfo;
import Order.Order;
import Order.OrderItemVO;
import Order.OrderService;
import spring.Member;
import spring.MemberDao;


@Controller
public class MypageViewController {

	private MemberDao memberDao;
	private OrderService orderSvc;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void setOrderService(OrderService orderSvc) {
		this.orderSvc = orderSvc;
	}
	
	@GetMapping("/mypage")
	public String detail(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Member member = memberDao.selectByEmail(authInfo.getEmail());
		model.addAttribute("member",member);
		return "mypage/myinfo";
	}

	@GetMapping("/mypage/order")
	public String cartPage(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		List<OrderItemVO> list = orderSvc.getOrderList(authInfo.getId());
		model.addAttribute("orderInfo", list );
		return "mypage/order";
	}
	
}
