<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="historiasUsuario.Historia"%>
<%@page import="historiasUsuario.HistoriaUtils" %>
<%@page import="historiasUsuario.Actualizar"%>
<%@page import="java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<body background="/img/fondo.jpg">
<font color="black" size=5 >
<center>
<h3 class="text-center">
	ACTUALIZACION DE LAS HISTORIAS DE USUARIO
</h3>
</center>
</font>

<center>
<table id="users" class="ui-widget ui-widget-content">

<tbody>
<tr>
				<%
					List<Historia> aux1 = HistoriaUtils.todaslasHistoria();
					for (Historia historia : aux1) {
				%>
				
				
				<table>
				<form action="/Actualizar" method ="post">
				<tr>
				<td><strong>Nombre de la Historia de Usuario:</strong></td>
				<td><input value="<%= historia.getNombreHistoria()%>" name="nombreHistoria"/></td>
				</tr>
				<tr>
				<td><strong>nueva descripcion:</strong></td>
				<td><input type="text" name="ndescripcion" value="<%= historia.getDescripcionHistoria()%>"/></td>
				</tr>
				<tr>
				<td><strong>nueva prioridad:</strong></td>
				<td><input type="text" name="nprioridad" value="<%= historia.getPrioridadHistoria()%>"/></td>
				</tr>
				<tr>
				<td><strong>nueva estimacion:</strong></td>
				<td><input type="text" name="nestimacion" value="<%= historia.getEstimacionHistoria()%>"/></td>
				</tr>
				<tr>
				<td><strong>nueva Sprint:</strong></td>
				<td><select class="form-control" id="edit-story-sprint" name="nesfuerzo">
											  <option>Sprint 0 (planeacion)</option>
											  <option>Sprint 1</option>
											  <option>Sprint 2</option>
											  <option>Sprint 3</option>
											</select></td>
				</tr>
				<tr>
				<input type="submit">
				</tr>
				</form>
				</table>
				
				
				
				<%
						}
				%>
</tr>


<center><br><br><h2>Regresar al Menu</h2>
<form action="Historia.jsp"><input type="submit" value="Ir"></form>
</center> 

</tbody>
</table>

</body>
</html>		

