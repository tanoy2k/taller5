package ar.com.twitter.model;

public class sesion {
/**
	 * @author lucia
	 * j
	 */
public String ususario;
public String redirect;
public String hash;
public String dateTime;
public Boolean sesionActiva = false;
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
