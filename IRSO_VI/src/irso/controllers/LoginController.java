package irso.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller


public class LoginController {
	@RequestMapping(value = "/pepe", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView logintest(HttpServletResponse response) {
		return new ModelAndView("home");

}
}

