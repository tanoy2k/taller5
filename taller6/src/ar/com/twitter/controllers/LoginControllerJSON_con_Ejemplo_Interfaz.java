package ar.com.twitter.controllers;
//import ar.com.twitter.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import ar.com.twitter.dao.LoginDaoFabio;
import ar.com.twitter.model.InscripcionFinal;
import ar.com.twitter.model.InterfaceInscripcion;
import ar.com.twitter.model.Session;

//import com.google.gson.Gson;


@Controller
public class LoginControllerJSON_con_Ejemplo_Interfaz extends AbstractJsonController {
	
	@RequestMapping(value = "/authlogin{usuario}", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin(HttpServletRequest req, HttpServletResponse response) throws IOException, SQLException {
		super.setHeaders(response);
	
		LoginDaoFabio login = new LoginDaoFabio();
		
		// le paso el parametro usuario, a la propiedad usuario del objeto login
		login.setUsuario(req.getParameter("usuario"));
		
		// le paso el parametro usuario, a la propiedad password del objeto login
		login.setPassword(req.getParameter("password"));
		
		// EVALUA SI PERMITE EL INGRESO
		login.authLogin();
		
		
		if (login.getRespuesta() == "OK"){
			System.out.println("LOGIN OK NUEVA ANOTaCION" );
			
		}else{
			System.out.println("LOGIN ERROR NUEVA ANOTOACION");

		}
		
		
		//Prueba de InterfazMateria()
		InscripcionFinal inscripcionFinal =  new InscripcionFinal();
		boolean habilitado = inscripcionFinal.inscribir(28213672);
		
		if (habilitado){
			System.out.println("LoginControllerJson.InterfaceInscripcion.inscribir == true");
		}else{
			System.out.println("LoginControllerJson.InterfaceInscripcion.inscribir == false");
		}
		
		//Singleton solo a modo de ejemplo Emilio...
		Session sesion = Session.getInstance();
		sesion.setUsuario(login.getUsuario());
		sesion.evaluarLogin(login.getRespuesta()); 
		Gson gson = new Gson(); 
		String json = gson.toJson(sesion); 
		System.out.println("LoginControllerJSON.JSON: " + json);
 		return json;
		
	
	}

	
	
	
	
	

	

}

