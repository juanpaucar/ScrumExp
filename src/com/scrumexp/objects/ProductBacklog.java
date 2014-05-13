package com.scrumexp.objects;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ProductBacklog {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Key
	private Key key;
	
	@Persistent(mappedBy = "productBacklog")
	private Project project;
	
	@Persistent
	private List<Story> userStories;

	public ProductBacklog(Project project, List<Story> userStories) {
		super();
		this.project = project;
		this.userStories = userStories;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Story> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<Story> userStories) {
		this.userStories = userStories;
	}
	
}
