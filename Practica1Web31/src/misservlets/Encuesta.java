package misservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encuesta
 */
@WebServlet("/Encuesta")
public class Encuesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Integer> contador = new ArrayList<Integer>();
	private boolean isFirst = true;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encuesta() {
        super(); 
        for(int i=0; i<6; i++){
			contador.add(0);
		}      
       
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
		 String[] checkedIds = request.getParameterValues("mascota");
		 for(int i=0; i<checkedIds.length; i++){
			 int j = searchId(checkedIds[i]);
			 contador.set(j, contador.get(j)+1);
		 }
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Encuesta</title>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<h1>");
		    out.println("Votación de mascotas");
		    out.println("</h1>");
		    out.println("<TABLE ALIGN='right' WIDTH='100%' CELLSPACING='2' CELLPADDING='2'>");
		    out.println("<TR> <TD ALIGN='right'>Perro</TD><TD  ALIGN='left'>"+ contador.get(0)+"</TD></TR>");		   
		    out.println("<TR> <TD ALIGN='right'>Gato</TD><TD ALIGN='left'>"+ contador.get(1)+"</TD></TR>");		  
		    out.println("<TR> <TD ALIGN='right'>Tortuga</TD><TD ALIGN='left'>"+ contador.get(2)+"</TD></TR>");		   
		    out.println("<TR> <TD ALIGN='right'>Conejo</TD><TD ALIGN='left'>"+ contador.get(3)+"</TD></TR>");		   
		    out.println("<TR> <TD ALIGN='right'>Uron</TD><TD ALIGN='left'>"+ contador.get(4)+"</TD></TR>");		   
		    out.println("<TR> <TD ALIGN='right'>Hamster</TD><TD ALIGN='left'>"+ contador.get(5)+"</TD></TR>");		    
		    out.println("</TABLE>");
		    out.println("La mascota mas votada fue: " + topMascota());
		    out.println("</br>");
		    out.println("Con un porcentaje del: " + topMascotaPorcentaje()+"%");
		    out.println("</br>");
		    out.println("<a href='http://localhost:8080/misServlets/mascotas.html'>Volver</a>");
		    out.println("</br>");
		    out.println("</body>");
		    out.println("</html>");
		 request.setAttribute("contadorMascota", contador);
		 isFirst = false;	
	}

	private String topMascotaPorcentaje() {
		Integer totalVotos = 0;
		Integer mayorCantidadVotos;
		for(int i=0; i<contador.size(); i++){
			totalVotos = totalVotos+contador.get(i);
			
		}
		mayorCantidadVotos = Integer.parseInt(topMascota());
		return String.valueOf(((Integer)mayorCantidadVotos*100/totalVotos));
	}

	private String topMascota() {
		int mayor = -1;		
		for(int i=0; i<contador.size(); i++){
			if(contador.get(i)>mayor){
				mayor = contador.get(i);
			}
		}
		
		return String.valueOf(mayor);
	}

	private int searchId(String mascota) {
		 switch (mascota) {
         case "Perro":
             return 0;
             
         case "Gato":
        	  return 1;
             
         case "Tortuga":
        	 return 2;
             
         case "Conejo":
             return 3;
             
         case "Uron":
             return 4;
             
         case "Hamster":
        	 return 5;
                
     }
		return 0;
	}

}