<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="login.Usuario"%>
<%@ page import="login.UsuarioUtils"%>
<%@ page import="java.util.*"%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

  <title>Usuarios</title>
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
		<div class="col-md-12 column">
			<h3 class="text-center">
				Registro de Usuarios
			</h3>
			
			<form action="/usuarios" method="post" >
			
			
				<div class="form-group">
					 <label for="exampleInputEmail1">Nombre</label><input  class="form-control" id="exampleInputEmail1" type="nombre" name="nombreusuarios">
				</div>
				<div class="form-group">
					 <label for="exampleInputEmail1">Direccion de correo electronico</label><input  class="form-control"  id="exampleInputEmail1" type="email" name="emailusuarios">
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Contrasenia</label><input  class="form-control" id="exampleInputPassword1" type="password" name="contraseniausuarios">
				</div>
				
				
				
				</div> 
				<input type="submit" value="Registrar" class="boton" >
				
				
			
				<div class="form-group">
					 
					
				</div>
				<div class="checkbox">					 
			</form>
			
				<center><br><br><h2>Deseas regresar al menu</h2><form action="index.jsp">
				<input type="submit" value="Menu"></form></center> 
		</div>
	</div>
</div>
</body>
</html>