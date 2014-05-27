<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="login.UsuarioUtils"%>
<%@page import="com.scrumexp.objects.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.scrumexp.objects.*" %>
<%@ page import="com.scrumexp.objectsStore.*" %>
<%@ page import="java.util.Set"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="javax.servlet.http.HttpSession" %>



<%  
	Usuario usuario = (Usuario) session.getAttribute("user");
	String currentUser;
	String autor = "VACIO";
	if (usuario==null) {
		currentUser="ERROR";
	}
	else {
		autor = usuario.getEmailusuarios();
		currentUser= usuario.getNombreusuarios();
	}
	%>
    
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>ScrumeXp</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	
</head>

<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">ScrumeXp</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#">Principal</a>
						</li>
						<li>
							<a href="#">Cuenta</a>
						</li>
					</ul>
				
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="/index.jsp" onclick="deleteAllCookies()">Salir</a>
						</li>
						
					</ul>
				</div>
				
			</nav>
			<br><br><br>
			
			<div class="page-header">
				<h1>
					HOLA!<br><small><%=currentUser%></small>
				</h1>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						Proyectos
					</h3>
				</div>
				<% List<Project> projects = ProjectStore.getEntries(usuario);		
					if (projects.size()<1) {%>
					<p><strong>NO TIENE PROYECTOS REGISTRADOS</strong> <p>
				<%}
					else { %>
						<form action="/main" method="post">
							<input type="hidden" id="project-title" name="project-title" value="">
				
				   		<%for (Project project: projects) {%>
							<div class="panel-body">
									<strong>Titulo:</strong><br> <%=project.getTitle()%> <br><br>
									<p>
										<strong>Descripcion:</strong><br>
										<%=project.getDescription() %>
									</p>
									<p> 
										<strong>Fecha de creacion:</strong><br>
										<%=project.getCreationDate()%>
									</p>
										<button type="submit" class="btn btn-info btn-block" onClick="project('<%=project.getTitle()%>')" >Ir</button>
									<br><br><br>	
							</div>
						<%} %>
						</form>
				<% } %>
				<div class="panel-footer">
				
					<a id="modal-857527" href="#modal-container-857527" role="button" class="btn" data-toggle="modal">Nuevo Poyecto</a>
							
					<div class="modal fade" id="modal-container-857527" role="form" aria-labelledby="myModalLabel" aria-hidden="true">

							<form class="modal-form modal-dialog form" action="/nproject" method="post" >
								<div class="modal-content">
									<div class="modal-header">
										 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h4 class="modal-title" id="nuevoProyecto">
											Nuevo Proyecto
										</h4>
									</div>
								<div class="modal-body">
								
									
										<p>
						 					<label for="project-title">Titulo</label>
						 					<input type="text" class="form-control" name="project-title" />
										</p>
										<p>
						 					<label for="description">Descripcion</label>
						 					<input type="textarea" class="form-control" name="description" />
										</p>



								</div>
								<div class="modal-footer">
							 		<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
							 		<button type="submit" class="btn btn-primary">Crear</button>
								</div>

							</form>

					</div>
				</div>


				</div>
			</div>
		</div>
		<br><br><br>
		<div class="col-md-4 column">
			
			<p>
				<img src="./img/ScrumeXpLOGO.png" class="img-rounded" align="center">
			</p>
		</div>
	</div>
</div>
<script type="text/javascript">
		function project(title) {

			var element = document.getElementById("project-title");
			element.value = title;
		}
</script>

<script type="text/javascript">
		function deleteAllCookies() {
		    var cookies = document.cookie.split(";");

		    for (var i = 0; i < cookies.length; i++) {
		    	var cookie = cookies[i];
		    	var eqPos = cookie.indexOf("=");
		    	var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
		    	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
		    }
		}
</script>
</body>
</html>