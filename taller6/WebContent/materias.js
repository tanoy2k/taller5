$(document).ready(function() {
	iniciar();  // inicio todo, no hace falta poner otra fnc init
	//iniciar2();
});

var iniciar = function()
	{
		$("#btnMaterias").on("click",
					function() 
					{
						console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
						// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO,
						// USANDO JQUERY
						var queryString = 'getmaterias.htm'; // no hace falta poner localhost a fuego
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString, function(json) {
							for ( var i in json) {
								$('#lista').append(json[i].articulo);
								$('#lista').append(json[i].descripcion);
								$('#lista').append(json[i].precioventa);
								$('#lista').append("<BR>");
							} // fin for
						}); // fin getJSON
					} // fin function live onclick()
	); // fin selector jquery
		
	$("#btnMaterias2").on("click",
			function() {
						var queryString2 = 'getmaterias.htm'; // no hace falta poner la url completa..usar la relativa
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString2, function(json) {
							$('#lista').empty();
							for ( var i in json) {
								$('#lista2').append('<a href="http://localhost:8080/getarticulo/'+(json[i].articulo)+'">'+(json[i].articulo)+'</a>');
								$('#lista2').append(json[i].descripcion);
								$('#lista2').append(json[i].precioventa);
								$('#lista2').append("<BR>");
							} // fin for
						}); // fin .getJSON
			} // fin function .onClick
	); // fin jquery
 
	$("#btnMaterias3").on("click",
			function() {
						var queryString2 = 'getmaterias.htm/5'; // prueba tomar el articulo 5.... solo test
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString2, function(json) {
							for ( var i in json) {
								$('#lista2').append(json[i].articulo);
								$('#lista2').append(json[i].descripcion);
								$('#lista2').append(json[i].precioventa);
								$('#lista2').append("<BR>");
							} // fin for
						}); // fin .getJSON
			} // fin function .onClick
	); // fin jquery

}; // fin funcion 'init'

