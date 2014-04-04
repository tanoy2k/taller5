package home;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class datos {

	String a;
	public ResultSet rs;
	public float valor = 0;
	CallableStatement cs = null;
	public Connection con;
	public String articulo;
	public String articulos;
	

	public void conectar() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress;"
			String connectionUrl = "jdbc:sqlserver://192.168.2.204;"
					+ "DatabaseName=BD;" + "user=java;" + "password=java";
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	public void setarticulo (String articulo)
	{
		
		this.articulo=articulo;
		
	}
	public void getprueba()
	{
		this.getarticulo("3");
		
	}

	public void getarticulo(String articulo) {

		try {
			// Establish the connection.
			conectar();

			cs = con.prepareCall("{call PROC_STOCK(?,?)}");
			cs.registerOutParameter(2, Types.FLOAT);
			cs.setInt(1, Integer.parseInt(articulo));
			cs.execute();
			valor = cs.getFloat(2);

			/*
			 * String SQL = "EXEC PROC_STOCK "+articulo+",0"; Statement stmt =
			 * con.createStatement(); rs = stmt.executeQuery(SQL);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getclientes() throws SQLException{
	conectar();
	
	 try {
		String SQL = "SELECT TOP 5 DESCRIPCION FROM ARTICULOS"; 
		 Statement stmt = con.createStatement(); 
		 rs = stmt.executeQuery(SQL);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
}

}
