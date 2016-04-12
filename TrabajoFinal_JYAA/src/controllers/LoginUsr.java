package controllers;

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
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String profile;
	Hashtable<String, String> userData;
       
 
    @Override
    public void init(ServletConfig servletConfig){
    	userData = new Hashtable<String, String>();
    	Enumeration<String> users = servletConfig.getInitParameterNames();
    	while(users.hasMoreElements()){
    		String key = users.nextElement();
    		userData.put(key, servletConfig.getInitParameter(key));
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response. setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 user = request.getParameter("txtUsuario");
		 pass = request.getParameter("txtConstrasenia");	
		
		 if(userData.containsKey(user) && userData.get(user).equals(pass)){								
		    HttpSession session = request.getSession(true);
		    session.setAttribute("user", user);		    
			if(user.equals("admin")) {
				 response.sendRedirect("/jruteros/adminHome.jsp");
			} else {
				 response.sendRedirect("/jruteros/home.jsp");
			}		
		   
		   
    	 }else{
    		response.sendRedirect("/jruteros/login.html");
		 }
		 out.close();
	}

}
