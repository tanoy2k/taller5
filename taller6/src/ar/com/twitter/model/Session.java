package ar.com.twitter.model;

public class Session { // lo pasamos a inglés para no herir sensibilidades
/**
	 * @author lucia
	 * j
	 */
private String ususario; // estaba public, feo eso!
private String redirect;
private String hash;
private String dateTime;
private Boolean sesionActiva = false;
public Boolean getSesionActiva() {
	return sesionActiva;
}

public void evaluarLogin(String loginRespuesta){
	if (loginRespuesta.equals("OK")){
		this.setSesionActiva(true);
		this.setRedirect("./inicio.htm");
	} else {
		this.setSesionActiva(false);
		this.setRedirect("#");
	}
}

public void setSesionActiva(Boolean sesionActiva) {
	this.sesionActiva = sesionActiva;
}
public String getUsusario() {
	return ususario;
}
public void setUsusario(String ususario) {
	this.ususario = ususario;
}
public String getRedirect() {
	return redirect;
}
public void setRedirect(String redirect) {
	this.redirect = redirect;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}


}
