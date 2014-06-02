package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.twitter.model.Session;

@Controller
public class HomeController {

//	@RequestMapping(value = "/home", method = RequestMethod.GET, headers = "Accept=*/*")
//	public ModelAndView home(HttpServletResponse response) {
//		return new ModelAndView("home");
//	}
//	
//	@RequestMapping(value = "/inicio", method = RequestMethod.GET, headers = "Accept=*/*")
//	public ModelAndView inicio(HttpServletResponse response) {
//		return new ModelAndView("inicio");
//	}
//	
//	
//	
//	@RequestMapping(value = "/homejson2", method = RequestMethod.GET, headers = "Accept=*/*")
//	public ModelAndView homejson2(HttpServletResponse response) {
//		return new ModelAndView("homejson");
//	}
//
//	//	@RequestMapping(value = "/main", method = RequestMethod.GET, headers = "Accept=*/*")
//	//	public ModelAndView main(HttpServletResponse response) {
//	//		return new ModelAndView("main");
//	//	}	
//		
		
		
		@RequestMapping(value = "/home{hash}", method = RequestMethod.GET, headers = "Accept=*/*")
		public ModelAndView home(HttpServletResponse response, HttpServletRequest request) {
			// mi controler amigo, te vigilantea, si estas en la lista te deja pasar, sino te quedar arafue!
			String modelAndViewRetorno = "logintest";
			Session session = Session.getInstance();
			System.out.println("HomeController: Session.getInstance()" + session.getCallback() );
			if (session.getSesionActiva().equals(true)){
				System.out.println("HomeController: Sesion ok, hago M&V al main");
				modelAndViewRetorno = "home";
			}else{
				System.out.println("HomeController: Sesion fail, hago M&V al login");
				modelAndViewRetorno = "logintest";	
			};
			return new ModelAndView(modelAndViewRetorno);
			
		//	return new ModelAndView("home");
			
		}	
		
	
}
