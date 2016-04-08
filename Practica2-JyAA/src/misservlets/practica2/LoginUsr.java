package misservlets.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUsr
 */
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String name;
	private String codigoPostal;
	
	Hashtable<String, String> logins;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsr() {
        super();    
    }
    
    @Override
    public void init(ServletConfig servletConfig){
    	logins = new Hashtable<String, String>();
    	Enumeration<String> users = servletConfig.getInitParameterNames();
    	while(users.hasMoreElements()){
    		String key = users.nextElement();
    		logins.put(key, servletConfig.getInitParameter(key));
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			user = request.getParameter("txtUsuario");
			pass = request.getParameter("txtConstrasenia");	
			name = request.getParameter("txtNombre");	
			codigoPostal = request.getParameter("txtCodigoPostal");	
			
			if(logins.containsKey(user) && logins.get(user).equals(pass)){								
			    HttpSession session = request.getSession(true);
			    session.setAttribute("name", name);
			    session.setAttribute("codigoPostal", codigoPostal);
			    response.sendRedirect("/compras/productos");
	    	}else{
	    		response.sendRedirect("/compras/login.html");
			}
			out.close();
	}

}
