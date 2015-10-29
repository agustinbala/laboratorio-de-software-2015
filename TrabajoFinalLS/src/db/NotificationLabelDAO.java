package db;

import java.util.List;

import domain.Label;


public interface NotificationLabelDAO {

	public void asignLabel(int idNotification, int idLabel);
	
	public List<Label> getLabelsByNotification(Integer notificationId);
}
