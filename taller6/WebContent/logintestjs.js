
	$(document).ready(function(){ 
		iniciar();
	});
	
	
var iniciar = function(){
	
	$("#btnIngresar").on("click",function()
	{
		console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
		// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO, USANDO JQUERY
		var miUsuario = $("#loginUsuario").val();
		var miPassword = $("#loginPassword").val();
		var queryString = 'http://localhost:8080/twitter/authlogin.htm?usuario=' + miUsuario + '&password=' + miPassword;
		// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
		$.getJSON( queryString,function(data){
			console.log("rta "+JSON.stringify(data));
			if (data.sesionActiva){
				window.document.location.href = data.redirect;
			}else{
				alert("ingreso incorrecto: ");
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


