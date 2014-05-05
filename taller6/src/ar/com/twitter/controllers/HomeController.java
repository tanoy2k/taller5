package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView home(HttpServletResponse response) {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView inicio(HttpServletResponse response) {
		return new ModelAndView("inicio");
	}
	
	
	
	@RequestMapping(value = "/homejson2", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView homejson2(HttpServletResponse response) {
		return new ModelAndView("homejson");
	}	
		
	
}
