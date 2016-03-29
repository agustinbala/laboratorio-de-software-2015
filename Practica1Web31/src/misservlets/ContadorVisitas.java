package misservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContadorVisitas
 */
@WebServlet("/ContadorVisitas")
public class ContadorVisitas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer visitas =0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContadorVisitas() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if(visitas > 0){
			request.getAttribute("cantidadVisitas");
		}
		visitas= visitas+1;
		request.setAttribute("cantidadVisitas", visitas);
		PrintWriter writer = response.getWriter();
		writer.println("Este servlet lo visitaron: " + visitas.toString() + " usuario/s");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
