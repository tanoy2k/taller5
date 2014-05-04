package irso.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class datos {
	public Connection con;
	
	
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
}
