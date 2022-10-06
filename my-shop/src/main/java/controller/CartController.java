package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Cart.Cart;
import Cart.CartService;
import Login.AuthInfo;

@Controller
public class CartController {

	private CartService cartService;
	
	public void setCartService(CartService cartService) {
		this.cartService = cartService; 
	}
	
	@ResponseBody
	@PostMapping("/cart/add")
	public String addCartPOST(Cart cart, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		if(authInfo == null) {
			return "5";
		}
		int result = cartService.addCart(cart);
		
		return result + "";
	}

	@GetMapping("/cart")
	public String cartPage(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		List<Cart> list = cartService.getCartList(authInfo.getEmail());
		model.addAttribute("cartInfo", list );
		return "/cart/view";
	}
	
	@PostMapping("/cart/update")
	public String updateCartPOST(Cart cart) {
		
		cartService.Cartupdate(cart);
		
		return "redirect:/cart/";
		
	}
	
	@PostMapping("/cart/delete")
	public String deleteCartPOST(Cart cart) {
		
		cartService.Cartdelete(cart);
		
		return "redirect:/cart/";
		
	}
}
