package login;

import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Project;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario {

	
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
	public Usuario(String nombreusuarios, final String emailusuarios, final String contraseniausurios, final Key key){
		this.nombreusuarios=nombreusuarios;
		this.emailusuarios=emailusuarios;
		this.contraseniausuarios=contraseniausurios;	
		this.setKey(key);
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
		return key;
	}

	public void addProject(Project project) {
		projects.add(project.getKey());
		project.getUsers().add(getKey());
	}

	public void removeProject(Project project) {
		projects.remove(project.getKey());
		project.getUsers().remove(getKey());
	}
	

}
