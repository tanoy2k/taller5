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

	public ArrayList<Finales> getFinalesDAO() throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "select * from FINALES F INNER JOIN MATERIAS M ON F.MATERIA_ID=M.ID";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		ArrayList <Finales> listaFinales = new ArrayList<Finales>();
		while (rs.next())
		{
		Finales fin = new Finales();
		fin.setFinalId(rs.getInt("FINAL_ID"));
		fin.setMateriaId(rs.getInt("MATERIA_ID"));
		fin.setFecha(rs.getDate("FECHA"));
		listaFinales.add(fin);
		}
		
		return listaFinales;
	}
	
	public ArrayList<Profesores> getProfesoresPorFinal() throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "SELECT * from FINALES";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		return null;
		
		
	}
	
}
