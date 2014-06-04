package historiasUsuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class Actualizar extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException { 
	String nombreHistoria = req.getParameter("nombreHistoria"); 
	String descripcionHistoria = req.getParameter("ndescripcion");
	String prioridadHistoria = req.getParameter("nprioridad");
	String estimacionHistoria = req.getParameter("nestimacion");
	String esfuerzoHistoria = req.getParameter("nesfuerzo");
	
	HistoriaUtils.actualizarHistoria(nombreHistoria, descripcionHistoria, prioridadHistoria, estimacionHistoria, esfuerzoHistoria);
	
	resp.sendRedirect("/Historia.jsp");
	
	}
	
	

}




