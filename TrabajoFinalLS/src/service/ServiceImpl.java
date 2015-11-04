package service;

import java.util.Date;
import java.util.List;

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

public class ServiceImpl implements Service {

	LabelDAO labelDAO = new LabelDAOImpl();
	NotificationDAO notificationDAO = new NotificationDAOImpl();
	NotificationLabelDAO notificationLabelDAO = new NotificationLabelDAOImpl();
	ChildDAO childDAO = new ChildDAOImpl();
	ContextDAO contextDAO = new ContextDAOImpl();
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	ContentDAO contentDAO = new ContentDAOImpl();
	
	public  List<Notification> getNotificationList(){
		return notificationDAO.listNotifications();
	}
	
	public  List<Label> getLabelList(){
		return labelDAO.listLabels();
	}
	
	public  List<Category> getCategoryList(){
		return categoryDAO.listCategories();
	}
	
	public  List<Context> getContextList(){
		return contextDAO.listContexts();
	}
	
	public  List<Child> getChildList(){
		return childDAO.listChilds();
	}
	
	public  List<Content> getContentList(){
		return contentDAO.listContents();
	}

	@Override
	public void createLabel(Label label) {
		labelDAO.saveLabel(label);
		
	}

	@Override
	public void deleteLabel(Label label) {
		labelDAO.deleteLabel(label.getId());
		
	}

	@Override
	public void updateLabel(Label label, String name) {
		labelDAO.updateLabel(label, name);
		
	}

	@Override
	public void asignLabel(int idNotification, int idLabel) {
		notificationLabelDAO.asignLabel(idNotification, idLabel);
		
	}

	@Override
	public List<Notification> getNotificationListByFilter(Category cat,
			Context context, Content cont, Child child, Label label,
			Date dateFrom, Date dateTo) {
		return notificationDAO.getNotificationListByFilter(cat, context, cont, child, label, dateFrom, dateTo);
	}

}
