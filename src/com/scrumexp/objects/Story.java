package com.scrumexp.objects;


import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Story {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String title;
	
	@Persistent
	private String description;
	
	@Persistent
	private String acceptanceCriteria;
	
	@Persistent
	private boolean accomplished;
	
	@Persistent
	private int estimatedValue;
	
	@Persistent
	private int estimatedWork;
	
	@Persistent
	private Sprint sprint;

	@Persistent
	private ProductBacklog productBacklog;
	
	@Persistent(mappedBy="story")
	private List<Task> tasks;

	public Story(String title, String description, int estimatedValue,
			int estimatedWork, Sprint sprint, ProductBacklog productBacklog, String acceptanceCriteria) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedValue = estimatedValue;
		this.estimatedWork = estimatedWork;
		this.sprint = sprint;
		this.productBacklog = productBacklog;
		this.acceptanceCriteria = acceptanceCriteria;
		this.accomplished=false;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(int estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public int getEstimatedWork() {
		return estimatedWork;
	}

	public void setEstimatedWork(int estimatedWork) {
		this.estimatedWork = estimatedWork;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	public Key getId() {
		return this.key;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public boolean isAccomplished() {
		return accomplished;
	}

	public void setAccomplished(boolean accomplished) {
		this.accomplished = accomplished;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
