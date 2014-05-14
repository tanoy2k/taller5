package ar.com.irso.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/logintest", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView logintest(HttpServletResponse response) {
		return new ModelAndView("logintest");
	}

	@RequestMapping(value = "/authlogin", params = { "usuario", "password" }, method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String authlogin(HttpServletRequest req, HttpServletResponse response,
			@RequestParam("usuario") String usuario,@RequestParam("password") String password) throws IOException,
			SQLException {
		String autorizado;
		if (usuario.equals("emilio"))
		{
			autorizado = "hola";	
		}
		else 
		{
			autorizado = "chau";
		}
		;
		return autorizado;
	}

}
