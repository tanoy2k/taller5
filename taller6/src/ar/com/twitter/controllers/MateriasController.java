package ar.com.twitter.controllers;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MateriasController {

	@RequestMapping(value = "/materias", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView materias(HttpServletResponse response) {
		return new ModelAndView("materias");
	}
	
	
	
}
