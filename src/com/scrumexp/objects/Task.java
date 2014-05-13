package com.scrumexp.objects;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Task {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@Persistent
	private List<String> owners;
	
	@Persistent
	private int estimatedHours;
	
	@Persistent
	private double completed;
	
	@Persistent
	private Story story;

	public Task(String name, String description, List<String> owners,
			int estimatedHours, Story story) {
		super();
		this.name = name;
		this.description = description;
		this.owners = owners;
		this.estimatedHours = estimatedHours;
		this.story = story;
		this.completed=0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getOwners() {
		return owners;
	}

	public void setOwners(List<String> owners) {
		this.owners = owners;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public double getCompleted() {
		return completed;
	}

	public void setCompleted(double completed) {
		this.completed = completed;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}
	
}
