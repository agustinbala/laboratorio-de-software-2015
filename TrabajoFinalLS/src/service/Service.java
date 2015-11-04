package service;

import java.util.Date;
import java.util.List;

import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public interface Service {

	List<Notification> getNotificationList();
	
	List<Notification> getNotificationListByFilter(Category cat, Context context, Content cont,
													Child child, Label label, Date dateFrom, Date dateTo);
	
	List<Label> getLabelList();
	
	List<Category> getCategoryList();
	
	List<Context> getContextList();
	
	List<Child> getChildList();
	
	List<Content> getContentList();
	
	void createLabel(Label label);
	
	void deleteLabel(Label label);
	
	void updateLabel(Label label, String name);

	void asignLabel(int idNotification, int idLabel);
	
}
