package com.scrumexp.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import login.Usuario;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Project {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Key
	private Key key;
	
	@Persistent
	private String title;
	
	@Persistent
	private String description;
	
	@Persistent
	private List<String> members;
	
	@Persistent
	private Usuario creator;
	
	@Persistent
	private Date creationDate;

	@Persistent
	private List<Sprint> sprints;
	
	@Persistent
	private ProductBacklog productBacklog;



	public Project(String title, String description, String member, Usuario creator) {
		super();
		this.title = title;
		this.description = description;
		this.members =  new ArrayList<String>();
		this.members.add(member);
		this.creator = creator;
		this.creationDate = new Date();
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

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}
	
	
}
