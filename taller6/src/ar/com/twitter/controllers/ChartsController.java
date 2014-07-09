package ar.com.twitter.controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.twitter.model.Charts;
import ar.com.twitter.model.Correlatividades;
import ar.com.twitter.model.materias;
import ar.com.twitter.dao.*;

import com.google.gson.Gson;


@Controller
public class ChartsController {
	
	@RequestMapping(value = "/chartdata", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String authlogin(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		String json = null;
		if (ses.getAttribute("usuario") == null) {
			String e = "error";
			Gson gson = new Gson();
			json = gson.toJson(e);

		} else {

			Gson gson = new Gson();
			List<Charts> chartsList=new ArrayList <Charts>();

		
//			for (int cuatrimestreOrden=1;cuatrimestreOrden<=6;cuatrimestreOrden++)
//			{
//				Charts chart = new Charts();
//				chart.setCuatrimestreOrden(cuatrimestreOrden);
//				chart.setAprobadosCant(chart.getAprobados(cuatrimestreOrden));
//				chart.setDesaprobadosCant(chart.getDesaprobados(cuatrimestreOrden));
//				chart.setAusentesCant(chart.getAusentes(cuatrimestreOrden));
//				chartsList.add(chart);
//				}
		
			ChartsDAO chartDao = new ChartsDAO();
			
			
			
			json = gson.toJson(chartDao.getStats());
					
			
		}
		return json;
	}

	

}
