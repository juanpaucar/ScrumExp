package tareas;

import historiasUsuario.PMF;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
public class TareasUtils {
	
	private static final int FETCH_MAX_RESULTS = 10;
	//Metodo para insertar un dato
	public static void insert(final String nombreTarea, final String descripcionTarea, final String tareaRealizada,final String valorTarea, final String trabajoTarea){
		 //LLamamos a la clase que tendra la persistencia
		 final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		 //Creamos nuestra variable del tipo tutorial
		 final Tareas tarea = new Tareas(nombreTarea, descripcionTarea, tareaRealizada, valorTarea, trabajoTarea);
		 //Y hacemos el dato que sea persistente
		 persistenceManager.makePersistent(tarea);
	}
	@SuppressWarnings("unchecked")
	public static List<Tareas> todaslasTareas(){
	 final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
	 final Query query = persistenceManager.newQuery(Tareas.class);
	 query.setRange(0, FETCH_MAX_RESULTS);
	 return (List<Tareas>) query.execute();
	}

}
