package tareas;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TareasServlet extends HttpServlet {
	private static final long serialVersionUID = -6544228691105449366L;
	private static final String NAVIGATION = "/Tareas.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		
	throws ServletException, IOException {
	this.insert(req.getParameter("nombreTarea"),req.getParameter("descripcionTarea"), req.getParameter("tareaRealizada"),req.getParameter("valorTarea"),req.getParameter("trabajoTarea"));
	resp.sendRedirect(NAVIGATION);
	}

	private void insert(final String parameter,final String parameter2,final String parameter3,final String parameter4,final String parameter5) {
	// TODO Auto-generated method stub
	TareasUtils.insert(parameter,parameter2,parameter3,parameter4,parameter5);
	}

}
