package Product;

import java.util.List;


public class ProductListService {

private ProductDao productDao;
	
	public ProductListService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public List<Product> listPage() {
		return productDao.selectAll();
	}
	
	public List<Product> listPageTop() {
		return productDao.selectTop();
	}
	
	public List<Product> listPageBottom() {
		return productDao.selectBottom();
	}
	
	public List<Product> listPageOuter() {
		return productDao.selectOuter();
	}
}
