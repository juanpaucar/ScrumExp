package tareas;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import historiasUsuario.Historia;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tareas {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String nombreTarea;
	@Persistent
	private String descripcionTarea;
	@Persistent
	private String tareaRealizada;
	@Persistent
	private String valorTarea;
	@Persistent
	private String trabajoTarea;
	@Persistent
	private String nombreHistoria;
	
	

	public Tareas(){
		super();		
	}
	
	public Tareas(String nombreTarea, String descripcionTarea, String tareaRealizada, String valorTarea, String trabajoTarea){
		this.nombreTarea=nombreTarea;
		this.descripcionTarea=descripcionTarea;
		this.tareaRealizada=tareaRealizada;
		this.valorTarea=valorTarea;
		this.trabajoTarea=trabajoTarea;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public String getDescripcionTarea() {
		return descripcionTarea;
	}

	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}

	public String getTareaRealizada() {
		return tareaRealizada;
	}

	public void setTareaRealizada(String tareaRealizada) {
		this.tareaRealizada = tareaRealizada;
	}

	public String getValorTarea() {
		return valorTarea;
	}

	public void setValorTarea(String valorTarea) {
		this.valorTarea = valorTarea;
	}

	public String getTrabajoTarea() {
		return trabajoTarea;
	}

	public void setTrabajoTarea(String trabajoTarea) {
		this.trabajoTarea = trabajoTarea;
	}
	
	

	

}
