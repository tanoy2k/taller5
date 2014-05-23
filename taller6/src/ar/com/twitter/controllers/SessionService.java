package ar.com.twitter.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import ar.com.twitter.dao.SessionDAO;
import ar.com.twitter.model.Session;


public class SessionService {

	private Session newsession;
	private boolean estado;
	private String usuario;
	private String hash;

	public String CreateSession(String usuario) throws SQLException {
		Session newsession = new Session();
		newsession.setUsuario(usuario);
		newsession.setHash(usuario + usuario);
		newsession.setSesionActiva(true);
		SessionDAO sDAO = new SessionDAO();
		sDAO.CreateSessionDAO(newsession);
		newsession.getHash();
		return newsession.getHash();

	}
	
	public boolean GetSessionActiva (String hash) throws SQLException{
		SessionDAO sDAO=new SessionDAO();
		estado=sDAO.GetSessionActivaDAO(hash);
		return estado;
	}
}
