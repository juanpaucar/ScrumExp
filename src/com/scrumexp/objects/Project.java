package com.scrumexp.objects;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import login.Usuario;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Project {

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

	@Persistent
	private List<Sprint> sprints;
	
	@Persistent (defaultFetchGroup="true")
	private ProductBacklog productBacklog;

	public Project(String title, String description,List<Sprint> sprints, ProductBacklog productBacklog) {
		super();
		this.title = title;
		this.description = description;
		this.sprints = sprints;
		this.productBacklog = productBacklog;
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
		System.out.println("ENTRE");
		users.add(usuario.getKey());
		System.out.println("2DA LINEA");
		usuario.getProjects().add(getKey());
		System.out.println("ACABE");
	}

	public void removeUser(Usuario usuario) {
		users.remove(usuario.getKey());
		usuario.getProjects().remove(getKey());
	}

}
