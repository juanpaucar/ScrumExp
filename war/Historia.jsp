<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="historiasUsuario.Historia"%>
<%@page import="historiasUsuario.HistoriaUtils" %>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<font color="black" size=5 >
<center>
<h3 class="text-center">
	REGISTRO DE HISTORIAS DE USUARIO
</h3>
</center>
</font>

<head>
<meta charset="utf-8">
<title>Creacion de Historias de Usuario</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<style>
body { font-size: 62.5%; }
label, input { display:block; }
input.text { margin-bottom:12px; width:95%; padding: .4em; }
fieldset { padding:0; border:0; margin-top:25px; }
h1 { font-size: 1.2em; margin: .6em 0; }
div#users-contain { width: 350px; margin: 20px 0; }
div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
.ui-dialog .ui-state-error { padding: .3em; }
.validateTips { border: 1px solid transparent; padding: 0.3em; }
</style>
<script>
$(function() {
var name = $( "#name" ),
email = $( "#email" ),
password = $( "#password" ),
allFields = $( [] ).add( name ).add( email ).add( password ),
tips = $( ".validateTips" );
function updateTips( t ) {
tips
.text( t )
.addClass( "ui-state-highlight" );
setTimeout(function() {
tips.removeClass( "ui-state-highlight", 1500 );
}, 500 );
}
function checkLength( o, n, min, max ) {
if ( o.val().length > max || o.val().length < min ) {
o.addClass( "ui-state-error" );
updateTips( "Length of " + n + " must be between " +
min + " and " + max + "." );
return false;
} else {
return true;
}
}
function checkRegexp( o, regexp, n ) {
if ( !( regexp.test( o.val() ) ) ) {
o.addClass( "ui-state-error" );
updateTips( n );
return false;
} else {
return true;
}
}
$( "#dialog-form" ).dialog({
autoOpen: false,
height: 300,
width: 350,
modal: true,
buttons: {

Cancel: function() {
$( this ).dialog( "close" );
}
},
close: function() {
allFields.val( "" ).removeClass( "ui-state-error" );
}
});
$( "#create-user" )
.button()
.click(function() {
$( "#dialog-form" ).dialog( "open" );


});
});
</script>
</head>

<center>
<body background="/img/fondo.jpg">
<div id="dialog-form" title="Crear una nueva Historia de Usuario">
<p class="validateTips">Todos los campos deben ser llenados</p>

<form  action="/Historia" method="post">
		
		<div class="form-group">
		<label for="nombreHistoria">Nombre de la Historia de Usuario</label><input  class="form-control" id="exampleInputEmail1" type="nombre" name="nombreHistoria">
		</div>
		
		<div class="form-group">
		<label for="nombreHistoria">Descripcion de la Historia de Usuario:</label><textarea name="descripcionHistoria" rows="8" cols="20"></textarea>
		</div>
		
		<div class="form-group">
		<label for="nombreHistoria">Prioridad de la Historia de Usuario:</label><input  class="form-control" id="exampleInputEmail1" type="nombre" name="prioridadHistoria">
		</div>
		
		<div class="form-group">
		<label for="nombreHistoria">Estimacion de la Historia de Usuario:</label><input  class="form-control" id="exampleInputEmail1" type="nombre" name="estimacionHistoria">
		</div>
		
		<div class="form-group">
		<label for="nombreHistoria">N�mero de Sprint Historia de Usuario:</label>
		<BR><SELECT NAME="esfuerzoHistoria">
			<OPTION>Sprint 1
			<OPTION>Sprint 2
			<OPTION>Sprint 3
			<OPTION>Sprint 4
			<OPTION>Sprint 5
			<OPTION>Sprint 6
			<OPTION>Sprint 7
			<OPTION>Sprint 8
			<OPTION>Sprint 9
			<OPTION>Sprint 10
		</SELECT > 
		</div>

	
	<center>
	<input type="submit" id="Guardar" value="Guardar">
	</center>
		
</form>

</div>

<div id="users-contain" class="ui-widget">
<table id="users" class="ui-widget ui-widget-content">

<thead>
<tr class="ui-widget-header ">

  	<td><font color="red"><b>Nombre de la Historia</b></font></td>
	<td><font color="red"><b>Descripcion de la Historia</b></font></td>
	<td><font color="red"><b>Prioridad de la Historia</b></font></td>
	<td><font color="red"><b>Estimacion de la Historia</b></font></td>
	<td><font color="red"><b>Numero de Sprint de la Historia</b></font></td>

</tr>
</thead>

<tbody>
<tr>

				<%
					List<Historia> aux = HistoriaUtils.todaslasHistoria();
					for (Historia historia : aux) {
				%>
				<tr>
				<td ><a href="/Tareas.jsp"><%=historia.getNombreHistoria()%></a><br></td>
				<td><%=historia.getDescripcionHistoria()%><br></td>
				<td><%=historia.getPrioridadHistoria()%><br></td>
				<td><%=historia.getEstimacionHistoria()%><br></td>
				<td><%=historia.getEsfuerzoHistoria()%><br></td>
				</tr>
				<%
						}
				%>
				
				
				

</tr>
</tbody>
</table>
</div>

<button id="create-user">Crear una nueva Historia de Usuario</button><br>
</body>
</center>

<center><br><br><h2>Actualizar Historias de Usuario</h2>
<form action="Actualizar.jsp"><input type="submit" value="Ir"></form>
</center> 

	
<br></br> 
<br></br>

<center>
<a href="Actualizar.jsp" >Regresar al login</a>
</center>

</html>