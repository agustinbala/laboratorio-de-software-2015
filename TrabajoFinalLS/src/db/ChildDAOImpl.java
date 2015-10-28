package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Child;

public class ChildDAOImpl implements ChildDAO {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Child getChild(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from CHILD where id="+id);
		Child child = null;
		try {
			while (rs.first()) {
				child = new Child();
				child.setId(rs.getInt("id"));
				child.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return child;
	}

	@Override
	public void saveChild(Child child) {
		try {
			String query = "INSERT INTO CHILD (NAME)" +
				"VALUES ('"+child.getName()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}

	@Override
	public List<Child> listChilds() {
		List<Child> result =  new ArrayList<Child>();
		ResultSet rs = dbHelper.executeQuery("select * from CHILD");
		try {
			while (rs.next() ) {
				Child child = new Child();
				try {
					child.setId(rs.getInt("id"));
					child.setName(rs.getString("name"));
				    result.add(child);
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
