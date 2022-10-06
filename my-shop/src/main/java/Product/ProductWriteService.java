package Product;


import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;


public class ProductWriteService {

	private ProductDao productDao;
	
	public ProductWriteService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public int write(ProductRequest req, String EMAIL, String writer, String ImagePath, String ImageName) {
		Product newProduct = new Product();
		newProduct.setProductsName(req.getProductsName());
		newProduct.setPubleYear(req.getPubleYear());
		newProduct.setCateCode(req.getCateCode());
		newProduct.setCateName(req.getCateName());
		newProduct.setProductsPrice(req.getProductsPrice());
		newProduct.setProductsStock(req.getProductsStock());
		newProduct.setProductsDiscount(req.getProductsDiscount());
		newProduct.setProductsIntro(req.getProductsIntro());
		newProduct.setImageName(ImageName);
		newProduct.setImagePath(ImagePath);
		newProduct.setProductsContents(req.getProductsContents());
		newProduct.setRegDate(LocalDateTime.now());
		newProduct.setUpdateDate(LocalDateTime.now());
		newProduct.setBrandId(EMAIL);
		newProduct.setPublisher(writer);
		productDao.insert(newProduct);
		return newProduct.getProductsId();
	}
	 public void saveItem(Product product, MultipartFile files) throws Exception {

	        String oriImgName = files.getOriginalFilename();
	        String imgName = "";

	        String projectPath = "C:\\spring5fs\\sp5-chap05\\src\\main\\webapp\\resources\\img";

	        UUID uuid = UUID.randomUUID();

	        String savedFileName = uuid + "_" + oriImgName;

	        imgName = savedFileName;

	        File saveFile = new File(projectPath, imgName);

	        files.transferTo(saveFile);

	        product.setImageName(imgName);
	        product.setImagePath("resources/img/" + imgName);

	    }
	
}
