package ar.com.irso.model;

import sun.util.calendar.BaseCalendar.Date;

public class Session {
	
	private String usuario;
	private String hash;
	private Date expira;
	private boolean activa;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Date getExpira() {
		return expira;
	}
	public void setExpira(Date expira) {
		this.expira = expira;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	

}
