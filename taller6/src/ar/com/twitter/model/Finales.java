package ar.com.twitter.model;

import java.util.ArrayList;
import java.util.List;

import sun.util.calendar.BaseCalendar.Date;

public class Finales {
private int finalId;
private int materiaId;
private Date fecha;
private List <Profesores> profesores;
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
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public List<Profesores> getProfesores() {
	return profesores;
}
public void setProfesores(List<Profesores> profesores) {
	this.profesores = profesores;
}

private ArrayList <Finales> getFinales()
{
	ArrayList <Finales> listaFinales=new ArrayList <Finales>();
	
	
	return listaFinales;
}


}
