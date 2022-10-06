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
}
