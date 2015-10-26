package parser;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Notification;

public class JSONParser {
	
    ObjectMapper objectMapper = new ObjectMapper();
     
	public List<Notification> getNotificationList(){
		List<Notification> result = null;
        try {
        	 result = objectMapper.readValue(new File("src/notificaciones.txt"), new TypeReference<List<Notification>>() { });
        } catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}	

}
