<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    
<%@page import="login.*"%>
<%@page import="java.util.*"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<!--append â#!watchâ to the browser URL, then refresh the page. -->
	
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

<body style="background-color: #eee">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-3 column">
			<img alt="" src="/img/ScrumeXpLOGO.png"  ></img>
		</div>
		<div class="col-md-9 column">
				<div class="jumbotron" style="background-color: #eee">
					<p>
						<h1 >
							<strong>ScrumeXp</strong>
						</h1>
					</p>
					<p>
						<small>Software para desarrollo y seguimiento con metodologias agiles Scrum y XP.</small>
					</p>
				</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-8 column">
			<div class="panel panel-primary">
					<div class="carousel slide" id="carousel-540220">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0" data-target="#carousel-540220">
							</li>
							<li data-slide-to="1" data-target="#carousel-540220">
							</li>
							<li data-slide-to="2" data-target="#carousel-540220">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="/img/3.png"  ></img>
								<div class="carousel-caption">
									<h4>
										
									</h4>
									<p>
										.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="/img/2.png"  ></img>
								<div class="carousel-caption">
									<h4>
							
									</h4>
									<p>
										
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="/img/1.png"  ></img>
								<div class="carousel-caption">
									<h4>
										
									</h4>
									<p>
										
									</p>
								</div>
							</div>
						</div> <a class="left carousel-control" href="#carousel-540220" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-540220" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
			</div>		
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="panel-title">
						<h4>Descripción</h4>
					</div>
				</div>
				<div class="panel-body" style="background-color: #eee">	
					<p>
						Software desarrollado para la materia de Ingenieria de Software 2, de la Facultad de Ingenieria de Sistemas de la Escuela Polit&eacute;cnica Nacional. Para mantener el control de un proyecto con las metodolog&iacute;as &aacute;giles Scrum y XP.
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 column">
			<div class="panel panel-primary">
				
					<div class="panel-heading">
						<div class="panel-title">
							Usuarios registrados
						</div>
					</div>
					
					<div class="panel-body" style="background-color: #eee">
				
					<form action="/master" class="form-horizontal" role="form" method="post">
					
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-3 control-label">Email</label>
							<div class="col-sm-9">
								<input type="email" class="form-control" id="inputEmail3" name="emailusuario">
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-3 control-label">Contrase&ntilde;a</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="inputPassword3" name="contraseniausuario">
							</div>
						
						
						</div>
						<div><button  type="submit" class="btn btn-info pull-right" style="postion: center">Ingresar</button></div>
						
						</form>		
					</div>
				</div>		
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-title">
							Usuarios no registrados
						</div>
					</div>
					<div class="panel-body" style="background-color: #eee">
						<p>
							¿Por qué no crear una cuenta?<br><br>
							<a class="btn btn-info btn-block" href="Usuarios.jsp" >Registrar</a>
						</p>
							<p>
							<a class="btn btn-info btn-block" href="ListarUsuarios.jsp">Listar</a>								
							</p>
					</div>	
				</div>

			
				
	</div>
	
</div>
<div class="col-md-12 column">
	<ul class="breadcrumb">
				<li>
					<a href="https://twitter.com/JuxnCxrlosP">Acerca de</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="https://github.com/juanpaucar/ScrumExp">Proyecto en GitHub</a> <span class="divider">/</span>
				</li>
				<li class="active">
					Desarrollado bajo licencia GPLv2
				</li>
			</ul>
</div>
</body>
</html>