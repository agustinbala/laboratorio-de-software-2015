package util;

import java.util.List;

import parser.JSONParser;
import db.CategoryDAO;
import db.CategoryDAOImpl;
import db.ChildDAO;
import db.ChildDAOImpl;
import db.ContentDAO;
import db.ContentDAOImpl;
import db.ContextDAO;
import db.ContextDAOImpl;
import db.LabelDAO;
import db.LabelDAOImpl;
import db.NotificationDAO;
import db.NotificationDAOImpl;
import db.NotificationLabelDAO;
import db.NotificationLabelDAOImpl;
import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public class MockUtil {

	public static void initData(){
		LabelDAO labelDAO = new LabelDAOImpl();
		NotificationDAO notificationDAO = new NotificationDAOImpl();
		ChildDAO childDAO = new ChildDAOImpl();
		ContextDAO contextDAO = new ContextDAOImpl();
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		ContentDAO contentDAO = new ContentDAOImpl();
		NotificationLabelDAO notificationLabelDAO = new NotificationLabelDAOImpl();
		
		List<Label> labels = JSONParser.getLabelList(FileUtil.getFile("src/labels.txt"));
		for (Label label : labels) {
			labelDAO.saveLabel(label);
		}
		

		List<Notification> notificaciones = JSONParser.getNotificationList(FileUtil.getFile("src/notifications.txt"));
		
		for (Notification notification : notificaciones) {
			notificationDAO.saveNotification(notification);
			
		}
		
		List<Category> categories = JSONParser.getCategoryList(FileUtil.getFile("src/categories.txt"));
		for (Category cat : categories) {
			categoryDAO.saveCategory(cat);
		}
		
		List<Child> childs = JSONParser.getChildList(FileUtil.getFile("src/child.txt"));
		for (Child child : childs) {
			childDAO.saveChild(child);
		}
		
		List<Context> contexts = JSONParser.getContextList(FileUtil.getFile("src/contexts.txt"));
		for (Context context : contexts) {
			contextDAO.saveContext(context);
		}
		
		List<Content> contents = JSONParser.getContentList(FileUtil.getFile("src/contents.txt"));
		for (Content content : contents) {
			contentDAO.saveContent(content);
		}
		
		List<Label> labelsFromDB = labelDAO.listLabels();
		List<Notification> notificacionesFromDB = notificationDAO.listNotifications();
		for (Notification notificationFromBD : notificacionesFromDB) {
			for (Label label : labelsFromDB) {
				notificationLabelDAO.asignLabel(notificationFromBD.getId(), label.getId());
			}			
		}
		
//		for (Label label : labelsFromDB) {
//			labelDAO.updateLabel(label,"ACTUALIZADO");
//		}
//		
//		labelDAO.deleteLabel(labelsFromDB.get(0).getId());
		
	}	
}
