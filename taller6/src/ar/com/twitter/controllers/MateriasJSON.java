package ar.com.twitter.controllers;

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

import ar.com.twitter.model.Correlatividades;
import ar.com.twitter.model.materias;
import ar.com.twitter.dao.*;

import com.google.gson.Gson;

@Controller
public class MateriasJSON extends AbstractJsonController {

	@RequestMapping(value = "/getmaterias", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String authlogin(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		String json;
		if (ses.getAttribute("usuario") == null) {
			String e = "error";
			Gson gson = new Gson();
			json = gson.toJson(e);

		} else {

			MateriasDAO matdao = new MateriasDAO();
			Collection<materias> Materias;
			Materias = matdao.getMaterias();
			json = new Gson().toJson(Materias);
		}
		return json;
	}

	@RequestMapping(value = "/correlatividadesMaterias", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String getCorrelativas(HttpServletRequest req, HttpServletResponse response)
			throws IOException, SQLException {
		MateriasDAO matdao = new MateriasDAO();
		Collection<Correlatividades> Correlatividades;
		Correlatividades = matdao.getCorrelatividades();
		return new Gson().toJson(Correlatividades);
	}

}
