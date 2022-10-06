package Cart;

public class Cart {
	
    private int cartId; 
    private String EMAIL;   
    private int productsId;   
    private int productsCount;
    
    private String productsName;
    private int productsPrice;
    private double productsDiscount;
    
    private int salePrice;
    private int totalPrice;
    
	public int getSalePrice() {
		return salePrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.productsPrice * (1-this.productsDiscount));
		this.totalPrice = this.salePrice*this.productsCount;
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
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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
}
