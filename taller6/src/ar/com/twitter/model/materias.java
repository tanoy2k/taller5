package ar.com.twitter.model;

public class materias {

	private int materia;
	private int anio;
	private String descripcion;
	private int cuatrimestre;
    private int cuatrimestreOrden;
    
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMateria() {
		return materia;
	}

	public void setMateria(int materia) {
		this.materia = materia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public int getCuatrimestreOrden() {
		return cuatrimestreOrden;
	}

	public void setCuatrimestreOrden(int cuatrimestreOrden) {
		this.cuatrimestreOrden = cuatrimestreOrden;
	}


}
