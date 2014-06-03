package ar.com.twitter.dao;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ar.com.twitter.model.Finales;
import ar.com.twitter.model.Profesores;

public class FinalesDAO {

	private ResultSet rs;
	private ResultSet rs2;

	public ArrayList<Finales> getFinalesDAO() throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "select * from FINALES F INNER JOIN MATERIAS M ON F.MATERIA_ID=M.ID";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		ArrayList<Finales> listaFinales = new ArrayList<Finales>();
		int fId;
		while (rs.next()) {
			Finales fin = new Finales();
			fin.setFinalId(rs.getInt("FINAL_ID"));
			fin.setMateriaId(rs.getInt("MATERIA_ID"));
			fin.setFecha(rs.getDate("FECHA"));
			fId=(rs.getInt("FINAL_ID"));
			fin.setProfesores(getProfesoresPorFinal(fId));
			listaFinales.add(fin);
			
		}
	
		return listaFinales;
	}

	public ArrayList<Profesores> getProfesoresPorFinal(int finalId)
			throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "select TITULO,NOMBRE,APELLIDO "
				+ "from profesores prof "
				+ "inner join PERSONAS per on prof.PERSONA_ID=per.PERSONA_ID "
				+ "inner join PROFESORESPORFINAL pfin ON prof.PERSONA_ID=pfin.PROFESOR_ID "
				+ "where pfin.FINAL_ID="+finalId;
		Statement stmt = acceso.con.createStatement();
		rs2 = stmt.executeQuery(SQL);
		ArrayList <Profesores> profeList = new ArrayList <Profesores>();
		while (rs2.next())
		{
			Profesores profe = new Profesores();
			profe.setNombre(rs2.getString("NOMBRE"));
			profeList.add(profe);
		}
				
		
		
		return profeList;

	}

}
