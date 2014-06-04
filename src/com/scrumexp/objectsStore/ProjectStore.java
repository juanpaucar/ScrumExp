package com.scrumexp.objectsStore;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.Project;
import com.scrumexp.objects.Usuario;
import com.google.appengine.api.datastore.Key;

public class ProjectStore {
	
	public static Project insertProject(Project project) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Project finalProject = project;
		return persistenceManager.makePersistent(finalProject);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Project> getEntries(Usuario usuario) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Project.class);
		try {
			List<Project> projects = (List<Project>) query.execute();;
			Key userKey=usuario.getKey();
			if (projects!=null && projects.size()>0) {
				List<Project> userProjects = new ArrayList<Project>();
				for (Project project : projects) {
					for (Key key : project.getUsers()) {
						if (key.equals(userKey)) {
							userProjects.add(project);
							break;
						}
					}
				}
				return userProjects;			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			persistenceManager.close();
		}
		return new ArrayList<Project>(); //actually would be an empty list
	}
	
	@SuppressWarnings("uncheked")
	public static Project getProject(Key projectKey) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Project.class);
		query.setFilter("key == keyParam");
		query.declareParameters(Key.class.getName() + " keyParam");
		try {
			List<Project> projects = (List<Project>) query.execute(projectKey);
			if (projects!= null && projects.size()>=1)
				return projects.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			persistenceManager.close();
		}
 		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean ProjectExists(String title, Usuario usuario) {
		List<Project> projects = getEntries(usuario);
		for (Project project : projects) 
			if (project.getTitle().equals(title))
				return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static Project getProjectByTitle(String title, Usuario usuario) {
		List<Project> projects = getEntries(usuario);
		if (projects!=null && projects.size()>0) {
			for (Project project : projects) {
				if (project.getTitle().equals(title)) {
					return project;
				}
			}
		}
		return null;
	}



}
