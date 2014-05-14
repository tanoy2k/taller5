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

import ar.com.twitter.model.Tweet;
import ar.com.twitter.model.materias;
import ar.com.twitter.dao.*;
import ar.com.twitter.model.*;

import com.google.gson.Gson;

@Controller
public class MateriasJSON extends AbstractJsonController {

	@RequestMapping(value = "/getmaterias", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin(HttpServletRequest req, HttpServletResponse response)
			throws IOException, SQLException {
				MateriasDAO matdao=new MateriasDAO();
				Collection <materias> Materias;
				Materias=matdao.getMaterias();
				return new Gson().toJson(Materias);
				
	}

		
}
