package Order;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	
	private int orderId;
	
	private String addressName;

	private Long id;
	
	private String memberAddr1;
	
	private String memberAddr2;
	
	private String memberAddr3;
	
	private String orderState;
	
	private String deliveryCost;
	
	private LocalDateTime orderDate;
	
	private int orderFinalSalePrice;
	
	private List<OrderItemVO> orders;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public String getMemberAddr3() {
		return memberAddr3;
	}

	public void setMemberAddr3(String memberAddr3) {
		this.memberAddr3 = memberAddr3;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public List<OrderItemVO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItemVO> orders) {
		this.orders = orders;
	}
	
	public String getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(String deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderFinalSalePrice() {
		return orderFinalSalePrice;
	}

	public void setOrderFinalSalePrice(int orderFinalSalePrice) {
		this.orderFinalSalePrice = orderFinalSalePrice;
	}
    
}
