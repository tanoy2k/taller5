package ar.com.twitter.model;

import java.sql.SQLException;

import ar.com.twitter.dao.LoginDAO;

public class Login {
	private String usuario;
	private String password;
	private String hash;
	private LoginDAO logDAO;
	private boolean validar;
	
	
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
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public boolean validarLogin (String usuario,String passowrd) throws SQLException{
		LoginDAO logDAO=new LoginDAO();
		logDAO.setUsuario(usuario);
		logDAO.setPassword(passowrd);
		// validar=logDAO.validarLoginDao(logDAO.getUsuario(), logDAO.getPassword());
		validar=logDAO.validarLoginDao(); //<-- uso las properties del objeto, las cuales seteamos m�s arriba...
		return validar;
	}
	
	public boolean logout() throws SQLException{
		//LoginDAO logDAO=new LoginDAO();
		boolean logout = false; // = logDAO.logout();
		return logout;
	}

}
