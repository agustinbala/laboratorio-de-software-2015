package mock;

import java.util.ArrayList;
import java.util.List;

import server.HTTPConnector;
import domain.Notification;



public class TestGenerator {

	private static List<Notification> notifications = new ArrayList<Notification>();
	private static String json;
	
	public static void main(String[] args) {		
		
		notifications = MockGenerator.createMockInstances(Notification.class, 40);
		json = JsonGenerator.createJson(notifications);
		HTTPConnector httpserver = new HTTPConnector();
		httpserver.send(json);
		
	}

}
