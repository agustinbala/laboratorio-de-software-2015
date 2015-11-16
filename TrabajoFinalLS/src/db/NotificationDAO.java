package db;

import java.util.Date;
import java.util.List;

import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public interface NotificationDAO {

	public Notification getNotification(Integer id);
	
	public Integer saveNotification(Notification notificacion);
	
	public List<Notification> listNotifications();
	
	public List<Notification> getNotificationListByFilter(Category cat, Context context, Content cont,
			Child child, Label label, Date dateFrom, Date dateTo);

}
