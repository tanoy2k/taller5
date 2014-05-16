package ar.com.twitter.dao;

import java.sql.ResultSet;

import ar.com.twitter.model.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MateriasDAO {

	private ResultSet rs;
	private ResultSet rs2;
	private ResultSet rs3;
	private ArrayList Materias;
	private ArrayList Correlatividades;
	private ArrayList MateriasPorAlumno;

	public ArrayList<materias> getMaterias() throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "SELECT * from materias";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		ArrayList<materias> Materias = new ArrayList<materias>();
		while (rs.next()) {
			materias mat = new materias();
			mat.setMateria(rs.getInt("ID"));
			mat.setDescripcion(rs.getString("DESCRIPCION"));
			mat.setAnio(rs.getInt("ANIO"));
			mat.setCuatrimestre(rs.getInt("CUATRIMESTRE"));
			System.out.println(mat.getDescripcion().toString());

			Materias.add(mat);

		}

		return Materias;

	}

	public void setMaterias(ArrayList materias) {
		this.Materias = materias;
	}

	public ArrayList <Correlatividades> getCorrelatividades() throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "SELECT * FROM CORRELATIVIDADES";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		ArrayList<Correlatividades> Correlatividades = new ArrayList<Correlatividades>();
		while (rs.next()) {
			Correlatividades corr = new Correlatividades();
			corr.setMateria(rs.getInt("materia"));
			corr.setMateria_correlativa(rs.getInt("materia_correlativa"));
			//acceso.conectar();
			//String SQL2="SELECT DESCRIPCION FROM MATERIAS WHERE ID=8";
			//String SQL3="SELECT DESCRIPCION FROM MATERIAS WHERE ID=1";
			//System.out.println(corr.getMateria());
			//System.out.println(corr.getMateria_correlativa());
			//Statement stmt2 = acceso.con.createStatement();
			//Statement stmt3 = acceso.con.createStatement();
		
			//rs2 = stmt2.executeQuery(SQL2);
			//rs3 = stmt3.executeQuery(SQL3);
			//corr.setDescripcionmateria(rs2.getString(0));
			//corr.setDescripcion_materia_correlativa(rs3.getString(0));
			Correlatividades.add(corr);
		}
		return Correlatividades;
	}
	

}
