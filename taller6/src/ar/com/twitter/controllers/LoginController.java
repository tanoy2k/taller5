package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/logintest", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView logintest(HttpServletResponse response) {
		return new ModelAndView("logintest");
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView login(HttpServletResponse response) {
		return new ModelAndView("logintest");
	}	
//	@RequestMapping("/alumno/{alumnoId}")
//     void findPet(@PathVariable String alumnoId) {
//	    // implementación omitida
//		System.out.println(alumnoId);
//	  }
	

	
}
