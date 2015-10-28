package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Context;
import domain.Context;

public class ContextDAOImpl implements ContextDAO {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Context getContext(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from CONTEXT where id="+id);
		Context context = null;
		try {
			while (rs.first()) {
				context = new Context();
				context.setId(rs.getInt("id"));
				context.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return context;
	}

	@Override
	public void saveContext(Context context) {
		try {
			String query = "INSERT INTO CONTEXT (NAME)" +
				"VALUES ('"+context.getName()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}

	@Override
	public List<Context> listContexts() {
		List<Context> result =  new ArrayList<Context>();
		ResultSet rs = dbHelper.executeQuery("select * from CONTEXT");
		try {
			while (rs.next() ) {
				Context context = new Context();
				try {
					context.setId(rs.getInt("id"));
					context.setName(rs.getString("name"));
				    result.add(context);
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
