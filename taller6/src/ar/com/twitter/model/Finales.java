package ar.com.twitter.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.twitter.dao.FinalesDAO;
import sun.util.calendar.BaseCalendar.Date;

public class Finales {
private int finalId;
private int materiaId;
private java.util.Date fecha;
private ArrayList <Profesores> profesores;
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


}
