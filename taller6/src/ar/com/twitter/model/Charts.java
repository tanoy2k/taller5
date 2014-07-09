package ar.com.twitter.model;

import java.sql.SQLException;

import ar.com.twitter.dao.ChartsDAO;

public class Charts {
	
	
	private int cuatrimestreOrden;
	private int aprobadosCant;
	private int ausentesCant;
	private int desaprobadosCant;
	public int getAprobados() {
		return aprobadosCant;
	}
	public void setAprobadosCant(int aprobados) {
		this.aprobadosCant = aprobados;
	}
	public int getAusentesCant() {
		return ausentesCant;
	}
	public void setAusentesCant(int ausentes) {
		this.ausentesCant = ausentes;
	}
	public int getDesaprobadosCant() {
		return desaprobadosCant;
	}
	public void setDesaprobadosCant(int desaprobados) {
		this.desaprobadosCant = desaprobados;
	}



	
	
	public int getCuatrimestreOrden() {
		return cuatrimestreOrden;
	}
	public void setCuatrimestreOrden(int cuatrimestreOrden) {
		this.cuatrimestreOrden = cuatrimestreOrden;
	}
	
		
	public int getAprobados (int cuatrimestreOrden) throws SQLException
	{
		ChartsDAO chartDAO=new ChartsDAO();
		return chartDAO.getAprobadosDAO(cuatrimestreOrden);
		
}
	
	public int getDesaprobados (int cuatrimestreOrden) throws SQLException
	{
		ChartsDAO chartDAO=new ChartsDAO();
return chartDAO.getDesaprobadosDAO(cuatrimestreOrden);
}
	
	
	public int getAusentes (int cuatrimestreOrden) throws SQLException
	{
		ChartsDAO chartDAO=new ChartsDAO();
		return chartDAO.getAusentesDAO(cuatrimestreOrden);
		
	}

}
