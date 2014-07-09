package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ar.com.twitter.model.*;

public class ChartsDAO {
	
	private static ResultSet rs;
	datos acceso= new datos();
	
	
		
	
	public int getAprobadosDAO (int cuatrimestreOrden) throws SQLException
	{
		int cantidad=0;
		acceso.conectar();
		String SQL = "SELECT COUNT (*) as CANTIDAD FROM inscripciones I  "
				+ "INNER JOIN FINALES F "
				+ "ON I.FINAL_ID=F.FINAL_ID "
				+ "INNER JOIN MATERIAS M "
				+ "ON M.ID=F.MATERIA_ID "
				+ "WHERE F.LLAMADO=1 "
				+ "and M.CUATRIMESTRE_ORDEN="+ cuatrimestreOrden
				+ " and I.NOTA<>'A' "
				+ " and I.NOTA>=4";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		while (rs.next())
		{
			cantidad=rs.getInt("CANTIDAD");
		}
		
		return cantidad;
		}
	
	
	public int getAusentesDAO (int cuatrimestreOrden) throws SQLException
	{
		int cantidad=0;
		acceso.conectar();
		String SQL = "SELECT COUNT (*) as CANTIDAD FROM inscripciones I "
				+ "INNER JOIN FINALES F "
				+ "ON I.FINAL_ID=F.FINAL_ID "
				+ "INNER JOIN MATERIAS M "
				+ "ON M.ID=F.MATERIA_ID "
				+ "WHERE F.LLAMADO=1 "
				+ "and M.CUATRIMESTRE_ORDEN="+ cuatrimestreOrden
				+ " and I.NOTA='A'";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		while (rs.next())
		{
			cantidad=rs.getInt("CANTIDAD");
		}
		
		return cantidad;
	}
	
	public int getDesaprobadosDAO (int cuatrimestreOrden) throws SQLException
	{
		int cantidad=0;
		acceso.conectar();
		String SQL = "SELECT COUNT (*) as CANTIDAD FROM inscripciones I "
				+ "INNER JOIN FINALES F "
				+ "ON I.FINAL_ID=F.FINAL_ID "
				+ "INNER JOIN MATERIAS M "
				+ "ON M.ID=F.MATERIA_ID "
				+ "WHERE F.LLAMADO=1 "
				+ "and M.CUATRIMESTRE_ORDEN="+ cuatrimestreOrden
				+ " and I.NOTA<>'A' "
				+ " and I.NOTA<4";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		while (rs.next())
		{
			cantidad=rs.getInt("CANTIDAD");
		}
		
		return cantidad;
	}

}
