package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
	private String usuario;
	private String password;
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

	public boolean validarLoginDao(String usuario, String password)
			throws SQLException {
		datos acceso = new datos();
		acceso.conectar();
		String SQL = "SELECT COUNT(*) FROM USUARIOS where usuario='" + usuario
				+ "' AND PASSWORD='" + password + "'";
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
