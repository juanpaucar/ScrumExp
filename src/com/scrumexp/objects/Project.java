package com.scrumexp.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Project implements Serializable {

	private static final long serialVersionUID = 2345459281181991891L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String title;

	@Persistent
	private String description;
	
	@Persistent
	private Set<Key> users;
	
	@Persistent
	private Date creationDate;

	@Persistent(mappedBy="project")
	private List<Sprint> sprints;
	
	@Persistent (defaultFetchGroup="true")
	private ProductBacklog productBacklog;

	public Project(String title, String description,List<Sprint> sprints, ProductBacklog productBacklog, Usuario usuario) {
		super();
		this.title = title;
		this.description = description;
		this.sprints = sprints;
		this.productBacklog = productBacklog;
		this.creationDate = new Date();
		this.users = new HashSet<Key>();
		this.addUser(usuario);
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

	public Set<Key> getUsers() {
		return users;
	}

	public void setUsers(Set<Key> users) {
		this.users = users;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public Key getKey() {
		return key;
	}
	
	public void addUser(Usuario usuario) {
		users.add(usuario.getKey());

	}

	public void removeUser(Usuario usuario) {
		users.remove(usuario.getKey());
		usuario.getProjects().remove(getKey());
	}
	
	public List<Story> getUserStories() {
		if (this.sprints!=null) {
			List<Story> stories = new ArrayList<Story>();
			for (Sprint sprint : this.sprints){
				for (Story story: sprint.getUserStories()) {
					stories.add(story);
				}
			}
			return stories;
		}
		return new ArrayList<Story>();
	}

}
