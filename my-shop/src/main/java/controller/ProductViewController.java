package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Product.Product;
import Product.ProductDao;


@Controller
public class ProductViewController {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@GetMapping("/product/content")
	public String detailView(Model model, @RequestParam("productsId") int productsId) {
		Product product = productDao.selectByProductId(productsId);
		model.addAttribute("product",product);
		return "product/content";
	}
}
