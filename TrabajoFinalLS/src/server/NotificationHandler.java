package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import domain.Label;
import domain.Notification;
import parser.JSONParser;
import service.Service;
import service.ServiceImpl;
import view.OnNotificationReceived;

public class NotificationHandler  implements HttpHandler {

	private Service service = new ServiceImpl();
	private OnNotificationReceived onNotificationReceived;
	
	
	
	public NotificationHandler(OnNotificationReceived onNotificationReceived) {
		super();
		this.onNotificationReceived = onNotificationReceived;
	}

	@Override
	public void handle(HttpExchange t) throws IOException {
		String body = "";
		if ("POST".equals(t.getRequestMethod())) {
			body = readBody(t);
			List<Notification> notificaciones = JSONParser.getNotificationList(body);

			for (Notification notification : notificaciones) {
				Integer notId = service.createNotification(notification);
				for (Label label : notification.getLabels()) {
					service.asignLabel(notId, label.getId());
				}
			}
			onNotificationReceived.onNotification();
			String response = "Notificacion recibida correctamente";
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	private String readBody(HttpExchange t) {
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(t.getRequestBody(),"utf-8");
			BufferedReader br = new BufferedReader(isr);
			int b;
			StringBuilder buf = new StringBuilder(512);
			while ((b = br.read()) != -1) {
			    buf.append((char) b);
			}
			br.close();
			isr.close();
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
