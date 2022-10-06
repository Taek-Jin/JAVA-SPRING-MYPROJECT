package Product;

import java.time.LocalDateTime;

public class Product {
	/* 상품 id */
	private int productsId;
	
	/* 상품 이름 */
	private String productsName;
	
	/* 브랜드 id */
	private String brandId;
	
	/* 출시일 */
	private String publeYear;
	
	/* 브랜드 */
	private String publisher;
	
	/* 카테고리 코드 */
	private String cateCode;
	
	/* 카테고리 이름 */
	private String cateName;
	
	/* 상품 가격 */
	private int productsPrice;
	
	/* 상품 재고 */
	private int productsStock;
	
	/* 상품 할인률(백분율) */
	private double productsDiscount;
	
	/* 상품 소개 */
	private String productsIntro;
	
	/* 상품 목차 */
	private String productsContents;
	
	private String imagePath;
	
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/* 등록 날짜 */
	private LocalDateTime regDate;
	
	/* 수정 날짜 */
	private LocalDateTime updateDate;
	
	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}

	public String getProductsName() {
		return productsName;
	}

	public void setProductsName(String productsName) {
		this.productsName = productsName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getPubleYear() {
		return publeYear;
	}

	public void setPubleYear(String publeYear) {
		this.publeYear = publeYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(int productsPrice) {
		this.productsPrice = productsPrice;
	}

	public int getProductsStock() {
		return productsStock;
	}

	public void setProductsStock(int productsStock) {
		this.productsStock = productsStock;
	}

	public double getProductsDiscount() {
		return productsDiscount;
	}

	public void setProductsDiscount(double productsDiscount) {
		this.productsDiscount = productsDiscount;
	}

	public String getProductsIntro() {
		return productsIntro;
	}

	public void setProductsIntro(String productsIntro) {
		this.productsIntro = productsIntro;
	}

	public String getProductsContents() {
		return productsContents;
	}

	public void setProductsContents(String productsContents) {
		this.productsContents = productsContents;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
