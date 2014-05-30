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
import ar.com.twitter.model.Session;

//import com.google.gson.Gson;


@Controller
public class LoginControllerJSON extends AbstractJsonController {

        
        
        
        
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
                
                //return "http://www.google.com.ar";
                Session sesion = Session.getInstance();
                sesion.setUsuario(login.getUsuario());
                sesion.evaluarLogin(login.getRespuesta()); 
                Gson gson = new Gson(); 
                String json = gson.toJson(sesion); 
                System.out.println("LoginControllerJSON.JSON: " + json);
                return json;
                
        }
        
        
        
        

        

}
