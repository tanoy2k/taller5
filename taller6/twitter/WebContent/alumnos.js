$(document).ready(function() {
	iniciar();  // inicio todo, no hace falta poner otra fnc init
	//iniciar2();
});

var iniciar = function()
	{
 
		$("#btnAlumnos").on("click",
					function() 
					{
						console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
						// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO,
						// USANDO JQUERY
						var queryString = 'alumnos/todos'; // no hace falta poner localhost a fuego
						// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
						$.getJSON(queryString, function(json) {
							for ( var i in json) {
								$('#lista').append(json[i].dni);
								$('#lista').append(json[i].apellido);
								$('#lista').append(json[i].nombre);
								$('#lista').append("<BR>");
							} // fin for
						}); // fin getJSON
					} // fin function live onclick()
	); // fin selector jquery
		
		$("#btnAlumnosDni").on("click",
				function() 
				{
					console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
					// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO,
					// USANDO JQUERY
					var queryString = 'alumnos/' + $('#txtDni').val(); // no hace falta poner localhost a fuego
					// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
					$.getJSON(queryString, function(json) {
						for ( var i in json) {
							$('#lista').append(json[i].dni);
							$('#lista').append(json[i].apellido);
							$('#lista').append(json[i].nombre);
							$('#lista').append("<BR>");
						} // fin for
					}); // fin getJSON
				} // fin function live onclick()
); // fin selector jquery

}; // fin funcion 'init'

