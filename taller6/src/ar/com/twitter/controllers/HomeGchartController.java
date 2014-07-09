package ar.com.twitter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.twitter.model.Session;

@Controller
public class HomeGchartController {

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
		
		
		@RequestMapping(value = "/testgchart", method = RequestMethod.GET, headers = "Accept=*/*")
		public ModelAndView testgchart(HttpServletResponse response, HttpServletRequest request) {
		
			return new ModelAndView("testgchart");
			
		
		}	
		
		@RequestMapping(value = "/testgchartstacked", method = RequestMethod.GET, headers = "Accept=*/*")
		public ModelAndView testgchartstacked(HttpServletResponse response, HttpServletRequest request) {
		
			return new ModelAndView("testgchartstacked");
			
			
		}			
		
	
}
