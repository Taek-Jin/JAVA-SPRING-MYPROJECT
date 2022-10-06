package Order;

public class OrderItemVO {
	
	/* 뷰로부터 전달받을 값 */
    private int productsId;
    
    private int productsCount;
    
	/* DB로부터 꺼내올 값 */
    private String productsName;    
    private int productsPrice; 
    private double productsDiscount;
    private int deliveryPrice;

	/* 만들어 낼 값 */
    private int totalPrice;
    
	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}

	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public int getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(int productsPrice) {
		this.productsPrice = productsPrice;
	}

	public double getProductsDiscount() {
		return productsDiscount;
	}

	public void setProductsDiscount(double productsDiscount) {
		this.productsDiscount = productsDiscount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
