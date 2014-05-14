package com.scrumexp.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Project;
import com.scrumexp.objectsStore.ProjectStore;

import login.Usuario;
import login.UsuarioUtils;

@SuppressWarnings("serial")
public class NewProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String projectTitle = req.getParameter("project-title");
		String projectDescription =  req.getParameter("description");
		String projectAutor =  req.getParameter("Autor");
		
		if (projectTitle!=null && projectDescription!=null && 
				!projectTitle.equals("") && !projectDescription.equals("")) {
			
			Usuario usuario = UsuarioUtils.geUsuario("juan@mail.com");//we could retrieve projectAutor
			
			Project project = new Project(projectTitle, projectDescription, null, null);
			ProjectStore.insertProject(project);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/projects.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.sendRedirect("/projects.jsp");
			System.out.println("NO hubo historias de usuario");
		}
	}
	
}