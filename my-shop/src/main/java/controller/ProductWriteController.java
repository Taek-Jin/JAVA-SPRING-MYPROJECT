package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Board.BoardRequest;
import Category.Category;
import Category.CategoryDao;
import Category.CategoryListService;
import Login.AuthInfo;
import Product.Product;
import Product.ProductDao;
import Product.ProductRequest;
import Product.ProductWriteService;



@Controller
public class ProductWriteController {

	private ProductWriteService productWriteService;
	private ProductDao productDao;
	private CategoryDao categoryDao;
	private CategoryListService categoryListService;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public void setProductWriteService(ProductWriteService productWriteService) {
		this.productWriteService = productWriteService;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public void setCategoryListService(CategoryListService categoryListService) {
		this.categoryListService = categoryListService;
	}
	
	@RequestMapping("/product/write")
	public String handleStep2(Model model, ProductRequest proReq) throws JsonProcessingException {
		
		ObjectMapper objm = new ObjectMapper();
		
		List<Category> list = categoryListService.listPage();
		
		String cateList = objm.writeValueAsString(list);
		
		model.addAttribute("cateList", cateList);
		
		return "product/write";
	}
	
	@PostMapping("/product/write2")
	public String handleStep3(Product product, ProductRequest proReq, HttpSession session, MultipartFile files) throws Exception{
		
			productWriteService.saveItem(product, files);
			AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
			productWriteService.write(proReq, authInfo.getEmail(), authInfo.getName(), product.getImagePath(), product.getImageName());
			
			return "redirect:/";

	}
}
