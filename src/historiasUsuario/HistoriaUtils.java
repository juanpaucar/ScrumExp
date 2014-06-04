package historiasUsuario;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;



public class HistoriaUtils {

	private static final int FETCH_MAX_RESULTS = 10;
	//Metodo para insertar un dato
	public static void insert(final String nombreHistoria, final String descripcionHistoria, final String prioridadHistoria,final String estimacionHistoria,final String esfuerzoHistoria){
	 //LLamamos a la clase que tendra la persistencia
	 final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
	 //Creamos nuestra variable del tipo tutorial
	 final Historia historia = new Historia(nombreHistoria, descripcionHistoria, prioridadHistoria, estimacionHistoria, esfuerzoHistoria);
	 //Y hacemos el dato que sea persistente
	 persistenceManager.makePersistent(historia);
	}
	
	@SuppressWarnings("unchecked")
	public static List<Historia> todaslasHistoria(){
	 final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
	 final Query query = persistenceManager.newQuery(Historia.class);
	 query.setRange(0, FETCH_MAX_RESULTS);
	 return (List<Historia>) query.execute();
	}
	
	@SuppressWarnings("unchecked") 
	public static Historia actualizarHistoria(String nombreHistoria, String descripcionHistoria, String prioridadHistoria, String estimacionHistoria, String esfuerzoHistoria ) { 
				
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager(); 
		
				String query = " select from " + 
				Historia.class.getName() +
				" where nombreHistoria == '" +
				nombreHistoria+ "'" ;				
				List<Historia> historia = (List<Historia>)persistenceManager.newQuery(query).execute(); 
				if(historia.size()>=1) {
					Historia his = historia.get(0);
					his.setDescripcionHistoria(descripcionHistoria);
					his.setEsfuerzoHistoria(esfuerzoHistoria);
					his.setEstimacionHistoria(estimacionHistoria);
					his.setPrioridadHistoria(prioridadHistoria);
					
				}
				
				return null;
						
	}
	
	
}
