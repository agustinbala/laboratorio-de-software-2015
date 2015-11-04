package db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Label;


public class NotificationLabelDAOImpl implements NotificationLabelDAO{

	private DBHelper dbHelper = new DBHelper(); 
	
	@Override
	public void asignLabel(int idNotification, int idLabel) {
		try {
			String query = "INSERT INTO LABELNOTIFICATION (LABEL, NOTIFICATION)" +
				" VALUES ("+idLabel+","+idNotification+")";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
	}
	
	public List<Label> getLabelsByNotification(Integer notificationId){
		List<Label> result = new ArrayList<Label>();
		ResultSet rs = dbHelper.executeQuery("select L.id as id, L.name as name from LABELNOTIFICATION as N, LABEL as L where L.id = N.LABEL and NOTIFICATION="+notificationId);
		Label label = null;
		try {
			while (rs.next()) {
				label = new Label();
				label.setId(rs.getInt("id"));
				label.setName(rs.getString("name"));	
				result.add(label);
			}
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		return result;
	
	}

}
