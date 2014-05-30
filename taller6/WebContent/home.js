$(document).ready(function() {
	//  Rescato usuario y despliego acciones en cabecera
	estableceCaberera();
	//  Rescato ambito a desplegar desde sesion
	estableceContenido();	
	//  Despliego contenido del footer
	establecePie();		
});

		
var estableceCaberera = function()  // #cabecera
{
    console.log("CABECERA_JSON");
};



var ContenidoPrincipal = function(){
	var self = this; //<-- por convencion, uso self para referirme a la instancia.
	this.ambito = 'inicio';//getAmbito();mos
	this.mostrarContenido = function(){
		switch (self.ambito) {
		case 'inicio':
			// instancio el objeto mis alumnos, que contendr� una coleccion de �stos...
			var misAlumnos = new Alumnos();			
			misAlumnos.getTodosLosAlumnos();
			break;
		case 'listarMaterias':
		    //code block
		    break;
		default:
		    //default code block
		}; // fin switch (self.ambito)
	}; // fin mostrarContenido()
	
	this.getAmbito = function(){
		return self.ambito;
	};
	
}; // fin ContenidoPrincipal()

var estableceContenido = function(){   // #contenedor
	// por ahora, de ejemplo, al iniciar muestro este metodo solo... se ir�n mostrando , seg�n el ambito definido en la sesion, o los callbacks de cada evento/funcion
	var miContenido = new ContenidoPrincipal();
	miContenido.mostrarContenido();
};	


var establecePie = function(){
    console.log("PIE_JSON");
};  // #pie	


var Alumno = function(nombre, apellido,dni){// simulo el objeto en javascript
	// por convenciòn hago referencia a traves de self a la instancia de mi objeto.
	var self = this;
	// establezco las propiedades
	this.nombre;
	this.apellido;
	this.dni;
	// establezco getters y setters
	this.setNombre = function(pNombre)
	{
		this.nombre = pNombre;
	};
	this.getNombre = function()
	{
		return this.nombre;
	};
	this.setApellido = function(pApellido)
	{
		this.apellido = pApellido;
	};
	this.getNombre = function()
	{
		return this.nombre;
	};	
	this.setDNI = function(pDNI)
	{
		this.dni = pDNI;
	};
	this.getDNI = function()
	{
		return this.dni;
	};	
	// Le doy conocimiento a mi alumno de còmo mostrarse en un row de una tabla...
	this.getRow = function(){
       	var rowHtml = '<tr><td>'+self.nombre+'</td><td>'+self.apellido+'</td><td>'+self.dni+'</td></tr>';
       	return rowHtml;
	};	
};


var Alumnos = function(){
	var self = this;// <-- por convencion
	this.alumnos = new Array(); // defino que contendr� una collection ( object alumno )
	this.addAlumno = function(alumno){
		self.alumnos.push(alumno);
	};
	
    this.getTodosLosAlumnos = function(){ 
    	// defino la url al recurso que me entrega la data
    	var url = 'alumnos/todos.htm'; // no hace falta poner localhost a fuego!
    	// usando jquery traemos el json desde esa url
    	$.getJSON(url , function(alumnosJson){ // aca el controller me responde con un json
    		
    		// como bien dijo el profe Dami�n, usemos las convenciones y estandares, pasamos la data json otra vez a obj:
    		jQuery.each(alumnosJson, function(pos, alumno){
    			var miAlumno = new Alumno(); // instancio un objeto de mi clase alumno
    			miAlumno.setNombre(alumno.nombre);
    			miAlumno.setApellido(alumno.apellido);
    			miAlumno.setDNI(alumno.dni);
    			self.addAlumno( miAlumno );
    		});  //Fin JQuery.each
    		
    		// Luego de bajar la data JSON al 'objeto' js, le digo que se muestre en una tabla mediante otro comportamiento de la misma clase:
    		self.mostrarEnTabla();
    	});// Fin getJSON	    	
    }; // end class
	

	// el siguiente comportamiento de la clase Alumnos, es mostrar su estado actual en una tabla HTML:
	this.mostrarEnTabla = function(){
//		// Creo, en este caso la tabla como elem del DOM ( document object model , estructura jerarquica del documento en el navegador web.)
		

		var tbl = $("<table/>").attr("id","tablaAlumnos");
		var theadHtml = '<tr><th>Nombre</th><th>Apellido</th><th>DNI</th></tr>';		
		var thead = $('<thead/>').attr('class','tablaAlumnosEncabezado');
		var tbody = $('<tbody/>').attr('class','tablaAlumnosCuerpo');
		$("#contenedor").append(tbl);		
		$('#tablaAlumnos').append(thead);
		$('#tablaAlumnos').append(tbody);
		$('#tablaAlumnos').find('thead').append(theadHtml);
		$('#tablaAlumnos').addClass("table table-striped");
		
		// usando jquery y su sintaxis recomendada por convencion, recorremos el array de objetos Alumno
	    $.each(self.alumnos, function(i,alumno){
	    	// apoyandonos en el framework twitter bootstrap, dibujamos la tabla en la vista:
//	       	$('#my-table > tbody:last').append('<tr><td>'+item.nombre+'</td><td>'+item.apellido+'</td><td>'+item.dni+'</td></tr>');                
	       	$('#tablaAlumnos').find('tbody').append(alumno.getRow());
	       	
        }); // fin .each
	}; // fin mostrarEnTabla
	
	// la siguiente funcion es solo a modo de debug en la consola de chrome
	this.listarAlumnos = function(){
		console.log( "getAlumnosTodos(): "+  JSON.stringify(this.alumnos ) ); // ojo con console.log, en viejos navegadores no funciona 
	};
};	// fin Alumnos


////accedo a prototype(metodo de clase ,estatico)
//Alumnos.prototype.addAlumno = function(alumno){ 
//	console.log("Alumnos.prototype.addAlumnos: " + alumno);
//    this.alumnos.push(alumno); //<-- "mete" al objeto alumno que viene como parm a la lista    
//}; 




//un comportamiento mas sofisticado: traigo una colection de alumnos pidiendo al backend a trav�s de un get jquery
//�ste me devuelve una respuesta json, la cual la parseo a un objeto en javascript 
//y mi objeto luego sabr� que hacer con esto...
//probemos:
//metodo traer alumnos, segun pedido en pantalla, por ahora pruebo con all
var getAlumnosTodos =	function(){
	// defino la url al recurso que me entrega la data
	var url = 'alumnos/todos.htm'; // no hace falta poner localhost a fuego!
	// usando jquery traemos el json desde esa url
	$.getJSON(url , function(alumnosJson){ // aca el controller me responde con un json
		
		// como bien dijo el profe Dami�n, usemos las convenciones y estandares, pasamos la data json otra vez a obj:
		jQuery.each(alumnosJson, function(pos, alumno){
			var miAlumno = new Alumno(); // instancio un objeto de mi clase alumno
			miAlumno.setNombre(alumno.nombre);
			miAlumno.setApellido(alumno.apellido);
			miAlumno.setDNI(alumno.dni);
			misAlumnos.addAlumno( miAlumno );
		});  //Fin JQuery.each
		misAlumnos.mostrarEnTabla();
	});// Fin getJSON

}; // fin alumno.getAlumnosTodos



	