$(document).ready(function(){ 
	iniciar();
});


var Login = function(){
	self = this;
	this.usuario = "";
	this.password = "";
	this.getUsuario = function(){
		return self.usuario;
	};
	this.getPassword = function(){
		return self.password;
	};
	this.setValuesFromView = function(){
		self.usuario = $("#loginUsuario").val();
		self.password = $("#loginPassword").val();
	};	
};	
	
var iniciar = function(){
	
	$("#btnIngresar").on("click",function()
	{
		console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
		// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO, USANDO JQUERY
		var miLogin = new Login();
		//var json = {'usuario':miLogin.getUsuario(),'password':miLogin.getPassword()};
		//var url = './authlogin.htm?';
		miLogin.setValuesFromView();
		var url = './authlogin.htm?usuario=' + miLogin.getUsuario() + '&password=' + miLogin.getPassword() + '&otroParm';		
		// ACA SOLAMENTE MANDAMOS USR Y PSW usando postJSON
		$.getJSON( url,function(data){
				console.log("rta "+JSON.stringify(data));
				if (data.sesionActiva){
					window.document.location.href = data.redirect;
				}else{
					alert("ingreso incorrecto: ");
				}
			});
		});
	$("#btn2Ingresar").on("click",function()
			{
				console.log(" OJO CON EL CONSOLE.LOG, NO TODOS LOS BROWSERS LO ACEPTAN...LO USAMOS SOLO POR DEBUG");
				// TOMAMOS EL VALOR INGRESADO EN EL FORM POR EL USUARIO, USANDO JQUERY
				var miUsuario = $("#loginUsuario").val();
				var miPassword = $("#loginPassword").val();
				var queryString = './login2.htm?usuario=' + miUsuario + '&password=' + miPassword + '&otro';
				// ACA SOLAMENTE MANDAMOS USR Y PSW A LA VIEJA ESCUELA
				window.location=queryString;
				
				
				});
	$("#btn3logout").on("click",function()
			{
				var queryString = './logout.htm';
				window.location=queryString;
				});
	
	


		
		
		    
//	var inputs = $("input");
//	var obj = $.map(inputs, function(n, i)
//	{
//	    var o = {};
//	    o[n.name] = $(n).val();
//	    return o;
//	});
	
};


