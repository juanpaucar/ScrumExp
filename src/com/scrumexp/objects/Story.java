package com.scrumexp.objects;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Story {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String title;
	
	@Persistent
	private String description;
	
	@Persistent
	private int estimatedValue;
	
	@Persistent
	private int estimatedWork;
	
	@Persistent
	private Sprint sprint;

	@Persistent
	private ProductBacklog productBacklog;

	public Story(String title, String description, int estimatedValue,
			int estimatedWork, Sprint sprint, ProductBacklog productBacklog) {
		super();
		this.title = title;
		this.description = description;
		this.estimatedValue = estimatedValue;
		this.estimatedWork = estimatedWork;
		this.sprint = sprint;
		this.productBacklog = productBacklog;
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
	
}
