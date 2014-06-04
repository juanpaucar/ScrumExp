package com.scrumexp.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Sprint implements Serializable {
	
	private static final long serialVersionUID = -4066150790413681556L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String name;
	
	@Persistent
	private Date startDate;
	
	@Persistent
	private Date endDate;
	
	@Persistent
	private Key project;
	
	@Persistent(mappedBy="sprint")
	private List<Story> userStories;

	public Sprint(int number, Date startDate, Date endDate, Key project,
			List<Story> userStories) {
		super();
		this.name = "Sprint "+number;
		this.startDate = startDate;
		this.endDate = endDate;
		this.project = project;
		this.userStories = new ArrayList<Story>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Key getProject() {
		return project;
	}

	public void setProject(Key project) {
		this.project = project;
	}

	public List<Story> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<Story> userStories) {
		this.userStories = userStories;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
}
