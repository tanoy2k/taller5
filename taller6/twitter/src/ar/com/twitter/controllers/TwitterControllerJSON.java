package ar.com.twitter.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.twitter.model.Tweet;

import com.google.gson.Gson;

@Controller
public class TwitterControllerJSON extends AbstractJsonController {

	@RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String test(HttpServletResponse response) {
		super.setHeaders(response);
		Collection<Tweet> tweets = new ArrayList<Tweet>();
		Tweet tweet = new Tweet();
		tweet.setAutor("Damian");
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