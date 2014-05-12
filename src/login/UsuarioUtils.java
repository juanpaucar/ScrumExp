package login;

import java.util.List;

import javax.jdo.PersistenceManager;

import java.util.*;

import javax.jdo.Query;

import com.epn.edu.ec.PMF;

public class UsuarioUtils {
	private static final int FETCH_MAX_RESULTS = 10;
	
	public static void insert(final String nombreProyecto,final String fecha, final String descripcionProyecto) {
		
		// recuperacion del gestor de persistencia de JDO
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		
		// creamos un nuevo tutorial y los insertamos en el datastore
		final Usuario usuario = new Usuario(nombreProyecto,fecha, descripcionProyecto);		
		persistenceManager.makePersistent(usuario);
	}
	@SuppressWarnings("unchecked")
	public static List<Usuario> getEntries() {
		// recuperaciÃ³n del gestor de persistencia de JDO
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();

		// generaciÃ³n de la consulta y configuraciÃ³n de la ordenaciÃ³n de los resultados de la misma
		final Query query = persistenceManager.newQuery(Usuario.class);
	    
	    query.setRange(0, FETCH_MAX_RESULTS);	    
	    // devoluciÃ³n de resultados
	    return (List<Usuario>) query.execute();
	}
	
	@SuppressWarnings("unchecked")
	public static Usuario getUsuario(String email, String password) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		
		String query = " select from " +
				 Usuario.class.getName() +
				 " where emailusuarios == '" +
				  email+ "'";
				 List<Usuario> lista = (List<Usuario>)persistenceManager.newQuery(query).execute();
		if (lista.size()>=1)	
		{
			Usuario aux = lista.get(0);
			if (aux.getContraseniausuarios().equals(password)) {
				return aux;
			}
		}
		return null;
	}
	
}
