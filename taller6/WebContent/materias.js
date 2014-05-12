$(document).ready(function() {
	iniciar();
	iniciar2();
});

var iniciar = function() {
	$("#btnMaterias")
			.on(
					"click",
					function() {
						console
								.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
						// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO,
						// USANDO JQUERY
						var queryString = 'http://localhost:8080/twitter/getmaterias.htm';
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString, function(json) {
							for ( var i in json) {
								$('#lista').append(json[i].articulo);
								$('#lista').append(json[i].descripcion);
								$('#lista').append(json[i].precioventa);
								$('#lista').append("<BR>");
							}
						});
					});

};
var iniciar2 = function() {
	$("#btnMaterias2")
			.on(
					"click",
					function() {
						var queryString2 = 'http://localhost:8080/twitter/getmaterias.htm';
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString2, function(json) {
							$('#lista').empty();
							for ( var i in json) {
								$('#lista2').append('<a href="http://localhost:8080/getarticulo/'+(json[i].articulo)+'">'+(json[i].articulo)+'</a>');
								$('#lista2').append(json[i].descripcion);
								$('#lista2').append(json[i].precioventa);
								$('#lista2').append("<BR>");
							}
						});
					});

};
