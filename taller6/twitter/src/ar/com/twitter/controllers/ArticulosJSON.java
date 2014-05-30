package ar.com.twitter.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/articulos/{articuloId}")
//@RequestMapping(value="/owners/{ownerId}"
public class ArticulosJSON {
	
//	@RequestMapping("/t/{parametro}")
    public void welcomeHandler(@PathVariable String articuloId) {System.out.print(" home: " + articuloId);
    	
    }
	 @RequestMapping(value="{parametro}", method=RequestMethod.GET)
	// public String findOwner( @PathVariable String parametro, String ejemplo) {
	public	 ArrayList<String> obtenerAlumnos(@PathVariable String articuloId){
//		 Owner owner = ownerService.findOwner(ownerId);
//	   model.addAttribute( "owner" , owner);
//	   return "displayOwner" ;
		 System.out.print(articuloId);
			ArrayList<String> Alumnos = new ArrayList<String>();
			Alumnos.add(articuloId);   // Añade el elemento al ArrayList
			return Alumnos;
		 	
	 } 
	
//	@RequestMapping(value = "/{dni}", method = RequestMethod.GET, produces="application/json")
//	public @ResponseBody Alumno obtenerAlumno(@PathVariable("dni")String dni){
//		
//		return this.facade.obtenerAlumno(dni);
//	}
//	
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST, headers ="Accept=application/json")
//	public @ResponseBody void insertarAlumno(@RequestBody Alumno alumno){
//		
//		this.facade.insertarAlumno(alumno);
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.PUT, headers ="Accept=application/json")
//	public @ResponseBody void modificarAlumno(@RequestBody Alumno alumno){
//		
//		this.facade.modificarAlumno(alumno);
//	}
//	
//	@RequestMapping(value = "/{dni}", method = RequestMethod.DELETE)
//	public @ResponseBody void eliminarAlumno(@PathVariable("dni")String dni){
//		this.facade.eliminarAlumno(dni);
//	}
//	
 
}