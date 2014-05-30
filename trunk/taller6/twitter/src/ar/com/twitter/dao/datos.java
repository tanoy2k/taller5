package ar.com.twitter.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class datos {

	String a;
	public ResultSet rs;
	public float valor = 0;
	CallableStatement cs = null;
	public Connection con;
	public String articulo;
	public String articulos;

	public void conectar() {
		System.out.println("Trying to connect...");
		try {
//			System.out.println("connect...");			
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String connectionUrl = "jdbc:sqlserver://184.73.184.145;" //<-- nube
			// String connectionUrl = "jdbc:sqlserver://200.49.156.198:1453;"
					
//			String connectionUrl = "jdbc:sqlserver://172.18.61.47\\SQLEXPRESS;"
//							+ "DatabaseName=BD;" + "user=java;" + "password=java";					
			//<<		+ "DatabaseName=BD;" + "user=java;" + "password=Java20142015";
//			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=DB;integratedSecurity=true;user=java;password=java";
			
			
//			String connectionUrl = "jdbc:sqlserver://localhost;databaseName=BD;integratedSecurity=true;";
//			System.out.println("Datos->connectionUrl: " + connectionUrl);			
//			
//			con = DriverManager.getConnection(connectionUrl);
//			System.out.println("Connected.");
			
			
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				System.out.println("“El driver de MSSQL se realizo con exito");
				
				//String connectionUrl = "jdbc:sqlserver://184.73.184.145;" //<-- nube
				String connectionUrl = "jdbc:sqlserver://localhost;" //<-- local
								+ "DatabaseName=BD;" + "user=java;" + "password=java20142015";
				
				//String connectionURL = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=BD";
				con = DriverManager.getConnection(connectionUrl);			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);		
		} finally {
		}
	}

	public void getclientes() throws SQLException {
		conectar();
		try {
			String SQL = "SELECT usuario,password FROM usuarios";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			System.out.print("datos.java: rs{ ");
			while (rs.next()) {
				System.out.println(rs.getString(1));

				// le paso al objeto Usuario, los datos que lei desde el query

				// String articulo =rs.getString(2);
				// String precio = rs.getString(3);
				// System.out.print("<li>" + articulo +"-"+precio+ "</li>" );

			}
			System.out.print("datos.java: rs} ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
