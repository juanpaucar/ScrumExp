<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="login.*"%>
<%@page import="com.scrumexp.objects.Usuario"%>
<%@page import="login.UsuarioUtils"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Impresion</title>

</head>
<body background="/img/fondo.jpg">			 


	<div class="container">
	<div class="row clearfix">
		<div class="col-md-6 column">
			<h3 class="text-center text-primary">
				Usuarios registrados
			</h3>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							Nombre
						</th>
						<th>
							Email
						</th>
						<th>
							Contrase&ntilde;a
						</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Usuario> aux = UsuarioUtils.getEntries();
									for (Usuario usuario : aux) {
					%>
					<tr>
						<td>
							<%=usuario.getNombreusuarios()%>
						</td>
						<td>
							<%=usuario.getEmailusuarios()%>
						</td>
						<td>
							<%=usuario.getContraseniausuarios()%>
						</td>
					</tr>
					<%} %>


				</tbody>
			</table> <button type="button" class="btn btn-lg btn-success btn-block" onclick="history.go(-1)">Regresar a la pantalla principal</button>
		</div>
		<div class="col-md-6 column">
		</div>
	</div>
</div>
</body>
</html>