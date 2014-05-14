package ar.com.twitter.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.twitter.model.Tweet;
import ar.com.twitter.model.materias;
import ar.com.twitter.dao.*;
import ar.com.twitter.model.*;

import com.google.gson.Gson;

@Controller
public class AlumnosControllerJSON extends AbstractJsonController {

	@RequestMapping(value = "/alumnos", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView alumnos(HttpServletResponse response) {
		return new ModelAndView("alumnos");
	}
	
	
	@RequestMapping("/alumnos/todos")
	public @ResponseBody String obtenerAlumnosController( HttpServletResponse response) throws IOException, SQLException {
	
		super.setHeaders(response);
		System.out.println("AlumnosControllerJSON/alumnos/*:  " );
		Collection<Alumno> Alumnos;
		AlumnosDao alumno = new AlumnosDao();
		Alumnos = alumno.obtenerAlumnos(); // retorna todos los lumnos
		
//		public ArrayList<String> obtenerAlumnos(String parametro){
 		//
//				ArrayList<String> Alumnos = new ArrayList<String>();		
		Gson gson = new Gson(); 
		String json = gson.toJson(Alumnos);
		// la fnc obtenerAlumnos esta hardcoded por test, reemplazar por el SQL correspondiente
		System.out.println("AlumnosController/alumnos/todos/json:  " + json);
		return json;
	  }
	
	@RequestMapping("/alumnos/getalumnobydni{dni}")

	public @ResponseBody String obtenerAlumnoController(HttpServletRequest req, HttpServletResponse response) throws IOException, SQLException {
		super.setHeaders(response);
	
		String dni =req.getParameter("dni");
		System.out.println("AlumnosController/alumnos/{dni}:  " + dni);
		Collection<Alumno> Alumnos;
		AlumnosDao alumno = new AlumnosDao();
		Alumnos = alumno.obtenerAlumno(dni); // retorna todos los lumnos
		
//		public ArrayList<String> obtenerAlumnos(String parametro){
		//
//				ArrayList<String> Alumnos = new ArrayList<String>();		
		Gson gson = new Gson(); 
		String json = gson.toJson(Alumnos);
		// la fnc obtenerAlumnos esta hardcoded por test, reemplazar por el SQL correspondiente
		System.out.println("AlumnosController/alumnos/json:  " + json);
		return json;
	  }	
}
