package parser;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Label;
import domain.Notification;

public class JSONParser {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
    
	public static List<Notification> getNotificationList(File file){
		List<Notification> result = null;
        try {
        	 result = objectMapper.readValue(file, new TypeReference<List<Notification>>() { });
        } catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}	
	
	public static List<Label> getLabelList(File file){
		List<Label> result = null;
        try {
        	 result = objectMapper.readValue(file, new TypeReference<List<Label>>() { });
        } catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return result;
	}

}