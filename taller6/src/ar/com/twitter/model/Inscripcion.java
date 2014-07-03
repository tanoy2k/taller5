package ar.com.twitter.model;

import java.sql.SQLException;
import java.util.List;

import ar.com.twitter.dao.InscripcionDAO;

public class Inscripcion {
	private long alumnoId;
	private int llamadoId;
	private int finalId;
	private int materiaId;
	
	private java.util.Date fechaAlta;
	public java.util.Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public java.util.Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(java.util.Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	private java.util.Date fechaBaja;
	public long getAlumnoId() {
		return alumnoId;
	}
	public void setAlumnoId(long alumnoId) {
		this.alumnoId = alumnoId;
	}
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
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
	public int getMateriaId() {
		return materiaId;
	}
	public int getEstadoMateria() throws SQLException {
		InscripcionDAO inscDao = new InscripcionDAO();
		return inscDao.getEstadoMateria(this.getMateriaId());
	}
	public List<Integer> getEstadoCorrelativas() throws SQLException {
		InscripcionDAO inscDao = new InscripcionDAO();
		List<Integer> estadoCorrelativas = inscDao.getEstadoCorrelativas(this.getAlumnoId(),this.getMateriaId());			
		return estadoCorrelativas;
	}
	public void inscribir() throws SQLException {
		// TODO Auto-generated method stub
		InscripcionDAO inscDao = new InscripcionDAO();
		inscDao.inscribir(this.getAlumnoId(),this.getLlamadoId(),this.getFinalId());
	}
    
	
}

