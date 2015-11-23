package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Label;

public class LabelDAOImpl implements LabelDAO {

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Label getLabel(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from LABEL where id="+id);
		Label label = null;
		try {
			while (rs.first()) {
				label = new Label();
				label.setId(rs.getInt("id"));
				label.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return label;
	}
	
	private Label getLabel(String labelName) {
		ResultSet rs = dbHelper.executeQuery("select * from LABEL where name='"+labelName+"'");
		Label label = null;
		try {
			while (rs.next()) {
				label = new Label();
				label.setId(rs.getInt("id"));
				label.setName(rs.getString("name"));				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return label;
	}

	@Override
	public void saveLabel(Label label) {
		try {
			String query = "INSERT INTO LABEL (NAME)" +
				"VALUES ('"+label.getName()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}

	@Override
	public List<Label> listLabels() {
		List<Label> result =  new ArrayList<Label>();
		ResultSet rs = dbHelper.executeQuery("select * from LABEL");
		try {
			while (rs.next() ) {
				Label label = new Label();
				try {
					label.setId(rs.getInt("id"));
					label.setName(rs.getString("name"));
				    result.add(label);
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
	public void deleteLabel(Integer id) {
		try {
			String query = "DELETE FROM LABEL WHERE LABEL.id=" + id.toString();
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}	
	}

	@Override
	public void updateLabel(Label label, String name) {
		try {
			String query = "UPDATE LABEL SET name='"+name+"' WHERE id="+label.getId();
			dbHelper.executeUpdate(query);				
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}	
		
	}

	@Override
	public Integer saveLabel(String labelName) {
		try {
			Label label = this.getLabel(labelName);
			if(label == null){
				String query = "INSERT INTO LABEL (NAME)" +
					"VALUES ('"+labelName+"')";
				return dbHelper.executeUpdate(query);
			} else {
				return label.getId();
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return null;		
	}

}
