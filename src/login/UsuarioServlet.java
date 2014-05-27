package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scrumexp.objects.Usuario;

@SuppressWarnings("serial")
public class UsuarioServlet extends HttpServlet {
		private static final long serialVersionUID = -6544228691105449366L;

		private static final String NAVIGATION = "/Usuarios.jsp"; 
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			
		throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			String username= req.getParameter("nombreusuarios");
			String email= req.getParameter("emailusuarios");
			String password = req.getParameter("contraseniausuarios");
			String validacion = validar(username, email, password);
			if (validacion.equals("")) {
				this.insert(username, email, password);
				out.write(INGRESO_EXITOSO_HTML);
			}
			else {
				String respuesta = INGRESO_FALLIDO_HTML_INICIO + validacion + INGRESO_FALLIDO_HTML_FINAL;
				out.write(respuesta);
			}
			
			
			
			//resp.sendRedirect(NAVIGATION);
		}
	
		private Usuario insert(final String parameter,final String parameter2,final String parameter3) {
			return UsuarioUtils.insert(parameter,parameter2,parameter3);
		}

		private String validar(String username, String email, String password) {
			String respuesta="";
			List<Usuario> lista= UsuarioUtils.getEntries();
			for (Usuario usuario : lista) {
				if (usuario.getNombreusuarios().equals(username) || usuario.getEmailusuarios().equals(email)) {				
					return "<p>El nombre de usuario o correo que ha seleccionado ya está ocupado, por favor seleccione otro<p>";
				}
			}
			if (username.length()<3 || password.length()<3) {
				respuesta+="<p>El nombre de usuario y la contraseña deben ser de al menos 3 caracteres de largo</p>";
			}
			if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
				respuesta+="<p>El correo usado no parece válido, por favor revíselo también<p>";
			}
			return respuesta;
		}
		
		private static final String INGRESO_EXITOSO_HTML= "<html><head>  <meta charset=\"utf-8\">  <title>ScrumeXp</title>  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">  <meta name=\"description\" content=\"\">  <meta name=\"author\" content=\"\">	<!--link rel=\"stylesheet/less\" href=\"less/bootstrap.less\" type=\"text/css\" /-->	<!--link rel=\"stylesheet/less\" href=\"less/responsive.less\" type=\"text/css\" /-->	<!--script src=\"js/less-1.3.3.min.js\"></script-->	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->	<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">	<link href=\"css/style.css\" rel=\"stylesheet\">  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->  <!--[if lt IE 9]>    <script src=\"js/html5shiv.js\"></script>  <![endif]-->  <!-- Fav and touch icons -->  <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"img/apple-touch-icon-144-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"img/apple-touch-icon-114-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"img/apple-touch-icon-72-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" href=\"img/apple-touch-icon-57-precomposed.png\">  <link rel=\"shortcut icon\" href=\"img/favicon.png\">	<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>	<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>	<script type=\"text/javascript\" src=\"js/scripts.js\"></script></head><body><div class=\"container\">	<div class=\"row clearfix\">		<div class=\"col-md-12 column\">			<div class=\"jumbotron\">	<h1>Usuario Ingresado</h1><p>El usuario que usted ingresó fue correctamente ingresado en la base de datos, puedes proseguir loguearte con ese usuario</p><p><a class=\"btn btn-primary btn-large\" href=\"/index.jsp\">Principal</a></p></div></div></div></div></body></html>";
		private static final String INGRESO_FALLIDO_HTML_INICIO= "<html><head>  <meta charset=\"utf-8\">  <title>ScrumeXp</title>  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">  <meta name=\"description\" content=\"\">  <meta name=\"author\" content=\"\">	<!--link rel=\"stylesheet/less\" href=\"less/bootstrap.less\" type=\"text/css\" /-->	<!--link rel=\"stylesheet/less\" href=\"less/responsive.less\" type=\"text/css\" /-->	<!--script src=\"js/less-1.3.3.min.js\"></script-->	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->	<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">	<link href=\"css/style.css\" rel=\"stylesheet\">  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->  <!--[if lt IE 9]>    <script src=\"js/html5shiv.js\"></script>  <![endif]-->  <!-- Fav and touch icons -->  <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"img/apple-touch-icon-144-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"img/apple-touch-icon-114-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"img/apple-touch-icon-72-precomposed.png\">  <link rel=\"apple-touch-icon-precomposed\" href=\"img/apple-touch-icon-57-precomposed.png\">  <link rel=\"shortcut icon\" href=\"img/favicon.png\">	<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>	<script type=\"text/javascript\" src=\"js/bootstrap.min.js\"></script>	<script type=\"text/javascript\" src=\"js/scripts.js\"></script></head><body><div class=\"container\">	<div class=\"row clearfix\">		<div class=\"col-md-12 column\">			<div class=\"jumbotron\">	<h1>Hubo un error en los datos =(</h1>";
		private static final String INGRESO_FALLIDO_HTML_FINAL= "<p><a class=\"btn btn-primary btn-large\" href=\"Usuarios.jsp\">Regresar</a></p>			</div></div></div></div></body></html>";
}
