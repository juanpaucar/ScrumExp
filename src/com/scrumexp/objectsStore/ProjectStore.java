package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import login.Usuario;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.Project;
import com.google.appengine.api.datastore.Key;

public class ProjectStore {
	
	public static void insertProject(Project project) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Project finalProject = project;
		persistenceManager.makePersistent(finalProject);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Project> getEntries(Usuario usuario) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Project.class);
		/*query.setFilter("projects == projectsParam");
		query.declareParameters("Set<Key> projectsParam");*/
		List<Project> projects = (List<Project>) query.execute();
		return projects;
	}
	
	@SuppressWarnings("uncheked")
	public static Project getProject(Key projectKey) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Project.class);
		query.setFilter("key == keyParam");
		query.declareParameters(Key.class.getName() + " keyParam");
		List<Project> projects = (List<Project>) query.execute(projectKey);
		if (projects.size()>=1)
			return projects.get(0);
		return null;
	}
	
	

	
}
