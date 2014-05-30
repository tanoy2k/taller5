package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	private String usuario = "fabio"; // solo para testear cdo no tengo base
	private String password = "fabio"; // solo para testear cdo no tengo base
	private boolean validar;

	private ResultSet rs;
	private int registros;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//public boolean validarLoginDao(String usuario, String password)
	public boolean validarLoginDao() // uso las properties del objeto
			throws SQLException {
		datos acceso = new datos();
		
		// try conexión a la base
		acceso.conectar();
		
		// Uso las prop. de mi objeto DAO. (puedo tener una sesion trucha...sin acceso y traerlo de ahi?)
		String SQL = "SELECT COUNT(*) FROM USUARIOS where usuario='" + this.usuario
		+ "' AND PASSWORD='" + this.password + "'";
		
//		String SQL = "SELECT COUNT(*) FROM USUARIOS where usuario='" + usuario
//				+ "' AND PASSWORD='" + password + "'";
		Statement stmt = acceso.con.createStatement();
		rs = stmt.executeQuery(SQL);
		rs.next();
		registros=rs.getInt(1);
		if (registros == 1) {
			validar = true;
		} else {
			validar = false;
		}
		return validar;

	}

}
