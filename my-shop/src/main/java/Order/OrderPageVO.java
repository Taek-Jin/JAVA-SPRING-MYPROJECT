package Order;

import java.util.List;

public class OrderPageVO {

	private List<OrderItemVO> orders;

	public List<OrderItemVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItemVO> orders) {
		this.orders = orders;
	}
}
