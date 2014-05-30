package ar.com.twitter.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.twitter.model.Correlatividades;
import ar.com.twitter.model.materias;
import ar.com.twitter.dao.*;

import com.google.gson.Gson;

@Controller
public class MateriasJSON extends AbstractJsonController {

	@RequestMapping(value = "/ge", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin(HttpServletRequest req, HttpServletResponse response)
			throws IOException, SQLException {
				MateriasDAO matdao=new MateriasDAO();
				Collection <materias> Materias;
				Materias=matdao.getMaterias();
				return new Gson().toJson(Materias);
				
	}
	
	@RequestMapping(value = "/correlatividades", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin1(HttpServletRequest req, HttpServletResponse response)
			throws IOException, SQLException {
				MateriasDAO matdao=new MateriasDAO();
				Collection <Correlatividades> Correlatividades;
				Correlatividades=matdao.getCorrelatividades();
				return new Gson().toJson(Correlatividades);
				
	}
	

	@RequestMapping(value = "/getmaterias", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String getMaterias(HttpServletRequest req, HttpServletResponse response,int anio, int cuatrimestre)
			throws IOException, SQLException {
			
				MateriasDAO matdao=new MateriasDAO();
				Collection <materias> Materias;
				
				Materias=matdao.getMateriasPorCuatrimestre(anio,cuatrimestre);
				return new Gson().toJson(Materias);
				
	}
	
	
	
	

		
}
