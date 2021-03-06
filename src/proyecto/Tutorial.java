package proyecto;

import javax.jdo.annotations.*;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Tutorial {
 //Va a ser la clave primaria de la clase Tutorial
 @PrimaryKey
 //Para que genere el codigo de forma automatica
 @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
 private Long id;
 //Creamos las variables persistence para insertar los datos
 @Persistent 
 private String autor;
 @Persistent 
 private String tutorial;
 //Constructor de la clase
 public Tutorial(String autor, String tutorial){
  this.autor = autor;
  this.tutorial = tutorial;
 }
 //Metodos get y set
 public String getAutor() {
  return autor;
 }
 public void setAutor(String autor) {
  this.autor = autor;
 }
 public String getTutorial() {
  return tutorial;
 }
 public void setTutorial(String tutorial) {
  this.tutorial = tutorial;
 }
 public Long getId() {
  return id;
 }
 public void setId(Long id) {
  this.id = id;
 }
}

