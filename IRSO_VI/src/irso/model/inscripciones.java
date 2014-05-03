package irso.model;

import java.sql.Date;

public class inscripciones {
	public int inscripcion;
	public int getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(int inscripcion) {
		this.inscripcion = inscripcion;
	}

	public int getMateria() {
		return materia;
	}

	public void setMateria(int materia) {
		this.materia = materia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int materia;
	public Date fecha;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
