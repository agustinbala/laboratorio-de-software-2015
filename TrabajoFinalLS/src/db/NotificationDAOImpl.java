package db;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public class NotificationDAOImpl implements NotificationDAO {

	private DBHelper dbHelper = new DBHelper();
	private NotificationLabelDAO notificationLabelDAO = new NotificationLabelDAOImpl();
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");


	@Override
	public Notification getNotification(Integer id) {
		ResultSet rs = dbHelper.executeQuery("select N.id as id, CA.id as categoryId, CA.name as categoryName, CH.id as childId, CH.name as childName,"
									+ "	N.content as content, CO.id as contextId,  CO.name as contextName, CONT.id as contentId, CONT.name as contentName, N.date_sent as date_sent, N.DATE_RECEIVED as date_received"
									+ " from NOTIFICATION as N, CONTENT as CONT, CATEGORY as CA, CONTEXT as CO, CHILD as CH where N.id="+id+" "
											+ "and CA.id =  N.category and CONT.id = n.content and CO.id = N.context and CH.id= N.child");
		Notification notification = null;
		try {
			while (rs.first()) {
				notification = convertToDomain(rs);
			}
			dbHelper.closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return notification;
	}

	@Override
	public void saveNotification(Notification notificacion) {
		try {
			String query = "INSERT INTO NOTIFICATION (CONTENT,CONTEXT,CATEGORY,CHILD,DATE_SENT)" +
				"VALUES ('"+ 
				notificacion.getContent().getId()+"','"+
				notificacion.getContext().getId()+"','"+
				notificacion.getCategory().getId()+"','"+
				notificacion.getChild().getId()+"','"+
				df.format(notificacion.getDateReceived())+"')";
			dbHelper.executeUpdate(query);			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Override
	public List<Notification> listNotifications() {
		List<Notification> result =  new ArrayList<Notification>();
		ResultSet rs = dbHelper.executeQuery("select N.id as id, CA.id as categoryId, CA.name as categoryName, CH.id as childId, CH.name as childName,"
				+ "	N.content as content, CO.id as contextId,  CO.name as contextName, CONT.id as contentId, CONT.name as contentName, N.date_sent as date_sent , N.DATE_RECEIVED as date_received"
				+ " from NOTIFICATION as N, CONTENT as CONT, CATEGORY as CA, CONTEXT as CO, CHILD as CH where "
						+ " CA.id =  N.category and CONT.id = N.content and CO.id = N.context and CH.id= N.child");
		try {
			while (rs.next() ) {
				result.add(convertToDomain(rs));
			  }
			dbHelper.closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}

	@Override
	public List<Notification> getNotificationListByFilter(Category cat,
			Context contextParam, Content cont, Child childParam, Label label,
			String dateFrom, String dateTo) {
		List<Notification> result =  new ArrayList<Notification>();
		
		Date dateFromDate = null;
		Date dateToDate = null;
		String filter = "";
		String labelNotificationAlias = "";
		if(cat != null && cat.getId() != null){
			filter += " and N.category="+cat.getId();
		}
		if(contextParam != null && contextParam.getId() != null){
			filter += " and N.context="+contextParam.getId();
		}
		if(cont != null && cont.getId() != null){
			filter += " and N.content="+cont.getId();
		}
		if(childParam != null && childParam.getId() != null){
			filter += " and N.child="+childParam.getId();
		}
		if(label != null && label.getId() != null){
			filter += " and LB.NOTIFICATION = N.id and LB.LABEL ="+label.getId();
			labelNotificationAlias = ", LABELNOTIFICATION as LB";
		}
		
		if(dateFrom != null && !dateFrom.equals("")){
			try {
				dateFromDate = df.parse(dateFrom);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(dateTo != null && !dateTo.equals("")){
			try {
				dateToDate = df.parse(dateTo);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
			
		ResultSet rs = dbHelper.executeQuery("select DISTINCT N.id as id, CA.id as categoryId, CA.name as categoryName, CH.id as childId, CH.name as childName,"
				+ "	N.content as content, CO.id as contextId,  CO.name as contextName, CONT.id as contentId, CONT.name as contentName, N.date_sent as date_sent, N.DATE_RECEIVED as date_received "
				+ " from NOTIFICATION as N, CONTENT as CONT, CATEGORY as CA, CONTEXT as CO, CHILD as CH "+labelNotificationAlias+" where"
						+ " CA.id =  N.category and CONT.id = N.content and CO.id = N.context and CH.id= N.child "+filter);
		try {
			while (rs.next() ) {
				result.add(convertToDomain(rs));
			 }
			dbHelper.closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		
		
		filterByDate(result, dateToDate, dateFromDate);
		return result;
	}
	
	private void filterByDate(List<Notification> result,Date dateToDate, Date dateFromDate){
		List<Notification> toRemove;
		if(dateFromDate != null){
			 toRemove = new ArrayList<Notification>();
			for (Notification notification : result) {
				if(notification.getDate().before(dateFromDate)){
					toRemove.add(notification);
				}
			}
			result.removeAll(toRemove);
		}
		if(dateToDate != null){
			toRemove = new ArrayList<Notification>();
			for (Notification notification : result) {
				if(notification.getDate().after(dateToDate)){
					toRemove.remove(notification);
				}
			}
			result.removeAll(toRemove);
		}
	}
	
	private Notification convertToDomain(ResultSet rs) throws Exception{
		
		Notification notification = new Notification();

		notification.setId(rs.getInt("id"));
		Category category = new Category();
		category.setId(rs.getInt("categoryId"));
		category.setName(rs.getString("categoryName"));
		notification.setCategory(category);
		Child child = new Child();
		child.setId(rs.getInt("childId"));
		child.setName(rs.getString("childName"));
		notification.setChild(child);
		Context context = new Context();
		context.setId(rs.getInt("contextId"));
		context.setName(rs.getString("contextName"));
		notification.setContext(context);
		Content content = new Content();
		content.setId(rs.getInt("contentId"));
		content.setName(rs.getString("contentName"));
		notification.setContent(content);
		

		Date today = df.parse(rs.getString("date_sent"));
		notification.setDate(today);
		Date dateReceived = df.parse(rs.getString("date_received"));
		notification.setDateReceived(dateReceived);
		
		
		notification.setLabels(notificationLabelDAO.getLabelsByNotification(notification.getId()));
		return notification;
	}
	


}
