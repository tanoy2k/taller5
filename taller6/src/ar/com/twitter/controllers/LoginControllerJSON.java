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

import ar.com.twitter.dao.login;
import ar.com.twitter.model.sesion;

//import com.google.gson.Gson;

@Controller
public class LoginControllerJSON extends AbstractJsonController {

	
	
	
	
	@RequestMapping(value = "/authlogin{usuario}", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin(HttpServletRequest req, HttpServletResponse response) throws IOException, SQLException {
		super.setHeaders(response);
	
		
//		datos loginDAO= new datos();
//		try {
//			loginDAO.getclientes();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendRedirect("http://www.fabio.com.ar");
//		}
		
		login login = new login();
		
		// le paso el parametro usuario, a la propiedad usuario del objeto login
		login.setUsuario(req.getParameter("usuario"));
		
		// le paso el parametro usuario, a la propiedad password del objeto login
		login.setPassword(req.getParameter("password"));
		
		// EVALUA SI PERMITE EL INGRESO
		login.authLogin();
		

		
		if (login.getRespuesta() == "OK"){
			System.out.println("LOGIN OK NUEVA ANOTaCION");
			
		}else{
			System.out.println("LOGIN ERROR NUEVA ANOTOACION");

		}
		
		//return "http://www.google.com.ar";
		sesion sesion = new sesion();
		sesion.setUsusario("lalala");
		sesion.evaluarLogin(login.respuesta); 
		Gson gson = new Gson(); 
		String json = gson.toJson(sesion); 
		return json;
		
		//return new Gson().toJson(login);
		
		// armo el json a mano,
//		String jsonArtesano = "{'respuesta':'" + login.respuesta + "','redirect:" + login.redirect + "}";
//		
//		return jsonArtesano;
		
//		
//		usuario usuarioDB = new usuario();
//		
//		String  miUsuario = req.getParameter("usuario");
//		/*Collection<Tweet> tweets = new ArrayList<Tweet>();
//		Tweet tweet = new Tweet();
//		tweet.setAutor(miUsuario);
//		tweet.setFecha(new Date());
//		tweet.setMensaje("soy un tweet");
//		Tweet tweet2 = new Tweet();
//		tweet2.setAutor("Sergio");
//		tweet2.setFecha(new Date());
//		tweet2.setMensaje("soy otro tweet");
//		tweets.add(tweet);
//		tweets.add(tweet2);
//		*/
//		String url = "#";
//		if (miUsuario.equals(usuarioDB.getUsuario())){
//			url = "http://www.ole.com.ar";//response.sendRedirect("http://www.ole.com.ar");
//		} else { 
//			url = "http://www.google.com.";//response.sendRedirect("http://www.clarin.com.ar");
//		}
//		return url;
		
		//return new Gson().toJson(tweets);
		/*
		if (miUsuario.equals("emilio")){
			return "acceso ok"; 
		}*/
	}
	
	
	
	

	

}

