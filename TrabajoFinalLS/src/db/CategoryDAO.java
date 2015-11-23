package db;

import java.util.List;

import domain.Category;

public interface CategoryDAO {

	public Category getCategory(Integer id);
	
	public void saveCategory(Category category);
	
	public Integer saveCategory(String categoryName);
	
	public List<Category> listCategories();
}
