package com.scrumexp.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Project;
import com.scrumexp.objects.Usuario;
import com.scrumexp.objectsStore.ProjectStore;

import login.UsuarioUtils;

@SuppressWarnings("serial")
public class ProjectManagerServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String projectTitle = req.getParameter("project-title");
		Usuario usuario = (Usuario) session.getAttribute("user");
		if (ProjectStore.ProjectExists(projectTitle, usuario)) {
			Project currentProject = ProjectStore.getProjectByTitle(projectTitle, usuario);
			session.setAttribute("project", currentProject);
			resp.sendRedirect("/main.jsp");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/main.jsp");
			
		} else {
			System.out.println("NO ENCONTRE EL PROYECTO CON ESE USUARIO");
			resp.sendRedirect("/master"); //maybe someone tried to tamper and edit some data
		}
		
		
	}

}
