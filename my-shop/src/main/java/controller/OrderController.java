package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cart.CartService;
import Login.AuthInfo;
import Order.Order;
import Order.OrderItemVO;
import Order.OrderPageVO;
import spring.Member;
import spring.MemberDao;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao; 
	}
	
	@PostMapping("/view")
	public String handleStep1(OrderPageVO opv, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Member member = memberDao.selectById(authInfo.getId());
		List<OrderItemVO> list = opv.getOrders();

		model.addAttribute("member", member );
		model.addAttribute("opv", list );
		return "order/view";
	}
	@PostMapping("/payment")
	public String handleStep2(Order od) {
		
		System.out.println(od);		
		
		return "redirect:/";
	}
}
