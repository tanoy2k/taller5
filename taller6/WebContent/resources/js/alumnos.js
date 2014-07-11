/*
 * simula la clase Alumnos
 * 
 */

var Alumno = function(alumnoJson){// simulo el objeto en javascript
	// por convenciòn hago referencia a traves de self a la instancia de mi objeto.
	var self = this;
	// establezco las propiedades
	this.nombre = alumnoJson.nombre;
	this.apellido = alumnoJson.apellido;
	this.dni = alumnoJson.dni;
	// establezco getters y setters
	this.setNombre = function(pNombre)
	{
		self.nombre = pNombre;
	};
	this.getNombre = function()
	{
		return self.nombre;
	};
	this.setApellido = function(pApellido)
	{
		self.apellido = pApellido;
	};
	this.getNombre = function()
	{
		return self.nombre;
	};	
	this.setDNI = function(pDNI)
	{
		self.dni = pDNI;
	};
	this.getDNI = function()
	{
		return self.dni;
	};	
	this.getApellido = function(){
		return self.apellido;
	};
	// Le doy conocimiento a mi alumno de còmo mostrarse en un row de una tabla...
	this.getRow = function(){
       	var rowHtml = ['<tr><td>'
       				, self.getNombre() 
       				, '</td><td>'
       				, self.getApellido() 
       				, '</td><td>' 
       				, self.getDNI()
       				, '</td></tr>'].join("");
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
    			var miAlumno = new Alumno(alumno); // instancio un objeto de mi clase alumno, èste ya "nace" con la data del item
    			self.addAlumno( miAlumno );
    		});  //Fin JQuery.each
    		
    		// Luego de bajar la data JSON al 'objeto' js, le digo que se muestre en una tabla mediante otro comportamiento de la misma clase:
    		self.mostrarEnTabla();
    	});// Fin getJSON	    	
    }; // end class
	

	// el siguiente comportamiento de la clase Alumnos, es mostrar su estado actual en una tabla HTML:
	this.mostrarEnTabla = function(){
//		// Creo, en este caso la tabla como elem del DOM ( document object model , estructura jerarquica del documento en el navegador web.)
		$('#tablaAlumnos').remove();
		var tbl = $("<table/>").attr("id", "tablaAlumnos");
		var theadHtml = "<tr><th>Nombre</th><th>Apellido</th><th>DNI</th></tr>";
		//var tbl = viewManager.makeTableGeneric;
		
		var thead = $('<thead/>').attr('class', 'tablaAlumnoEncabezado');
		var tbody = $('<tbody/>').attr('class', 'tablaAlumnoCuerpo');
		$("#contenedor").append(tbl);
		$('#tablaAlumnos').append(thead);
		$('#tablaAlumnos').append(tbody);
		$('#tablaAlumnos').find('thead').append(theadHtml);
		$('#tablaAlumnos').addClass("table table-striped");

		//$(tbl).attr("id","tablaAlumnos");
		//$(tbl).find('thead').append(theadHtml);
		//$("#contenedor").append(tbl);		
		
		// usando jquery y su sintaxis recomendada por convencion, recorremos el array de objetos Alumno
	    $.each(self.alumnos, function(i,alumno){
	    	// apoyandonos en el framework twitter bootstrap, dibujamos la tabla en la vista:                
	       	$('#tablaAlumnos').find('tbody').append(alumno.getRow());	       	
        }); // fin .each
	}; // fin mostrarEnTabla
	
	// la siguiente funcion es solo a modo de debug en la consola de chrome 
	this.listarAlumnosJson = function(){
		console.log( "getAlumnosTodos(): "+  JSON.stringify(this.alumnos ) ); // ojo con console.log, en viejos navegadores no funciona 
	};
	
};	// fin Alumnos


////accedo a prototype(metodo de clase ,estatico)
//Alumnos.prototype.addAlumno = function(alumno){ 
//	console.log("Alumnos.prototype.addAlumnos: " + alumno);
//    this.alumnos.push(alumno); //<-- "mete" al objeto alumno que viene como parm a la lista    
//}; 


//una generica solo por PRUEBAAAAAAAAAAAAA!
var AlumnosManager = function(msg){
	var self = this;
	this.mensaje = msg;
	alert(self.mensaje);	
	$("#contenedor").html(msg);	
};