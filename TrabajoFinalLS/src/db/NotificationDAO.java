package db;

import java.util.List;

import domain.Notification;

public interface NotificationDAO {

	public Notification getNotification(Integer id);
	
	public void saveNotification(Notification notificacion);
	
	public List<Notification> listNotifications();

}
