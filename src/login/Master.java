package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Master extends HttpServlet{
		
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException { 
			
			String emailusuarios=req.getParameter("emailusuario"); 
			String contraseniausuarios=req.getParameter("contraseniausuario"); 
		
			Usuario resultado= UsuarioUtils.getUsuario(emailusuarios, contraseniausuarios);
			if (resultado!=null) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Principal.jsp");
				rd.forward(req, resp);
			}else{
				resp.sendRedirect("/index.jsp");
			}
			
			
			/*
 			if(("Scrumexp@hotmail.com".equals(emailusuarios))&&("12345".equals(contraseniausuarios))){
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Principal.jsp");
 				//resp.sendRedirect(<a href="http://www.efectosjavascript.com/redireccion-javascript.html"></a>);		
				rd.forward(req, resp);
				//<a class="btn btn-default" href="ListarUsuarios.jsp" style="width: 338px; ">Listar</a>
				//<a class="btn btn-default" href="Usuarios.jsp" style="width: 338px; ">Registrar</a>
			}else{
				resp.sendRedirect("/index.jsp");
			}
 			*/
		}
			
}
