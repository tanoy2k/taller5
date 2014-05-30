package ar.com.twitter.model;

public class Session { // lo pasamos a inglés para no herir sensibilidades
	/**
	 * @author lucia j
	 */
	private String usuario; // estaba public, feo eso!
	private String redirect;
	private String hash;
	private String dateTime;
	private Boolean sesionActiva;
	private String ambito; // guia a la vista del ambito a desplegar... ponele!
	private String callback; // le dice a la vista que hacer.

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	// implementando nuestro primer patrón que nos enseño Damian: Singletòn:
	private static Session session;

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public static synchronized Session getInstance() {
		if (session == null) {
			session = new Session();
		}
		return session;
	}

	public Boolean getSesionActiva() {
		// System.out.println(this.sesionActiva);
		return sesionActiva;
	}

	public void evaluarLogin(String loginRespuesta) {
		String miCallback = "function()"; // para q no pinche
		if (loginRespuesta.equals("OK")) {
			this.setSesionActiva(true);
			this.setRedirect("./home.htm?1");
			System.out.println("Session.evaluarLogin() ; redirect: " + this.getRedirect() );
//			miCallback = "despliegaBienvenida('"+ this.getUsusario() + "')";//"despliegaBienvenida('"+ this.getUsusario() + "')";
			this.setCallback(miCallback);  // le digo a la vista que debiera trabajar en el ambito inicio
		} else {
			this.setSesionActiva(false);
			this.setRedirect("#");
			this.setAmbito("inicio"); // le digo a la vista que debiera trabajar en el ambito inicio
		}
	}

	public void setSesionActiva(Boolean sesionActiva) {
		this.sesionActiva = sesionActiva;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
