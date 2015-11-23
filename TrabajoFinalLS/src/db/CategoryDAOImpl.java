package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Category;

public class CategoryDAOImpl implements CategoryDAO {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Category getCategory(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from CATEGORY where id="+id);
		Category category = null;
		try {
			while (rs.first()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return category;
	}
	
	private Category getCategory(String categoryName) {
		ResultSet rs = dbHelper.executeQuery("select * from CATEGORY where name='"+categoryName+"'");
		Category category = null;
		try {
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return category;
	}

	@Override
	public void saveCategory(Category category) {
		try {
			String query = "INSERT INTO CATEGORY (NAME)" +
				"VALUES ('"+category.getName()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}

	@Override
	public List<Category> listCategories() {
		List<Category> result =  new ArrayList<Category>();
		ResultSet rs = dbHelper.executeQuery("select * from CATEGORY");
		try {
			while (rs.next() ) {
				Category category = new Category();
				try {
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
				    result.add(category);
				} catch (Exception e) {
					System.err.println(e.getClass().getName() + ": " + e.getMessage());
				}
			  }
			dbHelper.closeConnection();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}

	@Override
	public Integer saveCategory(String categoryName) {
		try {
			Category category = this.getCategory(categoryName);
			if(category == null) {
				String query = "INSERT INTO CATEGORY (NAME)" +
					"VALUES ('"+categoryName+"')";
				return dbHelper.executeUpdate(query);
			} else {
				return category.getId();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return null;	
	}

}
