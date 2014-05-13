package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.ProductBacklog;
import com.scrumexp.objects.Sprint;
import com.scrumexp.objects.Story;

public class StoryStore {
	
	public void insertStory(Story story) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Story finalStory = story;
		persistenceManager.makePersistent(finalStory);
	}
	
	public List<Story> getEntriesBySprint(Sprint sprint) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Story.class);
		query.setFilter("sprint == sprintParam");
		query.declareParameters("Sprint sprintParam");
		return (List<Story>)query.execute(sprint);
	}
	
	public List<Story> getEntriesByProductBacklog(ProductBacklog productBacklog) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(Story.class);
		query.setFilter("productBacklog == productBacklogParam");
		query.declareParameters("ProductBacklog productBacklogParam");
		return (List<Story>)query.execute(productBacklog);
	}
 
}
