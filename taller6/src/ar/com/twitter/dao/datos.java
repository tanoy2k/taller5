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

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://184.73.184.145;"
			// String connectionUrl = "jdbc:sqlserver://200.49.156.198:1453;"
			//String connectionUrl = "jdbc:sqlserver://localhost\\sqlexpress;"
					+ "DatabaseName=BD;" + "user=java;" + "password=Java20142015";
			con = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected.");
		} catch (Exception e) {
			e.printStackTrace();
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
