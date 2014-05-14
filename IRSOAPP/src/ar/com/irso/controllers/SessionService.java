package ar.com.irso.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import ar.com.irso.dao.SessionDAO;
import ar.com.irso.model.Session;

public class SessionService {

	private Session newsession;
	private boolean estado;
	private String usuario;
	private String hash;

	public String CreateSession(String usuario) throws SQLException {
		Session newsession = new Session();
		newsession.setUsuario(usuario);
		newsession.setHash(usuario + usuario);
		newsession.isActiva();
		SessionDAO sDAO = new SessionDAO();
		sDAO.CreateSessionDAO(newsession);
		newsession.getHash();
		return newsession.getHash();
		
	}

}
