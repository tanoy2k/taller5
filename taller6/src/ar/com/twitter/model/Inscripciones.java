package ar.com.twitter.model;

public class Inscripciones {
	private int alumnoId;
	private int llamadoId;
	private int finalId;
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
	public int getAlumnoId() {
		return alumnoId;
	}
	public void setAlumnoId(int alumnoId) {
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

    
	
}

