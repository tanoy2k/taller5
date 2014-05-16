package ar.com.twitter.dao;

import java.sql.SQLException;
import java.sql.Statement;

import ar.com.twitter.model.Session;

public class SessionDAO {
	private String hash;
	private boolean activa;
	private Session sessionDAO;

	public void CreateSessionDAO(Session dataSession) throws SQLException {
		Session sessionDAO = new Session();
		sessionDAO = dataSession;
		datos Conex = new datos();
		Conex.conectar();
		String SQL = "INSERT INTO SESSION (USUARIO,HASH,ACTIVA,EXPIRA) VALUES ('"
				+ sessionDAO.getUsuario()
				+ "','"
				+ sessionDAO.getHash()
				+ "','"
				+ 1
				+ "','"
				+ 20120501 + "')";
		Statement stmt = Conex.con.createStatement();
		stmt.executeUpdate(SQL);
	}
}
