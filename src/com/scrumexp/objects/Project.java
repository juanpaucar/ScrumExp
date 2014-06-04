package com.scrumexp.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.appengine.api.datastore.Key;
import com.scrumexp.objectsStore.SprintStore;

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

	private Set<Key> sprints;
	
	@Persistent (defaultFetchGroup="true")
	private ProductBacklog productBacklog;

	public Project(String title, String description,Set<Key> sprints, ProductBacklog productBacklog, Usuario usuario) {
		super();
		this.title = title;
		this.description = description;
		this.sprints = new HashSet<Key>();
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
	
	public void addSprint(Sprint sprint) throws NullPointerException {
		if (this.sprints==null)
			this.sprints = new HashSet<Key>();
		System.out.println("HOLAAAAAAAAA:  "+sprint);
		this.sprints.add(sprint.getKey());
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

	public Set<Key> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Key> sprints) {
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
		if (this.sprints!=null && this.sprints.size()>0) {
			List<Story> stories = new ArrayList<Story>();
			Sprint sprint;
			System.out.println("Project.java linea 128");
			for (Key sprintKey : this.sprints){
				System.out.println("Project.java linea 130");
				sprint = SprintStore.getSprintByKey(sprintKey);
				System.out.println("Project.java linea 132");
				if (sprint!=null) {
					System.out.println("Project.java linea 134");
					System.out.println("SPrint "+sprint.getKey());
					System.out.println("DEbio ser otro");
					if (sprint.getUserStories()!=null && sprint.getUserStories().size()>0) { 
						for (Story story: sprint.getUserStories()) {
							System.out.println("Project.java linea 136");
							stories.add(story);
							System.out.println("Project.java linea 138");
						}
					}
					System.out.println("Project.java linea 140");
				}
				System.out.println("Project.java linea 142");
			}
			System.out.println("Project.java linea 144");
			return stories;
		}
		return new ArrayList<Story>();
	}

}
