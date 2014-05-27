package com.scrumexp.objects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario implements Serializable {

	private static final long serialVersionUID = -1659580741127109109L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String nombreusuarios;
	
	@Persistent
	private String emailusuarios;
	
	@Persistent
	private String contraseniausuarios;
	
	@Persistent
	private Set<Key> projects;
	
	public Usuario(){
		super();
		
	}
	public Usuario(String nombreusuarios, final String emailusuarios, final String contraseniausurios){
		this.nombreusuarios=nombreusuarios;
		this.emailusuarios=emailusuarios;
		this.contraseniausuarios=contraseniausurios;	
		this.projects =  new HashSet<Key>();
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getNombreusuarios() {
		return nombreusuarios;
	}
	public void setNombreusuarios(String nombreusuarios) {
		this.nombreusuarios = nombreusuarios;
	}
	public String getEmailusuarios() {
		return emailusuarios;
	}
	public void setEmailusuarios(String emailusuarios) {
		this.emailusuarios = emailusuarios;
	}
	public String getContraseniausuarios() {
		return contraseniausuarios;
	}
	public void setContraseniausuarios(String contraseniausuarios) {
		this.contraseniausuarios = contraseniausuarios;
	}
	public Set<Key> getProjects() {
		return projects;
	}
	public void setProjects(Set<Key> projects) {
		this.projects = projects;
	}
	public Key getKey() {
		return this.key;
	}

	public void addProject(Project project) {
		if (this.projects == null)
			this.projects = new HashSet<Key>();
		projects.add(project.getKey());
		//project.getUsers().add(getKey());
	}

	public void removeProject(Project project) {
		projects.remove(project.getKey());
		project.getUsers().remove(getKey());
	}
	

}
