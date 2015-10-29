package db;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Notification;

public class NotificationDAOImpl implements NotificationDAO {

	private DBHelper dbHelper = new DBHelper();

	@Override
	public Notification getNotification(Integer id) {
		ResultSet rs = dbHelper
				.executeQuery("select N.id as id, CA.id as categoryId, CA.name as categoryName, CH.id as childId, CH.name as childName,"
						+ "	N.content as content, CO.id as contextId,  CO.name as contextName, CONT.id as contentId, CONT.name as contentName, N.date_sent as date_sent"
						+ " from NOTIFICATION as N, CONTENT as CONT, CATEGORY as CA, CONTEXT as CO, CHILD as CH where N.id="
						+ id
						+ " "
						+ "and CA.id =  N.category and CONT.id = n.content and CO.id = N.context and CH.id= N.child");
		Notification notification = null;
		try {
			while (rs.first()) {
				notification = new Notification();

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
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				Date today = df.parse(rs.getString("date_sent"));
				notification.setDate(today);

			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
		return notification;
	}

	@Override
	public void saveNotification(Notification notificacion) {
		try {
			String query = "INSERT INTO NOTIFICATION (CONTENT,CONTEXT,CATEGORY,CHILD)"
					+ "VALUES ('"
					+ notificacion.getContent().getId()
					+ "','"
					+ notificacion.getContext().getId()
					+ "','"
					+ notificacion.getCategory().getId()
					+ "','"
					+ notificacion.getChild().getId() + "')";
			dbHelper.executeUpdate(query);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Override
	public List<Notification> listNotifications() {
		List<Notification> result = new ArrayList<Notification>();
		ResultSet rs = dbHelper
				.executeQuery("select N.id as id, CA.id as categoryId, CA.name as categoryName, CH.id as childId, CH.name as childName,"
						+ "	N.content as content, CO.id as contextId,  CO.name as contextName, CONT.id as contentId, CONT.name as contentName, N.date_sent as date_sent"
						+ " from NOTIFICATION as N, CONTENT as CONT, CATEGORY as CA, CONTEXT as CO, CHILD as CH where "
						+ " CA.id =  N.category and CONT.id = N.content and CO.id = N.context and CH.id= N.child");
		try {
			while (rs.next()) {
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
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				Date today = df.parse(rs.getString("date_sent"));
				notification.setDate(today);
				result.add(notification);

			}
			dbHelper.closeConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}

}
