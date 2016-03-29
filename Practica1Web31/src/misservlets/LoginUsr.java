package misservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/LoginUsr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsr() {
        super();    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response. setContentType("text/html");
			PrintWriter out=response.getWriter();
			user = request.getParameter("txtUsuario");
			pass = request.getParameter("txtConstrasenia");		
			if(user.equals("admin") && pass.equals("1234")){								
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Hola</title>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<h1>");
			    out.println("Bienvenido: " + user);
			    out.println("</h1>");
			    out.println("</body>");
			    out.println("</html>");
	    	}else{
	    		out.println("<html>");
			    out.println("<head>");
			    out.println("<title>Hola</title>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<h1>");
			    out.println("Verificá tus datos");
			    out.println("</h1>");
			    out.println("<a href='http://localhost:8080/misServlets/login.html'>Login</a>");
			    out.println("</body>");
			    out.println("</html>");
			}
			out.close();
	}

}
