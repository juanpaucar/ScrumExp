package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Project;
import com.scrumexp.objects.Sprint;

public class SprintStore {
	
	public static Sprint insertSprint(Sprint sprint) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		if (sprint.getProject()!=null)
			System.out.println("SI LE MANDE");
		else
			System.out.println("WEY NO LLEGO =C");
		try {
			persistenceManager.makePersistent(sprint);
			System.out.println("PASO LO FEO D=");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return null;
	}
	

	public static Sprint getSprintByKey(Key key) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Sprint.class);
		query.setFilter("key == keyParam");
		query.declareParameters(Key.class.getName() + " keyParam");
		try {
			List<Sprint>  sprints= (List<Sprint>) query.execute(key);
			if (sprints!= null && sprints.size()>=1)
				return sprints.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return null;
	}
	
	public static List<Sprint> getSprints(Project project) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Sprint.class);
		Key projectKey= project.getKey();
		query.setFilter("key == keyParam");
		query.declareParameters(Key.class.getName() + " keyParam");
		return (List<Sprint>) query.execute(projectKey);
	
	}
}
