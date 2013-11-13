package home;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSet;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import home.datos;
/**
 * Servlet implementation class usuarios
 */
@WebServlet("/usuarios")
public class usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String usuarios;
	public String password;
	public Integer profile; 
	datos datos=new datos();
	
	public Integer getProfile() {
		return profile;
	}

	public void setProfile(Integer profile) {
		this.profile = profile;
	}	
	
	public String getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(String usuarios) {
		this.usuarios = usuarios;
		datos.conectar();
		
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public void guardarusuario() throws SQLException
	{
		CallableStatement cs=null;
		datos data= new datos();
		data.conectar();
		Connection con = data.con;
		cs = con.prepareCall("{call PROC_USUARIOS(?,?)}");
		cs.setString("usuario", getUsuarios());
		cs.setString("password", getPassword());
		cs.executeUpdate();		
		
	}
	
	public boolean existeUsuario(String usuario) throws SQLException
	{
		datos data=new datos();
		data.conectar();
		Connection con = data.con;
		String SQL = "SELECT count(*) from usuarios where usuario='"+  this.usuarios +"'"; 
		Statement stmt = con.createStatement(); 
		ResultSet rs;
		rs=stmt.executeQuery(SQL);
		
		while (rs.next())
		{
			System.out.println("hola usuario " + rs.getInt(1));
			
			
			
		
		
		if (rs.getInt(1) > 0 )
			return true;
		else		
			return false;	
		}
		return false; // Caso NUll
	}
	
	public boolean guardausuario() throws SQLException
	{
		datos data=new datos();
		data.conectar();
		
		Connection con = data.con;
		String SQL = "INSERT INTO [BD].[dbo].[USUARIOS]([USUARIO] ,[PASSWORD] ,[PERFIL]) VALUES++'"+  this.usuarios.toUpperCase() +  "','"+ this.password.toUpperCase() + "',"+ this.profile +" )"; 
		Statement stmt = con.createStatement(); 
		ResultSet rs;
		rs=stmt.executeQuery(SQL);
		//con.close();
		if (rs.wasNull())
			return false;
		else		
		return true;	
		
	}
	
	
	public int updateprofile() throws SQLException
	{
		datos data=new datos();
		data.conectar();
		
		Connection con = data.con;
		String SQL = "UPDATE [BD].[dbo].[USUARIOS] SET PERFIL = " + this.profile + " where USUARIO = '"+ this.usuarios.toUpperCase() + "';"; 
		Statement stmt = con.createStatement(); 
		int  resultado;
		resultado=stmt.executeUpdate(SQL);
		con.close();
return resultado;	
		
	}
	
	
	
	public int usuariovalido () throws SQLException
	{
		CallableStatement cs=null;
		datos data= new datos();
		data.conectar();
		Connection con = data.con;
		cs = con.prepareCall("{call USUARIO_VALIDO(?,?,?)}");
		cs.registerOutParameter(3, Types.INTEGER);
		cs.setString("usuario", getUsuarios());
		cs.setString("password", getPassword());
		cs.setInt("perfil", 0);
		cs.execute();
		int perfil=cs.getInt(3);
		return perfil;
		
				
	}

}
