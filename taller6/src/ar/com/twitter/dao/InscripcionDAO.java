package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO {

	private ResultSet rs;
	private long alumnoDni;
	private int llamadoId;

	public int getLlamadoId() {
		return llamadoId;
	}

	public void setLlamadoId(int llamadoId) {
		this.llamadoId = llamadoId;
	}

	public int getFinalId() {
		return finalId;
	}

	public void setFinalId(int finalId) {
		this.finalId = finalId;
	}

	private int finalId;

	public long getAlumnoDni() {
		return alumnoDni;
	}

	public void setAlumnoDni(long alumnoDni) {
		this.alumnoDni = alumnoDni;
	}

	public int getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}

	private int materiaId;

	public List<Integer> getEstadoCorrelativas(long alumnoDni, int materiaId) throws SQLException {
		List<Integer> listEstadoCorrelativas = new ArrayList<Integer>();
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "select ESTADOMATERIA from MATERIASPORALUMNO  m where m.DNI ="
				+   alumnoDni
				+ " and MATERIA in("
				+ " select MATERIA_CORRELATIVA from CORRELATIVIDADES c where"
				+ " MATERIA = " + materiaId + ")";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			listEstadoCorrelativas.add(rs.getInt("ESTADOMATERIA"));
		}

		return listEstadoCorrelativas;

	}

	public int getEstadoMateria(int materiaId,long alumnoId) throws SQLException {
		int estadoMateria = 0;
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "select ESTADOMATERIA from MATERIASPORALUMNO where MATERIA="
				+ materiaId + " AND DNI=" + alumnoId;
				
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			estadoMateria = rs.getInt("ESTADOMATERIA");
		}
		return estadoMateria;
	}

	public void inscribir(long alumnoDni, int llamadoId, int finalId) throws SQLException {
		// TODO Auto-generated method stub
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "INSERT INTO INSCRIPCIONES VALUES (" + alumnoDni
				+ "," + llamadoId + "," + finalId
				+ ", getdate(), NULL )";
		Statement stmt = acceso.con.createStatement();
		stmt.executeUpdate(SQL);

	}

}