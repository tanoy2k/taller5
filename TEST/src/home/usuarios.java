package home;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.datos;
/**
 * Servlet implementation class usuarios
 */
@WebServlet("/usuarios")
public class usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String usuarios;
	datos datos=new datos();
	
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

	public String password;
	
       
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
		String SQL = "SELECT usuario form usuarios where usuario='"+getUsuarios()+"'"; 
		Statement stmt = con.createStatement(); 
		ResultSet rs;
		rs=stmt.executeQuery(SQL);
		
		if (rs.wasNull())
			return false;
		else		
		return true;	
		
	}

}
