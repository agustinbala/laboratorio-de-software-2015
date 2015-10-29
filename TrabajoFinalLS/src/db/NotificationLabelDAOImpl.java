package db;


public class NotificationLabelDAOImpl implements NotificationLabelDAO{

	private DBHelper dbHelper = new DBHelper(); 
	
	@Override
	public void asignLabel(int idNotification, int idLabel) {
		try {
			String query = "INSERT INTO NOTIFICATIONLABEL (IdLABEL, IdNOTIFICATION)" +
				"VALUES ("+idLabel+idNotification+")";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}		
		
	}

}
