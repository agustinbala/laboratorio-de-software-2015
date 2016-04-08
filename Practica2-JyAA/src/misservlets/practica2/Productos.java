package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Hashtable<String, Double> productos;

	@Override
	public void init(ServletConfig servletConfig) {
		productos = new Hashtable<String, Double>();
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String key = names.nextElement();
			productos.put(key, Double.valueOf(servletConfig.getInitParameter(key)));
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession(false) != null) {
			if(request.getSession().getAttribute(productos.keys().nextElement()) != null){
				System.out.println("ES NEW");
			}
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>HTML creado dinámicamente</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>");
			out.println("Seleccione los productos");
			out.println("</h1>");
			out.println("<FORM ACTION='http://localhost:8080/compras/facturar' METHOD='POST'>");
			out.println("<TABLE ALIGN='left' WIDTH='100%' CELLSPACING='3' CELLPADDING='3'>");
			Enumeration<String> productKeys = productos.keys();
			while (productKeys.hasMoreElements()) {
				String key = productKeys.nextElement();
				out.println("<TR> <TD ALIGN='left' NAME='labelName" + key + "'>" + key
						+ "</TD><TD  ALIGN='left' NAME='labelPrice" + key + "'>" + productos.get(key) + "</TD>"
						+ "<TD  ALIGN='left'><INPUT TYPE='Text' NAME='txtCantidad" + key
						+ "' ALIGN='LEFT' SIZE='15'></TD></TR>");
			}
			out.println("</br>");
			out.println(
					"<TR><TD ALIGN='left'></TD><TD><INPUT ALIGN='LEFT' TYPE='Submit' NAME='enviar' VALUE='Facturar'></TD><TD ALIGN='left'> <a href='http://localhost:8080/compras/terminarSesion'>Salir</a> </TD></TR>");
			out.println("</TABLE>");
			out.println("</FORM>");
			out.println("</br>");
			out.println("</body>");
			out.println("</html>");
		} else {
			response.sendRedirect("/compras/login.html");
		}

	}

}
