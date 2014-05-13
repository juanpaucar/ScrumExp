package com.scrumexp.objectsStore;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.scrumexp.objects.ProductBacklog;
import com.scrumexp.objects.Project;
import com.scrumexp.objects.Task;

public class ProductBacklogStore {
	
	public void insertProductBacklog(ProductBacklog productBacklog) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final ProductBacklog finalProductBacklog = productBacklog;
		persistenceManager.makePersistent(finalProductBacklog);
	}
	
	public List<ProductBacklog> getProductBacklog(Project project) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		final Query query = persistenceManager.newQuery(ProductBacklog.class);
		query.setFilter("project == projectParam");
		query.declareParameters("Project projectParam");
		return (List<ProductBacklog>)query.execute(project);
	}

}
