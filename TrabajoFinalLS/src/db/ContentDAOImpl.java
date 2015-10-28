package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Category;
import domain.Content;

public class ContentDAOImpl implements ContentDAO {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Content getContent(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from CONTENT where id="+id);
		Content content = null;
		try {
			while (rs.first()) {
				content = new Content();
				content.setId(rs.getInt("id"));
				content.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return content;
	}

	@Override
	public void saveContent(Content content) {
		try {
			String query = "INSERT INTO CONTENT (NAME)" +
				"VALUES ('"+content.getName()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}

	@Override
	public List<Content> listContents() {
		List<Content> result =  new ArrayList<Content>();
		ResultSet rs = dbHelper.executeQuery("select * from CONTENT");
		try {
			while (rs.next() ) {
				Content content = new Content();
				try {
					content.setId(rs.getInt("id"));
					content.setName(rs.getString("name"));
				    result.add(content);
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

}
