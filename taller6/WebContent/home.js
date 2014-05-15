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
}

var estableceContenido = function(){   // #contenedor

    console.log("CONTENEDOR_JSON");
	// USANDO JQUERY
	var queryString = 'alumnos/todos.htm'; // no hace falta poner localhost a fuego

	$.getJSON(queryString, function(json) {
		for ( var i in json) {
			$('body').append(json[i].dni);
			$('#contenedor').append(json[i].apellido);
			$('#contenedor').append(json[i].nombre);
			$('#contenedor').append("<BR>");
		} // fin for
	}); // fin getJSON						
}

var establecePie = function(){
	
    console.log("PIE_JSON");
}  // #pie	

