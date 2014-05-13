package login;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.scrumexp.objects.Project;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String nombreusuarios;
	
	@Persistent
	private String emailusuarios;
	
	@Persistent
	private String contraseniausuarios;
	
	@Persistent
	private List<Project> projects;
	
	public Usuario(){
		super();
		
	}
	public Usuario(String nombreusuarios, final String emailusuarios, final String contraseniausurios){
		this.nombreusuarios=nombreusuarios;
		this.emailusuarios=emailusuarios;
		this.contraseniausuarios=contraseniausurios;			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
