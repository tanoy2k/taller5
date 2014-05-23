package ar.com.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.twitter.model.Session;

public class SessionDAO {
	private String hash;
	private boolean activa;
	private Session sessionDAO;
	private ResultSet rs;

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
		Conex.con.close();
	}
	
	public boolean GetSessionActivaDAO(String hash) throws SQLException{
		datos Conex = new datos();
		Conex.conectar();
		String SQL="SELECT COUNT()* FROM SESSION  WHERE HASH='"+hash+"'";
		Statement stmt=Conex.con.createStatement();
		stmt.executeQuery(SQL);
		rs.next();
		if (rs.getInt(1)>=1){
			activa=true;
		}
		else{
			activa=false;
		}
		
		return activa;
	}
}
