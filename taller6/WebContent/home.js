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

	// Emilio, el contenido será dinamico, con lo cual
	// el propio JSON tendrà el/los callback/s necesarios
	// para desplegar la vista. (Model to View)
	
	$.getJSON(queryString, function(json) {		
		// Creo, en este caso la tabla como elem del DOM
		 var tbl=$("<table/>").attr("id","tablaContenido");
		    $("#contenedor").append(tbl);
		    for(var i=0;i<json.length;i++)
		    {
		        var tr="<tr>";
		        var td1="<td>"+json[i]["dni"]+"</td>";
		        var td2="<td>"+json[i]["apellido"]+"</td>";
		        var td3="<td>"+json[i]["nombre"]+"</td></tr>";

		       $("#tablaContenido").append(tr+td1+td2+td3); 

		    }   	
				
		
		
	}); // fin getJSON				
	

}

var establecePie = function(){
	
    console.log("PIE_JSON");
}  // #pie	

