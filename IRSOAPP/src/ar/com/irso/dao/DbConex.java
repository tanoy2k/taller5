package ar.com.irso.dao;

import java.sql.*;

public class DbConex {
	
	static String url = "jdbc:sqlserver://184.73.184.145;"
			+ "DatabaseName=BD;" + "user=java;" + "password=Java20142015;";
	Connection connection = null;

	public DbConex() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);

			if (connection != null) {
				System.out.println("Conexión a base de datos " + " OK\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {

		return connection;
	}

	public void desconectar() {
		connection = null;
	}

}
