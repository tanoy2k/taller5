package ar.com.twitter.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.twitter.dao.*;
import ar.com.twitter.model.Login;
import ar.com.twitter.model.Session;

import com.google.gson.Gson;

@Controller

public class LoginService {
	@RequestMapping(value = "/login2", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody void authlogin(HttpServletRequest req, HttpServletResponse response) throws IOException, SQLException {
		
		Login login = new Login();
		login.setUsuario(req.getParameter("usuario"));
		login.setPassword(req.getParameter("password"));
		boolean validar;
		String hash;
		
		validar=login.validarLogin(login.getUsuario(), login.getPassword());
		System.out.println("VALIDAR EN LS"+ String.valueOf(validar));
		if (validar==true)
		{
			System.out.println("LOGIN OKKKKK");
			SessionService Ses=new SessionService();
			hash=Ses.CreateSession(login.getUsuario());
			System.out.println(hash);
			response.sendRedirect("http://localhost:8080/twitter/main.htm?hash="+hash);
		}
		else
		{
			response.sendRedirect("http://www.google.com.ar");
		}
	
	}

}
