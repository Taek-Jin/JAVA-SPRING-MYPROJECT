package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cart.Cart;
import Cart.CartService;
import Login.AuthInfo;
import Order.Order;
import Order.OrderDao;
import Order.OrderItemVO;
import Order.OrderPageVO;
import Order.OrderService;
import spring.Member;
import spring.MemberDao;

@Controller
public class OrderController {
	
	private MemberDao memberDao;
	private OrderService orderSvc;
	private OrderDao orderDao;
	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService; 
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao; 
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void setOrderService(OrderService orderSvc) {
		this.orderSvc= orderSvc; 
	}
	
	@PostMapping("/order/view")
	public String handleStep1(OrderPageVO opv, Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		Member member = memberDao.selectById(authInfo.getId());
		List<OrderItemVO> list = opv.getOrders();

		model.addAttribute("member", member );
		model.addAttribute("opv", list );
		return "order/view";
	}

	@PostMapping("/order/payment")
	public String handleStep2(Order od) {
		cartService.Cartdelete(od);
		orderSvc.addOrder(od);
		orderSvc.addOrderItem(od);
		
		return "redirect:/";
	}
}
