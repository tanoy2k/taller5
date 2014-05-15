package ar.com.twitter.dao;

import java.sql.ResultSet;

import ar.com.twitter.model.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MateriasDAO {

	public ResultSet rs;
	private ArrayList Materias;
	

	public ArrayList getMaterias() throws SQLException {
		datos acceso= new datos();
		acceso.conectar();
		String SQL = "SELECT articulo,descripcion,preciounit from articulos order by articulo";  
		Statement stmt = acceso.con.createStatement(); 
		rs = stmt.executeQuery(SQL);
		ArrayList <materias> Materias=new ArrayList<materias>();
		while (rs.next())
			{
			materias mat=new materias();
			mat.setArticulo(rs.getInt("ARTICULO"));
			mat.setDescripcion(rs.getString("DESCRIPCION"));
			mat.setPrecioventa(rs.getInt("PRECIOUNIT"));
			System.out.println(mat.getDescripcion().toString());
			
			Materias.add(mat);
					
			}
				
		return Materias;
		
	}

	public void setMaterias(ArrayList materias) {
		this.Materias = materias;
	}
	
	
	
	


	

}
