package db;

import java.util.List;

import domain.Notification;

public class NotificationDAOImpl implements NotificationDAO{

	private DBHelper dbHelper = new DBHelper();
	
	@Override
	public Notification getNotification(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNotification(Notification notificacion) {
		try {
			String query = "INSERT INTO NOTIFICATION (CONTENT,CONTEXT,CATEGORY,CHILD,DATE_SENT)" +
				"VALUES ('"+notificacion.getContent()+"','"+notificacion.getContext()+"','"
				+notificacion.getCategory()+"','"+notificacion.getChild()+"', CURRENT_TIMESTAMP)";
			dbHelper.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Override
	public List<Notification> listNotifications() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
