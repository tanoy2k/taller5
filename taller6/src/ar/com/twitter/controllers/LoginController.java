package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletRequest;
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
	
	
//	@RequestMapping(value = "/main", method = RequestMethod.GET, headers = "Accept=*/*")
//	public ModelAndView main(HttpServletResponse response) {
//		return new ModelAndView("main");
//	}	
	
	
	
	@RequestMapping(value = "/home{hash}", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView home(HttpServletResponse response, HttpServletRequest request) {
		// mi controler amigo, te vigilantea, si estas en la lista te deja pasar, sino te quedar arafue!
		//String modelAndViewRetorno = "logintest";
//		Session miSesion = new Session();
		System.out.println("LoginController: Session.new()" + request.getParameter("hash") );
//		if (hashId == "1"){
//			System.out.println("Sesion ok, hago M&V al main");
//			modelAndViewRetorno = "inicio";
//		}else{
//			System.out.println("Sesion fail, hago M&V al login");
//			modelAndViewRetorno = "logintest";	
//		};
		//return new ModelAndView(modelAndViewRetorno);
		
		return new ModelAndView("home");
		
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
