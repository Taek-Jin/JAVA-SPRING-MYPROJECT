package Cart;

import java.util.List;

import Order.Order;


public class CartService {
	
	private CartDao cartDao;
	
	public CartService(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public int addCart(Cart cart) {
		
		Cart checkCart = cartDao.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		try {
			return cartDao.insert(cart);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public List<Cart> getCartList(String EMAIL){
		return cartDao.selectAll(EMAIL);
	}
	
	public void Cartupdate(Cart cart) {
		
		cartDao.update(cart);
	}
	
	public void Cartdelete(Cart cart) {
		
		cartDao.delete(cart);
	}
	public void Cartdelete(Order od) {
		
		cartDao.delete(od);
		
	}

}
