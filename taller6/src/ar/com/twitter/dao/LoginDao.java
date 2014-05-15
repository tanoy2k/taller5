package ar.com.twitter.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginDao {


	private String usuario;
	private String password;
	private String respuesta;
	private String redirect = null;
	
	public String getRespuesta() {
		return this.respuesta;
	}



	// resultSet de lo que lee la consulta
	private ResultSet rs;

	
	public void authLogin() throws SQLException{ // autoriza el ingreso
		datos acceso = new datos();
		acceso.conectar();
		//this.respuesta = "ERROR";
		this.setRespuesta("ERROR LOGIN");
	try {
		// TODO: EVITAR SQL INJECTION (OTRA METERIA)
		String SQL = "SELECT usuario,password FROM usuarios where usuario = '" + this.usuario.toUpperCase() + "' and password = '" + this.password.toUpperCase() + "'";  
		 Statement stmt = acceso.con.createStatement(); 
		 rs = stmt.executeQuery(SQL);
		 
		 // SOLO PARA DEBUG EN EL CATALINA.OUT:
		 System.out.print("<ul v2 voy al main3 ?>");
			while (rs.next())
			{
				System.out.println(rs.getString(1));
				
				// TODO: nueva sesion, paso datos al objeto SESION
				
				this.setRespuesta("OK"); //.respuesta = "OK";
				this.setRedirect("./main.htm"); //this.redirect = "./main";
				
				System.out.println(this.getRedirect());
			}
			System.out.print("<ul>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 

	 
	}



	public String getRedirect() {
		return redirect;
	}



	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}



	public ResultSet getRs() {
		return rs;
	}



	public void setRs(ResultSet rs) {
		this.rs = rs;
	}



	private void setRespuesta(final String respuesta) {
		this.respuesta = respuesta;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
		System.out.println("Login.java: " + this.usuario + 
				" redirect: " + this.redirect);
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
		System.out.println("Login.java: " + this.password );
	}
	
	
}
