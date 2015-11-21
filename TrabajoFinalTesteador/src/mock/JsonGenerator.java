package mock;

import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGenerator {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	private final static StringWriter sw =new StringWriter();
	
	public static <T> String createJson(List<T> lists){
		
		try {
			objectMapper.writeValue(sw, lists);
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		
		return sw.toString();
		
	}

}
