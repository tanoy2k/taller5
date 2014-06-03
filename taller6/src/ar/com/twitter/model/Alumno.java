/**
 * 
 */
package ar.com.twitter.model;

/**
 * @author lucia
 *
 */
public class Alumno extends Personas{

	private Long dni;
	
	// por ahora solo esto
	public Long getDni() {
		return dni;
	}
	public void setDni(long l) {
		this.dni = (long) l;
	}
	
	
//	public ArrayList<String> obtenerAlumnos(String parametro){
//
//		ArrayList<String> Alumnos = new ArrayList<String>();
//		Alumnos.add(parametro);   // Añade el elemento al ArrayList
//		return Alumnos;
//	}
	
}
