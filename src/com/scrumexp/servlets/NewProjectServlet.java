package com.scrumexp.servlets;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.scrumexp.objects.Project;
import com.scrumexp.objects.Usuario;
import com.scrumexp.objectsStore.ProjectStore;


@SuppressWarnings("serial")
public class NewProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String projectTitle = req.getParameter("project-title");
		String projectDescription =  req.getParameter("description");

		if (projectTitle!=null && projectDescription!=null && 
				!projectTitle.equals("") && !projectDescription.equals("")) {
			
			Usuario usuario = (Usuario) req.getSession().getAttribute("user");
			if (usuario==null)
				System.out.println("el usuario es nulo XS");
			if (!ProjectStore.ProjectExists(projectTitle, usuario)) {
				Project project = new Project(projectTitle, projectDescription, null, null, usuario);
				Project storedProject = ProjectStore.insertProject(project);
				usuario.addProject(storedProject); //not necesary because it's already being done on the Project class but once deployed it won't work that way
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/projects.jsp");
			//rd.forward(req, resp);
				//TO DO
				//MOSTRAR UN ERROR NOMBRE REPETIDO
			}
			resp.sendRedirect("/projects.jsp");
		}
		else {
			resp.sendRedirect("/projects.jsp");
			System.out.println("NO hubo historias de usuario");
		}
	}
	
}