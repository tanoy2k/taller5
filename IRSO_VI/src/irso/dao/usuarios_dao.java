package irso.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.NEW;




public class usuarios_dao extends datos {
		static datos data = new datos();
		public ResultSet rs;
	public static void main(String[] args) {
	}
	
	
	
	public String getclientes() throws SQLException{
		conectar();
		
		 try {
			String SQL = "SELECT TOP 5 DESCRIPCION FROM ARTICULOS"; 
			 Statement stmt = con.createStatement(); 
			 rs = stmt.executeQuery(SQL);
			 return (rs.getString(0));
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	

}
	
}

