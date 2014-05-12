package proyecto;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.epn.edu.ec.PMF;

public class TutorialUtil {
//Cuantos datos mostrara en la consulta
private final static int FETCH_MAX_RESULTS = 20;
//Metodo para insertar un dato
public static void insertar(String autorName, String tutorialName){
 //LLamamos a la clase que tendra la persistencia
 final PersistenceManager pm = PMF.get().getPersistenceManager();
 //Creamos nuestra variable del tipo tutorial
 final Tutorial tutorial = new Tutorial(autorName, tutorialName);
 //Y hacemos el dato que sea persistente
 pm.makePersistent(tutorial);
}
//Para consultar los tutoriales por autor
@SuppressWarnings("unchecked")
public static List<Tutorial> tutorialesPorAutor(String autor){
 final PersistenceManager pm = PMF.get().getPersistenceManager();
 String query = " select from " +
 Tutorial.class.getName() +
 " where autor == '" +
 autor + "'";
 List<Tutorial> tutorials = (List<Tutorial>)pm.newQuery(query).execute();
 return(tutorials);
}
//Para consulta todos los tutoriales
@SuppressWarnings("unchecked")
public static List<Tutorial> todosLosTutoriales(){
 final PersistenceManager pm = PMF.get().getPersistenceManager();
 final Query query = pm.newQuery(Tutorial.class);
 query.setRange(0, FETCH_MAX_RESULTS);
 return (List<Tutorial>) query.execute();
}

}

