/**
 * 
 */
package ar.com.twitter.model;

/**
 * @author lucia
 *
 */
public class Alumno {

	private Long dni;
	private String apellido;
	private String nombre;
	private String mail;
	// por ahora solo esto
	public Long getDni() {
		return dni;
	}
	public void setDni(long l) {
		this.dni = (long) l;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;//
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
//	public ArrayList<String> obtenerAlumnos(String parametro){
//
//		ArrayList<String> Alumnos = new ArrayList<String>();
//		Alumnos.add(parametro);   // Añade el elemento al ArrayList
//		return Alumnos;
//	}
	
}
