package ar.com.twitter.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.twitter.model.Tweet;

import com.google.gson.Gson;

@Controller
public class LoginControllerJSON extends AbstractJsonController {

	
	@RequestMapping(value = "/authlogin{usuario}", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authlogin(HttpServletRequest req, HttpServletResponse response) throws IOException {
		super.setHeaders(response);
		String  miUsuario = req.getParameter("usuario");
		/*Collection<Tweet> tweets = new ArrayList<Tweet>();
		Tweet tweet = new Tweet();
		tweet.setAutor(miUsuario);
		tweet.setFecha(new Date());
		tweet.setMensaje("soy un tweet");
		Tweet tweet2 = new Tweet();
		tweet2.setAutor("Sergio");
		tweet2.setFecha(new Date());
		tweet2.setMensaje("soy otro tweet");
		tweets.add(tweet);
		tweets.add(tweet2);
		*/
		String url = "#";
		if (miUsuario.equals("emilio")){
			url = "http://www.ole.com.ar";//response.sendRedirect("http://www.ole.com.ar");
		} else { 
			url = "http://www.clarin.com.ar";//response.sendRedirect("http://www.clarin.com.ar");
		}
		return url;
		
		//return new Gson().toJson(tweets);
		/*
		if (miUsuario.equals("emilio")){
			return "acceso ok"; 
		}*/
	}
	
	
	
	
	@RequestMapping(value = "/authlogin/{usuario}", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String authloginResponse(@PathVariable String usuario, HttpServletResponse response) {
		super.setHeaders(response);
		
		Collection<Tweet> tweets = new ArrayList<Tweet>();
		Tweet tweet = new Tweet();
		tweet.setAutor(usuario);
		tweet.setFecha(new Date());
		tweet.setMensaje("soy un tweet");
		Tweet tweet2 = new Tweet();
		tweet2.setAutor("Sergio");
		tweet2.setFecha(new Date());
		tweet2.setMensaje("soy otro tweet");
		tweets.add(tweet);
		tweets.add(tweet2);
		return new Gson().toJson(tweets);
	}	
	

}

