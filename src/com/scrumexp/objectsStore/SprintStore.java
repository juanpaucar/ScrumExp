package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.Project;
import com.scrumexp.objects.Sprint;

public class SprintStore {
	
	public void insertSprint(Sprint sprint) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Sprint finalSprint = sprint;
		persistenceManager.makePersistent(finalSprint);
	}
	
	public List<Sprint> getEntries(Project project) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Sprint.class);
		query.setFilter("project == projectParam");
		query.setOrdering("startDate ASC");
		query.declareParameters("Project projectParam");
		return (List<Sprint>)query.execute();
	}

}
