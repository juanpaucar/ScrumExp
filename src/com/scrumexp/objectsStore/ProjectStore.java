package com.scrumexp.objectsStore;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import login.Usuario;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.Project;;

public class ProjectStore {
	
	public void insertProject(String title, String description, String userEmail, Usuario usuario) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Project project = new Project(title, description, userEmail, usuario);
		persistenceManager.makePersistent(project);
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getEntries(Usuario usuario) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Project.class);
		final String email=usuario.getEmailusuarios();
		List<Project> projects = (List<Project>)query.execute();
		List<Project> projectsByUser = new ArrayList<Project>();
 		for (Project project : projects) {
			List<String> memebers = project.getMembers();
			for (String member : memebers) {
				if (member.equals(email)) {
					projectsByUser.add(project);
					break;
				}
			}
		}
 		return projectsByUser;
	}
	
	

	
}
