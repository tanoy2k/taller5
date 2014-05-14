package ar.com.irso.dao;

import java.sql.ResultSet;

import ar.com.irso.model.*;

import ar.com.irso.model.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriasDAO {

	private ResultSet Results;
	private ArrayList<Materias> MateriasList;

	public ArrayList getMaterias() throws SQLException {
		DbConex Conex = new DbConex();
		String SQL = "SELECT articulo,descripcion,preciounit from articulos";
		Statement stmt = Conex.getConnection().createStatement();
		Results = stmt.executeQuery(SQL);
		ArrayList<Materias> MateriasList = new ArrayList<Materias>();
		while (Results.next()) {
			Materias mat = new Materias();
			System.out.println (Results.getString("DESCRIPCION"));
			MateriasList.add(mat);

		}

		return MateriasList;

	}
}
