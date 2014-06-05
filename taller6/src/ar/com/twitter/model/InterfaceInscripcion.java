package ar.com.twitter.model;

import java.sql.SQLException;

public interface InterfaceInscripcion {
	public boolean validarMateria(long alumnoDni,int materiaId) throws SQLException;

	//public boolean inscribir(long alumnoDni,int materiaId);
}


