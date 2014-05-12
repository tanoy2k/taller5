
	$(document).ready(function(){ 
		iniciar();
	});
	
	
var iniciar = function(){
	
	$("#btnMaterias").on("click",function()
	{
		console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
		// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO, USANDO JQUERY
		var queryString = 'http://localhost:8080/twitter/getmaterias.htm';
		// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
		$.getJSON( queryString,function(json){
			 for(var i in json){
			        $('#lista').append(json[i].articulo);
			        $('#lista').append(json[i].descripcion);
			        $('#lista').append(json[i].precioventa);
			        $('#lista').append("<BR>");
			}
			});
		}); //



		
		
		    
//	var inputs = $("input");
//	var obj = $.map(inputs, function(n, i)
//	{
//	    var o = {};
//	    o[n.name] = $(n).val();
//	    return o;
//	});
	
};


