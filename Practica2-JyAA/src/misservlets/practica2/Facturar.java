package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Facturar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();			
		 Enumeration<String> fields = request.getParameterNames();
		 while(fields.hasMoreElements()) {
			 String key = fields.nextElement();
			 if(key.contains("txtCantidad")){
				 if(request.getSession().getAttribute(key) == null) {
					 request.getSession().setAttribute(key, Integer.parseInt(request.getParameter(key)));
				 } else {
					 request.getSession().setAttribute(key, Integer.parseInt(request.getParameter(key)) + Integer.parseInt((String)request.getSession().getAttribute(key)));	
				 }
			 }
		 }
		
	}

}
