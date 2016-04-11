package com.jyaa.servlet;

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

public class LoginServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String perfil;
	
	Hashtable<String, String> loginData;
       
    
    @Override
    public void init(ServletConfig servletConfig){
    	loginData = new Hashtable<String, String>();
    	Enumeration<String> users = servletConfig.getInitParameterNames();
    	while(users.hasMoreElements()){
    		String key = users.nextElement();
    		loginData.put(key, servletConfig.getInitParameter(key));
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
			
			//Mocked data
			if(user.equals("admin")) {
				perfil = "administrador";
			} else {
				perfil = "usuario";
			}
			
			if(loginData.containsKey(user) && loginData.get(user).equals(pass)){								
			    HttpSession session = request.getSession(true);
			    session.setAttribute("user", user);
			    session.setAttribute("perfil", perfil);
			    response.sendRedirect("/jruteros/main.jsp");
	    	}else{
	    		response.sendRedirect("/jruteros/login.html");
			}
			out.close();
	}

}