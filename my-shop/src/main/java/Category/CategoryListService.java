package Category;

import java.util.List;

public class CategoryListService {
	
	private CategoryDao categoryDao;
	
	public CategoryListService(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	public List<Category> listPage() {
		return categoryDao.selectAll();
	}
}
