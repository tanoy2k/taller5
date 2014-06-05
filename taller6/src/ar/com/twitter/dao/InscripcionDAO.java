package ar.com.twitter.dao;

import java.sql.ResultSet;

import ar.com.twitter.model.*;

import java.sql.SQLException;
import java.sql.Statement;

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


		public boolean validarMateria() throws SQLException {
			int estadoCorrelativa = 0;
			boolean materiaHabilitada = true; 
			datos acceso = new datos();
			acceso.conectar();		
			String SQL = "select ESTADOMATERIA from MATERIASPORALUMNO  m where m.DNI =" + this.getAlumnoDni()
					   + "and MATERIA in(" 
					   + "   select MATERIA_CORRELATIVA from CORRELATIVIDADES c where"
					   + "   MATERIA = "+ this.getMateriaId() 
					   + ")";
			Statement stmt = acceso.con.createStatement();
			rs = stmt.executeQuery(SQL);
//			if (rs.isFirst()){
				while (rs.next()) {
					estadoCorrelativa = rs.getInt("ESTADOMATERIA");
					System.out.println("estadoCorrelativa: " + estadoCorrelativa);
					if (estadoCorrelativa == 3){
						materiaHabilitada = true;	
					}else{
						materiaHabilitada = false;
					};
				}
//			}else{
//				materiaHabilitada = true; // la materia solicitada no registra correlatividades
//			}
							
			return materiaHabilitada;

		}

		public void inscribir() throws SQLException {
			// TODO Auto-generated method stub
			datos acceso = new datos();
			acceso.conectar();		
			String SQL = "INSERT INTO INSCRIPCIONES VALUES (1,"+ + this.getAlumnoDni() +","+this.getLlamadoId()+ ","+ this.getMateriaId() +")";
			Statement stmt = acceso.con.createStatement();
			rs = stmt.executeQuery(SQL);
			
													
		}

	
}