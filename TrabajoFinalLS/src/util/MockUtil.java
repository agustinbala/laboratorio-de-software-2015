package util;

import java.util.List;

import parser.JSONParser;
import db.LabelDAO;
import db.LabelDAOImpl;
import db.NotificationDAO;
import db.NotificationDAOImpl;
import domain.Label;
import domain.Notification;

public class MockUtil {

	public static void initData(){
		LabelDAO labelDAO = new LabelDAOImpl();
		NotificationDAO notificationDAO = new NotificationDAOImpl();
		
		
		List<Notification> notificaciones = JSONParser.getNotificationList(FileUtil.getFile("src/notifications.txt"));
		for (Notification notification : notificaciones) {
			notificationDAO.saveNotification(notification);
		}
		
		List<Label> labels = JSONParser.getLabelList(FileUtil.getFile("src/labels.txt"));
		for (Label label : labels) {
			labelDAO.saveLabel(label);
		}
	}
}
