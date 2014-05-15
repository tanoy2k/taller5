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
private Integer sesionActiva;


public Integer getSesionActiva() {
	//System.out.println(this.sesionActiva);
	return sesionActiva;
}

public void evaluarLogin(String loginRespuesta){
	if (loginRespuesta.equals("OK")){
		this.setSesionActiva(1);
		this.setRedirect("./home.htm?1");
	} else {
		this.setSesionActiva(0);
		this.setRedirect("#");
	}
}

public void setSesionActiva(Integer sesionActiva) {
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
