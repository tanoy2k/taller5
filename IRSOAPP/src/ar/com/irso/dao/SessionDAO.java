package ar.com.irso.dao;

import java.sql.SQLException;
import java.sql.Statement;

import ar.com.irso.model.Session;

public class SessionDAO {
	private String hash;
	private boolean activa;
	private Session sessionDAO;

	public void CreateSessionDAO(Session dataSession) throws SQLException {
		Session sessionDAO = new Session();
		sessionDAO = dataSession;
		DbConex Conex = new DbConex();
		String SQL = "INSERT INTO SESSION (USUARIO,HASH,ACTIVA,EXPIRA) VALUES '"
				+ sessionDAO.getUsuario()
				+ "','"
				+ sessionDAO.getHash()
				+ "','"
				+ sessionDAO.isActiva()
				+ "','"
				+ sessionDAO.getExpira() + "'";
		Statement stmt = Conex.getConnection().createStatement();
		stmt.executeUpdate(SQL);

	}

}
