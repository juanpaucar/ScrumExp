package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.Story;
import com.scrumexp.objects.Task;

public class TaskStore {

	public void insertTask(Task task) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Task finalTask= task;
		persistenceManager.makePersistent(finalTask);
	}
	
	public List<Task> getEntries(Story story) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Task.class);
		query.setFilter("story == storyParam");
		query.declareParameters("Story storyParam");
		return (List<Task>)query.execute(story);
	}
	
}
