package util;

import java.util.List;

import db.CategoryDAO;
import db.CategoryDAOImpl;
import db.ChildDAO;
import db.ChildDAOImpl;
import db.ContentDAO;
import db.ContentDAOImpl;
import db.ContextDAO;
import db.ContextDAOImpl;
import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;
import parser.JSONParser;
import service.Service;
import service.ServiceImpl;

public class MockUtil {

	public static void initData(){
		ChildDAO childDAO = new ChildDAOImpl();
		ContextDAO contextDAO = new ContextDAOImpl();
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		ContentDAO contentDAO = new ContentDAOImpl();
		FileUtil fileUtil = new FileUtil();
		Service service = new ServiceImpl();
		
		List<Label> labels = JSONParser.getLabelList(fileUtil.getFile("/labels.txt"));
		for (Label label : labels) {
			service.createLabel(label);
		}

		List<Notification> notificaciones = JSONParser.getNotificationList(fileUtil.getFile("/notifications.txt"));
		for (Notification notification : notificaciones) {
			service.createNotification(notification);
		}
		
		List<Category> categories = JSONParser.getCategoryList(fileUtil.getFile("/categories.txt"));
		for (Category cat : categories) {
			categoryDAO.saveCategory(cat);
		}
		
		List<Child> childs = JSONParser.getChildList(fileUtil.getFile("/child.txt"));
		for (Child child : childs) {
			childDAO.saveChild(child);
		}
		
		List<Context> contexts = JSONParser.getContextList(fileUtil.getFile("/contexts.txt"));
		for (Context context : contexts) {
			contextDAO.saveContext(context);
		}
		
		List<Content> contents = JSONParser.getContentList(fileUtil.getFile("/contents.txt"));
		for (Content content : contents) {
			contentDAO.saveContent(content);
		}
		
		
	}	
}
