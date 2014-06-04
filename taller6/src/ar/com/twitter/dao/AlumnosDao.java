package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ar.com.twitter.model.Alumno;

public class AlumnosDao {

	public static ResultSet rs;
	private ArrayList Alumnos;
	

	public ArrayList<Alumno> obtenerAlumnos() throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		String SQL = "SELECT DNI,NOMBRE,APELLIDO FROM ALUMNOS A,PERSONAS P WHERE A.PERSONA_ID=P.PERSONA_ID";  
		ArrayList<Alumno> alumnos = obtenerDatosAlumnos(acceso, SQL);
				
		return alumnos;
		
	}


	public ArrayList<Alumno> obtenerAlumno(String alumnoId) throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		System.out.println("AlumnosDao.obtenerAlumno("+ alumnoId +")");//
		String SQL = "SELECT dni,apellido,nombre from alumnos where dni = " + alumnoId + "";  
		ArrayList<Alumno> alumnos = obtenerDatosAlumnos(acceso, SQL);
		
		return alumnos;
	}


	private ArrayList<Alumno> obtenerDatosAlumnos(datos acceso, String SQL)
			throws SQLException {
		Statement stmt = acceso.con.createStatement(); 
		rs = stmt.executeQuery(SQL);
		ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
		while (rs.next())
			{
			Alumno miAlumno=new Alumno();
			miAlumno.setDni(rs.getLong("DNI"));
			miAlumno.setApellido(rs.getString("APELLIDO"));
			miAlumno.setNombre(rs.getString("NOMBRE"));
			System.out.println(miAlumno.getApellido());
			alumnos.add(miAlumno);		
			}
		return alumnos;
	}
	
}


	