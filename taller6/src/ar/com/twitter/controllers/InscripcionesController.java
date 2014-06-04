package ar.com.twitter.controllers;

//import ar.com.twitter.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import ar.com.twitter.model.Alumno;
import ar.com.twitter.model.Finales;
import ar.com.twitter.model.InscripcionFinal;
import ar.com.twitter.model.Session;

//import com.google.gson.Gson;

@Controller
public class InscripcionesController extends AbstractJsonController {

	@RequestMapping(value = "/inscribirfinal", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String inscribir(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		super.setHeaders(response);

		System.out
				.println("InscripcionesController.InterfaceInscripcion.ingreso OK");

		// Emilio, te paso ejemplo para tomar parametros from JSON
		final String json = req.getParameter("json");
		final Gson gson = new Gson();
		// a modo de ejemplo a un objeto alumno
		final Alumno alumno = gson.fromJson(json, Alumno.class);

		// Prueba de InterfazMateria()
		InscripcionFinal inscripcionFinal = new InscripcionFinal();
		boolean habilitado = inscripcionFinal.validarMateria(28213672);

		if (habilitado) {
			System.out
					.println("InscripcionesController.InterfaceInscripcion.inscribir == true");
		} else {
			System.out
					.println("LoginControllerJson.InterfaceInscripcion.inscribir == false");
		}

		return json;

	}

	@RequestMapping(value = "/finales", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String finales(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		String json;
		Collection<Finales> finalcol;
		final Finales finaleslist = new Finales();
		finalcol = finaleslist.getFinales();
		final Gson gson = new Gson();
		json = gson.toJson(finalcol);
		return json;
	}

}
