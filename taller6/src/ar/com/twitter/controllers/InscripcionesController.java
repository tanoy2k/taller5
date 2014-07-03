package ar.com.twitter.controllers;

//import ar.com.twitter.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import ar.com.twitter.dao.InscripcionDAO;
import ar.com.twitter.model.Finales;
import ar.com.twitter.model.Inscripcion;

//import com.google.gson.Gson;

@Controller
public class InscripcionesController extends AbstractJsonController {

	@RequestMapping(value = "/inscribirfinal", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String inscribir(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		super.setHeaders(response);

		System.out.println("InscripcionesController.InterfaceInscripcion.ingreso OK");
		String usuarioSesion = (String) ses.getAttribute("usuario");
		long alumnoDni =  Long.valueOf(usuarioSesion) ;
		int materiaId = Integer.valueOf(req.getParameter("matid") ) ;
		int finalId = Integer.valueOf(req.getParameter("finid") ) ;
		int llamadoId = Integer.valueOf(req.getParameter("llamid") ) ;
		
//		InscripcionDAO inscDao = new InscripcionDAO();
//		inscDao.setAlumnoDni(alumnoDni);
//		inscDao.setMateriaId(materiaId);
//		inscDao.setLlamadoId(llamadoId);
//		inscDao.setFinalId(finalId);
		
		Inscripcion inscripcion = new Inscripcion(); 
		inscripcion.setAlumnoId(alumnoDni);
		inscripcion.setMateriaId(materiaId);
		inscripcion.setLlamadoId(llamadoId);
		inscripcion.setFinalId(finalId);
		
		
		boolean materiaHabilitada = true;
		
	    HashMap<String, String> hm = new HashMap<String, String>();

		
		
		int estadoMateria = inscripcion.getEstadoMateria();
		if (estadoMateria == 2){
			List<Integer> estadoCorrelativas = inscripcion.getEstadoCorrelativas();			
		    for (Integer estadoCorrelativa : estadoCorrelativas) {
		        System.out.println(estadoCorrelativa);
		        if (estadoCorrelativa < 3 ){
		        	materiaHabilitada = false;
		        	break; // xq no?
		        }
		    }			
		}else{
			materiaHabilitada = false;
		    hm.put("mensaje", "La cursada de la materia no esta aprobada");
		}
		
		System.out.println("materiaHabilitada: " + materiaHabilitada );

		
		
		if(materiaHabilitada){
			inscripcion.inscribir();
		    hm.put("mensaje", "Ha sido inscripto correctamente");
		};
		
	    hm.put("inscripcion", String.valueOf(materiaHabilitada));	    
	    Gson gson = new Gson();
	    
		return gson.toJson(hm);

	}

	@RequestMapping(value = "/finales", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	String finales(HttpServletRequest req, HttpServletResponse response,
			HttpSession ses) throws IOException, SQLException {
		String json;
		Collection<Finales> finalcol;
		final Finales finaleslist = new Finales();
		finalcol = finaleslist.getFinales();
		final Gson gson = new Gson();
		json = gson.toJson(finalcol);
		return json;
	}

}
