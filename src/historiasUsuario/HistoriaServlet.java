package historiasUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoriaServlet extends HttpServlet {
	private static final long serialVersionUID = -6544228691105449366L;
	private static final String NAVIGATION = "/Historia.jsp";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		
	throws ServletException, IOException {
	this.insert(req.getParameter("nombreHistoria"),req.getParameter("descripcionHistoria"), req.getParameter("prioridadHistoria"),req.getParameter("estimacionHistoria"), req.getParameter("esfuerzoHistoria"));
	resp.sendRedirect(NAVIGATION);
	}

	private void insert(final String parameter,final String parameter2,final String parameter3,final String parameter4,final String parameter5) {
	// TODO Auto-generated method stub
	HistoriaUtils.insert(parameter,parameter2,parameter3,parameter4,parameter5);
	}

}
