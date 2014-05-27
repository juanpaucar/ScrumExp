package login;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import java.util.*;

import javax.jdo.Query;

import com.epn.edu.ec.PMF;
import com.google.appengine.api.datastore.Key;
import com.scrumexp.objects.Usuario;

public class UsuarioUtils {
	private static final int FETCH_MAX_RESULTS = 10;
	
	public static Usuario insert(final String nombreUsuario,final String emailUsuario, final String contraseniaUsuario) {
		
		// recuperacion del gestor de persistencia de JDO
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		
		// creamos un nuevo tutorial y los insertamos en el datastore
		final Usuario usuario = new Usuario(nombreUsuario,emailUsuario, contraseniaUsuario);		
		return persistenceManager.makePersistent(usuario);
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
	
	@SuppressWarnings("unchecked")
	public static Usuario geUsuario(String email) {
		final PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		String query = " select from " +
				 Usuario.class.getName() +
				 " where emailusuarios == '" +
				  email+ "'";
		List<Usuario> lista = (List<Usuario>)persistenceManager.newQuery(query).execute();
		if (lista.size()>=1) {
			return lista.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuario> getUsersBySetOfKeys(Set<Key> keys) {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Usuario.class);
		q.setFilter("key == keyParam");
		q.declareParameters(Key.class.getName()+" keyParam");
		List<Usuario> users= new ArrayList<Usuario>();
		for (Key key : keys) {
			List<Usuario> tempUser = (List<Usuario>) q.execute(key);
			if (tempUser!=null && tempUser.size()>0)
				users.add(tempUser.get(0));
		}
		return users;
	}
	
}
