<%@page import="proyecto.*" %>
<%@page import="java.util.*"%>
<%@page import="proyecto.TutorialUtil"%>

<%
List<Tutorial> tutorials =TutorialUtil.todosLosTutoriales();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de inicio</title>
<link href="css/redmond/jquery-ui-1.10.4.custom.css" rel="stylesheet">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.js"></script>
<script>
$( "#Guardar" ).button();
$(function () {
	$("#dialog").dialog({
	autoOpen: false,
	modal: true,
	buttons: {
	
	"Cerrar": function () {
	$(this).dialog("close");
	}
	}
	});
	$("#abrir")
	.button()
	.click(function () {
	
	$("#dialog").dialog("option", "resizable", false);
	$("#dialog").dialog("open");
	});
	});

$(function() {
	$( "input[type=submit], a, button" )

	});
</script>

<script>
	$(function() {
		$("#tabla").menu();
	});
</script>

<style>
.ui-menu {
	width: 650px;
}
</style>

<script>
	  $(function() {
		    $( "#tabla" ).menu();
		  });
	</script>
	
	<style>
  .ui-menu { width: 200px; }
  </style>
</head>

<body>
<form id="dialog" background="/img/fondo.jpg" title="Nuevo Proyecto" action="/tutorial" method="get">
	<div>
		NOMBRE DEL PROYECTO:<input type="text" size="25" maxlength="30"
			id="autor" name="autor" /><br /> DESCRIPCION:<br>
		<textarea name="tutorial" rows="8" cols="20"></textarea>
	</div>
	<input type="hidden" name="action" value="create"/>
	<input type="submit" id="Guardar" value="Guardar">
</form>
	<h1 align="left">
		<font size=6 color=#23238E><b>SCRUMEXP</b></font>
	</h1>
	<hr />
	<button id="abrir">Nuevo Proyecto</button>
	<br></br>

	<span>
  </span>
  <table id= "tabla">
   <thead>
    <tr>
     <th><h2 align="center">PROYECTOS</h2></th>
    </tr>
   </thead>
   <tbody>
<%
 for (int idx = 0; idx < tutorials.size(); idx++) {
     Tutorial t = (Tutorial)tutorials.get(idx);
%>
    <tr>
     <td><%= t.getAutor() %></td>
    </tr>

<%}%>
   </tbody>
  </table>
<br></br>  
<br></br>
<hr>
<center>
<a href="http://1-dot-scrum-exp.appspot.com/" >Regresar al loggin</a>
</center>
</body>
</html>