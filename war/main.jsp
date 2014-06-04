<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="login.UsuarioUtils"%>
<%@page import="com.scrumexp.objects.Usuario"%>
<%@ page import="com.scrumexp.objects.*" %>
<%@ page import="com.scrumexp.objectsStore.*" %>
<%@ page import="java.util.Set"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 	Date finalizationDate = new Date(); //should be calculed by the last sprint ending
	Project currentProject = (Project) session.getAttribute("project");
	Usuario usuario = (Usuario) session.getAttribute("user");
	List<Story> stories = currentProject.getUserStories();
	int completedPercetage=0;
	if (stories.size()>0) {
		int size = stories.size();
		for (Story story : stories)
			if (story.isAccomplished())
				size--;
		completedPercetage = (int) (size/stories.size()*100.00);
	}
	List<Usuario> miembros = UsuarioUtils.getUsersBySetOfKeys(currentProject.getUsers());
	List<Sprint> sprints =  SprintStore.getSprints(currentProject);
	String newSprintName = "";
	if (sprints!= null && sprints.size()>0)
		 newSprintName = "Sprint "+(sprints.size()+1);
	else
		newSprintName = "Sprint 1";
	System.out.println(newSprintName);
%>

<!DOCTYPE html>
<html lang="es">
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
							<a href="#">Inicio</a>
						</li>
						<li>
							<a href="./Historia.jsp">Product Backlog</a>
						</li>
						<li>
							<a href="#">Sprint Backlog</a>
						</li>
						<li>
							<a href="#">Tareas pendientes</a>
						</li>
					</ul>
				
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="/projects.jsp">Principal</a>
						</li>
						
					</ul>
				</div>
				
			</nav>
			<br><br><br>
			<div class="jumbotron">
				<h1>
					¡Hola, <%=usuario.getNombreusuarios()%>!
				</h1>
				<p>
					Decir si tiene tareas pendientes aun o no
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="#">Ir a tareas</a>
				</p>
			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						Información
					</h3>
				</div>
				<div class="panel-body">
					<p><strong>Sprints</strong></p>
					<p>
						<%
						System.out.println("WEY LLEGUE AL IF DE LOS SPRINTS");
		  				System.out.println(sprints);
						if (sprints!=null && sprints.size()>0) {%>
							<ul>
								<%System.out.println("ME FUI POR EL SI");
								for (Sprint sprint: sprints)  {%>
									<li><%=sprint.getName()%></li>
								<%} %>
							</ul>
							<%} 
							else {%>
								<strong>NO TIENE SPRINTS TODAVIA</strong>
								<%System.out.println("ME FUI POR EL ELSE"); %>
							<%} 
							System.out.println("WEY PASE EL IF DE LOS SPRINTS");
							%>
					</p>
					<p>
						
							<a id="modal-857527" href="#newSprintModal" role="button" class="btn btn-success" data-toggle="modal"><em class="glyphicon glyphicon-plus"><strong> Nuevo Sprint</strong></em></a>
					</p>
				</div>
				<div class="panel-body">
					<p><strong>Historias de usuario:</strong></p>
					<p>
					<% if(stories!=null && stories.size()>0) {%>
						<ul>
							<%for (Story story: stories) {%>
								<li><%=story.getTitle()%></li>
							<%} %>
						</ul>
						<%} 
						else {%>
						<strong>NO TIENE HISTORIAS DE USUARIO TODAVIA</strong>
						<%} %>
					</p>
				</div>
				<div class="panel-footer">
					<p>
						<small>Fecha estimada de finalizacion: </small><strong><%=finalizationDate%></strong>
					</p>
				</div>
			</div>
		</div>
		<div id="new-sprint-modal">
					<div class="modal fade" id="newSprintModal" role="dialog" aria-labelledby="newSprintLabel" aria-hidden="true" tabindex="-1">
						<form class="modal-form modal-dialog form" action="/nsprint" method="post" >
							
							<div class="modal-content">
								<div class="modal-header">
									 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="newSprintModalLabel">
										Nuevo Sprint
									</h4>
								</div>
								<div class="modal-body">
										<p>
						 					<label for="new-sprint-name" >Nombre</label>
						 					<input type="text" class="form-control" id="new-sprint-name" value="<%=newSprintName%>" disabled="disabled">
										</p>
										<p>
											<label for="new-sprint-start-date" >Fecha de inicio</label>
						 					<input type="text" class="form-control" name="new-sprint-start-date">DD/MM/AAAA
										</p>
										<p>
											<label for="new-sprint-end-date" >Fecha de fin</label>
						 					<input type="text" class="form-control" name="new-sprint-end-date">DD/MM/AAAA
										</p>
										
										
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button> <button type="submit" class="btn btn-primary">ENVIAR</button>
								</div>
							</div>
							
						</form>
						
					</div>
				</div>
		<br><br><br>
		<div class="col-md-4 column">
			<p>
				<img src="./img/ScrumeXpLOGO.png" class="img-rounded" align="left">
			</p>
			<div class="page-header">
				<h1>
					<%=currentProject.getTitle()%><br><small><%=usuario.getNombreusuarios()%></small>
				</h1>
			</div>
			<p>
				<strong>Miembros:</strong><br>
				<ul>
					<%for (Usuario miembro: miembros) { %>
						<li><%=miembro.getNombreusuarios()%></li>
					<%} %>
				</ul>
			</p>
			<p>
				<small>Porcentage completado</small>
				<div class="progress active" aria-valuemin="0" aria-valuemax="100">
					<div class="progress-bar progress-success" style="width: <%=completedPercetage%>%;"><%=completedPercetage%>%</div>
				</div>
			</p>
			<p>
				<small>Tiempo usado</small>
				<div class="progress active" aria-valuemin="0" aria-valuemax="100">
					<div class="progress-bar progress-success" style="width: 75%;">75%</div>
				</div>
			</p>
		</div>
	</div>
</div>

</body>
</html>