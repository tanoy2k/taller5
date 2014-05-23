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

var estableceContenido = function(){   // #contenedor
	// por ahora, de ejemplo, al iniciar muestro este metodo solo... se iràn mostrando , segùn el ambito definido en la sesion, o los callbacks de cada evento/funcion
	getAlumnosTodos();
};	


var establecePie = function(){
    console.log("PIE_JSON");
};  // #pie	


var Alumno=function(nombre, apellido,dni){// simulo el objeto en javascript
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
};


var Alumnos = function(){
	this.alumnos = new Array(); // defino que contendrá una collection ( object alumno )
	this.addAlumno = function(alumno){
		this.alumnos.push(alumno);
	};
	this.listarAlumnos = function(){
		console.log( "getAlumnosTodos(): "+  JSON.stringify(this.alumnos ) ); // ojo con console.log, en viejos navegadores no funciona 
	};
	this.mostrarEnTabla = function(){
//		// Creo, en este caso la tabla como elem del DOM ( document object model , estructura jerarquica del documento en el navegador web.)		
//		var tbl = $("<table/>").attr("id","tablaContenido");
//		$("#contenedor").append(tbl);
		$('#my-table > tbody:last').append('<tr><td>'+item.nombre+'</td><td>'+item.apellido+'</td><td>'+item.dni+'</td></tr>'); 
		// usando jquery y su sintaxis recomendada por convencion, recorremos el array de objetos Alumno
	    $.each(this.alumnos, function(i,item){
	    	// apoyandonos en el framework twitter bootstrap, dibujamos la tabla en la vista:
	       	$('#my-table > tbody:last').append('<tr><td>'+item.nombre+'</td><td>'+item.apellido+'</td><td>'+item.dni+'</td></tr>');                
        }); // fin .each
	}; // fin mostrarEnTabla
};	// fin Alumnos


////accedo a prototype(metodo de clase ,estatico)
//Alumnos.prototype.addAlumno = function(alumno){ 
//	console.log("Alumnos.prototype.addAlumnos: " + alumno);
//    this.alumnos.push(alumno); //<-- "mete" al objeto alumno que viene como parm a la lista    
//}; 

// instancio el objeto mis alumnos, que contendrà una coleccion de èstos... como variable global
var misAlumnos = new Alumnos();


//un comportamiento mas sofisticado: traigo una colection de alumnos pidiendo al backend a travès de un get jquery
//èste me devuelve una respuesta json, la cual la parseo a un objeto en javascript 
//y mi objeto luego sabrà que hacer con esto...
//probemos:
//metodo traer alumnos, segun pedido en pantalla, por ahora pruebo con all
var getAlumnosTodos =	function(){
	// defino la url al recurso que me entrega la data
	var url = 'alumnos/todos.htm'; // no hace falta poner localhost a fuego!
	// usando jquery traemos el json desde esa url
	$.getJSON(url , function(alumnosJson){ // aca el controller me responde con un json
		
		// como bien dijo el profe Damián, usemos las convenciones y estandares, pasamos la data json otra vez a obj:
		jQuery.each(alumnosJson, function(pos, item){
			var miAlumno = new Alumno(); // instancio un objeto de mi clase alumno
			miAlumno.setNombre(alumnosJson[pos].nombre);
			miAlumno.setApellido(alumnosJson[pos].apellido);
			miAlumno.setDNI(alumnosJson[pos].dni);
			misAlumnos.addAlumno( miAlumno );
		});  //Fin JQuery.each
		misAlumnos.listarAlumnos();
		misAlumnos.mostrarEnTabla();
	});// Fin getJSON

}; // fin alumno.getAlumnosTodos




/*DIBUJAR DINAMICAMENTE LA TABLA...


var CabezaTabla = function(miJson){
  this.miCabeza = jQuery('#tablaAlumnos thead tr:eq(0)');
  this.miCampo = '';
  this.dibujaCamposCabecera = function(miJson){
  												jQuery.each(miJson, function(k,v){this.miCampo+='<th>'+k+'</th>'});
  											    return this.miCampo};
}
undefined
var miCabezaTabla = new CabezaTabla
undefined
miCabezaTabla.dibujaCampos(miJson)
""
miCabezaTabla.miCampo
""
miCabezaTabla.miCabeza
[
<tr>​</tr>​
]
var CabezaTabla = function(miJson){
  this.miCabeza = jQuery('#tablaAlumnos thead tr:eq(0)');
  
  this.dibujaCampos = function(miJson){var miCampo='';jQuery.each(miJson, function(k,v){miCampo+='<th>'+k+'</th>'}); jQuery(this.miCabeza).append(miCampo)}
}
undefined
var miCabezaTabla = new CabezaTabla
undefined
miCabezaTabla.dibujaCampos(miJson)
undefined
miCabezaTabla.miCabeza
*/
	