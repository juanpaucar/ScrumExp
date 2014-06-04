package com.scrumexp.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scrumexp.objects.Project;
import com.scrumexp.objects.Sprint;
import com.scrumexp.objects.Usuario;
import com.scrumexp.objectsStore.ProjectStore;
import com.scrumexp.objectsStore.SprintStore;

@SuppressWarnings("serial")
public class NewSprintServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		Project project = (Project) session.getAttribute("project");
		String startdate =  req.getParameter("new-sprint-start-date");
		String enddate = req.getParameter("new-sprint-end-date");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = null, endDate = null;
		try {
			startDate = formatter.parse(startdate);
			endDate = formatter.parse(enddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (project!=null) {
			List<Sprint> sprints = SprintStore.getSprints(project);
			Sprint newSprint;
			if (sprints!=null && sprints.size()>0) {
				String lastSprintName = sprints.get(sprints.size()-1).getName();
				int lastSprint = Integer.parseInt(lastSprintName.substring(lastSprintName.lastIndexOf(" ")+1));
				newSprint = new Sprint(lastSprint, startDate, endDate, project.getKey(), null);
			}
			else {
				newSprint = new Sprint(1, startDate, endDate, project.getKey(), null);
			}
			
			SprintStore.insertSprint(newSprint);
			System.out.println("la key del nuevo sprint es: "+newSprint.getKey());
			project.addSprint(newSprint);

			System.out.println("sprints de project: "+project.getSprints()==null?0:project.getSprints().size());
			session.setAttribute("project", project);
			resp.sendRedirect("/main.jsp");
		}
		else {
			//req.getSession().invalidate();
			resp.sendRedirect("/index.jsp");
		}
	}
	
}