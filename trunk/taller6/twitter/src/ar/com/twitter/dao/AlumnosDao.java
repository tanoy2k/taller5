package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ar.com.twitter.model.Alumno;

public class AlumnosDao {

	private static ResultSet rs;
	
	public ArrayList<Alumno> obtenerAlumnos() throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		String SQL = "SELECT dni,apellido,nombre from alumnos";  
		ArrayList<Alumno> alumnos = lala(acceso, SQL);
				
		return alumnos;
		
	}


	public ArrayList<Alumno> obtenerAlumno(String alumnoId) throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		System.out.println("AlumnosDao.obtenerAlumno("+ alumnoId +")");//
		String SQL = "SELECT dni,apellido,nombre from alumnos where dni = " + alumnoId + "";  
		ArrayList<Alumno> alumnos = lala(acceso, SQL);
		
		return alumnos;
	}


	private ArrayList<Alumno> lala(datos acceso, String SQL)
			throws SQLException {
		Statement stmt = acceso.con.createStatement(); 
		rs = stmt.executeQuery(SQL);
		ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
		while (rs.next())
			{
			Alumno miAlumno=new Alumno();
			miAlumno.setDni(rs.getLong("dni"));
			miAlumno.setApellido(rs.getString("apellido"));
			miAlumno.setNombre(rs.getString("nombre"));
			System.out.println(miAlumno.getApellido());
			alumnos.add(miAlumno);		
			}
		return alumnos;
	}
	
}


	