package ar.com.twitter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import ar.com.twitter.dao.FinalesDAO;

public class Finales {
private int finalId;
private int materiaId;
private String materiaDescripcion;
private java.util.Date fecha;
private ArrayList <Profesores> profesores;
private int llamado;
public int getLlamado() {
	return llamado;
}
public void setLlamado(int llamado) {
	this.llamado = llamado;
}
public int getFinalId() {
	return finalId;
}
public void setFinalId(int finalId) {
	this.finalId = finalId;
}
public int getMateriaId() {
	return materiaId;
}
public void setMateriaId(int materiaId) {
	this.materiaId = materiaId;
}
public Comparable<java.util.Date> getFecha() {
	return fecha;
}




public ArrayList<Profesores> getProfesores() {
	return profesores;
}
public void setProfesores(ArrayList<Profesores> profesores) {
	this.profesores = profesores;
}
public ArrayList <Finales> getFinales() throws SQLException
{
	ArrayList <Finales> listaFinales=new ArrayList <Finales>();
	FinalesDAO fDAO=new FinalesDAO();
	listaFinales=fDAO.getFinalesDAO();
	return listaFinales;
}
public void setFecha(java.sql.Date date) {
	this.fecha = date;
}
public String getMateriaDescripcion() {
	return materiaDescripcion;
}
public void setMateriaDescripcion(String materiaDescripcion) {
	this.materiaDescripcion = materiaDescripcion;
}


}
