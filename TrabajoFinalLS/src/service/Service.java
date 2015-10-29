package service;

import java.util.List;

import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public interface Service {

	List<Notification> getNotificationList();
	
	List<Label> getLabelList();
	
	List<Category> getCategoryList();
	
	List<Context> getContextList();
	
	List<Child> getChildList();
	
	List<Content> getContentList();
	
	void CreateLabel(Label label);
	
	void DeleteLabel(Label label);
	
	void updateLabel(Label label, String name);

	void asingLabel(int idNotification, int idLabel);
	
	Label getLabel(String name);
}
