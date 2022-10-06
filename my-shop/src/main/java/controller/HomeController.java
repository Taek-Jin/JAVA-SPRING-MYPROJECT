package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Product.Product;
import Product.ProductListService;


@Controller
public class HomeController {

	private ProductListService productListService;
	
	public void setProductListService(ProductListService productListService) {
		this.productListService = productListService;
	}
	@RequestMapping("/")
	public String handleStep2(Model model) throws JsonProcessingException {
		
		
		List<Product> list = productListService.listPage();
		
		model.addAttribute("list", list);
		
		return "index";
	}
}
