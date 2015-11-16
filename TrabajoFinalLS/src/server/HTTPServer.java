package server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import util.FileUtil;

public class HTTPServer {
	
	public void start() {
		HttpServer server;
		try {
			Properties prop = loadProperties();	
			server = HttpServer.create(new InetSocketAddress(Integer.parseInt(prop.getProperty("port"))), 0);
			server.createContext("/notification", new NotificationHandler());
			ExecutorService cachedPool = Executors.newCachedThreadPool();
			server.setExecutor(cachedPool);
			server.start();
			System.out.println("The server is running");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Properties loadProperties() throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileUtil().getFile("/conf.properties");
		if (input != null) {
			prop.load(input);
		} else {
			throw new FileNotFoundException("Server configuration file not found");
		}
		return prop;
	}
}
