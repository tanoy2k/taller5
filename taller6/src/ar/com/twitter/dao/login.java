package ar.com.twitter.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class login {

	// lo leo en el JSP
	public String usuario;
	public String password;
	public String respuesta;
	public String redirect = null;
	
	public String getRespuesta() {
		return respuesta;
	}



	// resultSet de lo que lee la consulta
	private ResultSet rs;

	
	public void authLogin() throws SQLException{ // autoriza el ingreso
		datos acceso = new datos();
		acceso.conectar();
		this.respuesta = "ERROR";
	try {
		// TODO: EVITAR SQL INJECTION (OTRA METERIA)
		String SQL = "SELECT usuario,password FROM usuarios where usuario = '" + this.usuario.toUpperCase() + "' and password = '" + this.password.toUpperCase() + "'";  
		 Statement stmt = acceso.con.createStatement(); 
		 rs = stmt.executeQuery(SQL);
		 
		 // SOLO PARA DEBUG EN EL CATALINA.OUT:
		 System.out.print("<ul v2 voy al main?>");
			while (rs.next())
			{
				System.out.println(rs.getString(1));
				
				// TODO: nueva sesion, paso datos al objeto SESION
				
				this.respuesta = "OK";
				this.redirect = "./main";
			}
			System.out.print("<ul>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 

	 
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
		System.out.println("Login.java: " + this.usuario );
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
		System.out.println("Login.java: " + this.password );
	}
	
	
}
