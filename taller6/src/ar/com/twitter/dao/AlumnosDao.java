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
		String SQL = "SELECT dni,apellido,nombre from alumnos";  
		Statement stmt = acceso.con.createStatement(); 
		rs = stmt.executeQuery(SQL);
		ArrayList <Alumno> alumnos=new ArrayList<Alumno>();
		while (rs.next())
			{
			Alumno alu=new Alumno();
			alu.setDni(rs.getLong("dni"));
			alu.setApellido(rs.getString("apellido"));
			alu.setNombre(rs.getString("nombre"));
			
			System.out.println(alu.getApellido());
			
			alumnos.add(alu);
					
			}
				
		return alumnos;
		
	}


	public ArrayList<Alumno> obtenerAlumno(String alumnoId) throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		System.out.println("AlumnosDao.obtenerAlumno("+ alumnoId +")");//
		String SQL = "SELECT dni,apellido,nombre from alumnos where dni = " + alumnoId + "";  
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


	