
	$(document).ready(function(){ 
		iniciar();
	});
	
	
var iniciar = function(){
	
	$("#btnIngresar").on("click",function(){
		console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
		// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO, USANDO JQUERY
		var miUsuario = $("#loginUsuario").val();
		var miPassword = $("#loginPassword").val();
		var queryString = './authlogin.htm?usuario=' + miUsuario + '&password=' + miPassword;
		// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
		$.get( queryString,function(data){
			console.log(JSON.stringify(data));
			if (data.respuesta == "OK"){
				window.document.location.href = data.redirect;
			}else{
				alert("ingreso incorrecto: ");
			}
			});
		});
//	var inputs = $("input");
//	var obj = $.map(inputs, function(n, i)
//	{
//	    var o = {};
//	    o[n.name] = $(n).val();
//	    return o;
//	});
	
};


