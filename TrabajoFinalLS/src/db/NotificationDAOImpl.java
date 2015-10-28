package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Notification;

public class NotificationDAOImpl implements NotificationDAO{

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Notification getNotification(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select * from NOTIFICATION where id="+id);
		Notification notification = null;
		try {
			while (rs.first()) {
				notification = new Notification();

				notification.setId(rs.getInt("id"));
				notification.setCategory(rs.getString("category"));
				notification.setChild(rs.getString("child"));
				notification.setContent(rs.getString("content"));
				notification.setContext(rs.getString("context"));
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				Date today = df.parse(rs.getString("date_sent"));
				notification.setDate(today);
				
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return notification;
	}

	@Override
	public void saveNotification(Notification notificacion) {
		try {
			String query = "INSERT INTO NOTIFICATION (CONTENT,CONTEXT,CATEGORY,CHILD)" +
				"VALUES ('"+ 
				notificacion.getContent()+"','"+
				notificacion.getContext()+"','"+
				notificacion.getCategory()+"','"+
				notificacion.getChild()+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Override
	public List<Notification> listNotifications() {
		List<Notification> result =  new ArrayList<Notification>();
		ResultSet rs = dbHelper.executeQuery("select * from NOTIFICATION");
		try {
			while (rs.next() ) {
				 Notification notification = new Notification();
				try {
					notification.setId(rs.getInt("id"));
					notification.setCategory(rs.getString("category"));
					notification.setChild(rs.getString("child"));
					notification.setContent(rs.getString("content"));
					notification.setContext(rs.getString("context"));
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

					Date today = df.parse(rs.getString("date_sent"));
					notification.setDate(today);
					result.add(notification);
				} catch (ParseException e) {
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
