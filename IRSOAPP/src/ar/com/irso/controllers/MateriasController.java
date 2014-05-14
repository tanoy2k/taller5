package ar.com.irso.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.irso.dao.MateriasDAO;

@Controller
public class MateriasController {

	@RequestMapping(value = "/materias", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView materias(HttpServletResponse response) throws SQLException {
		MateriasDAO mat=new MateriasDAO();
		mat.getMaterias();
		
		return new ModelAndView("materias");
	}

}
