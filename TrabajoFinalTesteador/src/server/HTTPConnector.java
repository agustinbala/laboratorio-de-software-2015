package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;


public class HTTPConnector {
	
	public void send(String json) {
					
		try {
			Properties prop = loadProperties();
			URL obj = new URL(prop.getProperty("url"));
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("POST");
	        connection.setDoOutput(true);
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setRequestProperty("Accept", "application/json");
	        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
	        osw.write(json);
	        osw.flush();
	        osw.close();
	        System.err.println(connection.getResponseCode());						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		InputStream input = getClass().getResourceAsStream("/conf.properties");		
		if (input != null) {
			prop.load(input);
		} else {
			throw new FileNotFoundException("Server configuration file not found");
		}
		return prop;
	}

	
	
}
