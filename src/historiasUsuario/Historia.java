package historiasUsuario;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.List;

import tareas.Tareas;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Historia {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String nombreHistoria;
	@Persistent
	private String descripcionHistoria;
	@Persistent
	private String prioridadHistoria;
	@Persistent
	private String estimacionHistoria;
	@Persistent
	private String esfuerzoHistoria;
		
	public Historia(){
		super();		
	}
	
	public Historia(String nombreHistoria, String descripcionHistoria, String prioridadHistoria, String estimacionHistoria, String esfuerzoHistoria){
		this.nombreHistoria=nombreHistoria;
		this.descripcionHistoria=descripcionHistoria;
		this.prioridadHistoria=prioridadHistoria;
		this.estimacionHistoria=estimacionHistoria;
		this.esfuerzoHistoria=esfuerzoHistoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreHistoria() {
		return nombreHistoria;
	}
	public void setNombreHistoria(String nombreHistoria) {
		this.nombreHistoria = nombreHistoria;
	}
	public String getDescripcionHistoria() {
		return descripcionHistoria;
	}
	public void setDescripcionHistoria(String descripcionHistoria) {
		this.descripcionHistoria = descripcionHistoria;
	}
	public String getPrioridadHistoria() {
		return prioridadHistoria;
	}
	public void setPrioridadHistoria(String prioridadHistoria) {
		this.prioridadHistoria = prioridadHistoria;
	}
	public String getEstimacionHistoria() {
		return estimacionHistoria;
	}
	public void setEstimacionHistoria(String estimacionHistoria) {
		this.estimacionHistoria = estimacionHistoria;
	}
	public String getEsfuerzoHistoria() {
		return esfuerzoHistoria;
	}
	public void setEsfuerzoHistoria(String esfuerzoHistoria) {
		this.esfuerzoHistoria = esfuerzoHistoria;
	}
	
	
	
	
}
