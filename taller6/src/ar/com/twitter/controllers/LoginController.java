package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.twitter.model.Session;

@Controller
public class LoginController {

	@RequestMapping(value = "/logintest", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView logintest(HttpServletResponse response) {
		return new ModelAndView("logintest");
	}
	
	
//	@RequestMapping(value = "/main", method = RequestMethod.GET, headers = "Accept=*/*")
//	public ModelAndView main(HttpServletResponse response) {
//		return new ModelAndView("main");
//	}	
	
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView main(HttpServletResponse response) {
		// mi controler amigo, te vigilantea, si estas en la lista te deja pasar, sino te quedar arafue!
		String modelAndViewRetorno = "logintest";
		Session miSesion = new Session();
		if (miSesion.getSesionActiva()){
			System.out.println("Sesion ok, hago M&V al main");
			modelAndViewRetorno = "main";
		}else{
			System.out.println("Sesion fail, hago M&V al login");
			modelAndViewRetorno = "logintest";	
		};
		return new ModelAndView(modelAndViewRetorno);
	}	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView login(HttpServletResponse response) {
		return new ModelAndView("logintest");
	}	
//	@RequestMapping("/alumno/{alumnoId}")
//     void findPet(@PathVariable String alumnoId) {
//	    // implementaci�n omitida
//		System.out.println(alumnoId);
//	  }
	

	
}
