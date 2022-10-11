package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Board.BoardDao;
import Board.BoardListService;
import Board.BoardWriteService;
import Cart.CartService;
import Category.CategoryDao;
import Category.CategoryListService;
import Login.AuthService;
import Order.OrderDao;
import Order.OrderService;
import Product.ProductDao;
import Product.ProductListService;
import Product.ProductWriteService;
import Question.QuestionDao;
import Question.QuestionListService;
import Question.QuestionWriteService;
import controller.BoardViewController;
import controller.BoardWriteController;
import controller.CartController;
import controller.ChangePwdController;
import controller.HomeController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberDetailController;
import controller.MypageViewController;
import controller.OrderController;
import controller.ProductViewController;
import controller.ProductWriteController;
import controller.QuestionWriteController;
import controller.RegisterController;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardWriteService boardWriSvc;
	@Autowired
	private BoardListService boardListSvc;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductWriteService productWriSvc;
	@Autowired
	private ProductListService productListSvc;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CategoryListService categoryListSvc;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private QuestionWriteService questionWriSvc;
	@Autowired
	private QuestionListService questionListSvc;
	@Autowired
	private CartService cartSvc;
	@Autowired
	private OrderService orderSvc;
	@Autowired
	private OrderDao orderDao;
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	@Bean
	public MemberDetailController memberDetailController() {
		MemberDetailController controller = new MemberDetailController();
		controller.setMemberDao(memberDao);
		return controller;
	}
	
	@Bean
	public BoardWriteController boardWriteController() {
		BoardWriteController controller = new BoardWriteController();
		controller.setBoardWriteService(boardWriSvc);
		controller.setBoardListService(boardListSvc);
		controller.setBoardDao(boardDao);
		return controller;
	}
	
	@Bean
	public BoardViewController boardViewController() {
		BoardViewController controller = new BoardViewController();
		controller.setBoardDao(boardDao);
		return controller;
	}
	
	@Bean
	public ProductWriteController productWriteController() {
		ProductWriteController controller = new ProductWriteController();
		controller.setProductDao(productDao);
		controller.setProductWriteService(productWriSvc);
		controller.setCategoryDao(categoryDao);
		controller.setCategoryListService(categoryListSvc);
		
		return controller;
	}
	
	@Bean
	public HomeController homeController() {
		HomeController controller = new HomeController();
		controller.setProductListService(productListSvc);
		
		return controller;
	}
	
	@Bean
	public ProductViewController productViewController() {
		ProductViewController controller = new ProductViewController();
		controller.setProductDao(productDao);
		return controller;
	}
	
	@Bean
	public QuestionWriteController questionWriteController() {
		QuestionWriteController controller = new QuestionWriteController();
		controller.setQuestionWriteService(questionWriSvc);
		controller.setQuestionListService(questionListSvc);
		controller.setQuestionDao(questionDao);
		return controller;
	}
	
	@Bean
	public MypageViewController mypageViewController() {
		MypageViewController controller = new MypageViewController();
		controller.setOrderService(orderSvc);
		controller.setMemberDao(memberDao);
		return controller;
	}
	@Bean
	public CartController cartController() {
		CartController controller = new CartController();
		controller.setCartService(cartSvc);
		return controller;
	}
	
	@Bean
	public OrderController orderController() {
		OrderController controller = new OrderController();
		controller.setOrderDao(orderDao);
		controller.setOrderService(orderSvc);
		controller.setMemberDao(memberDao);
		controller.setCartService(cartSvc);
		return controller;
	}
}
