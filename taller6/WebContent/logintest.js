
	$(document).ready(function(){ 
		iniciar();
	});
	
	
var iniciar = function(){
	
	$("#btnIngresar").on("click",function(){
		console.log("anda el coso, probando el get");
		var miUsuario = $("#loginUsuario").val();
		$.get('./authlogin.htm?usuario=' + miUsuario,function(data){
			window.document.location.href = data;})});
	var inputs = $("input");
	var obj = $.map(inputs, function(n, i)
	{
	    var o = {};
	    o[n.name] = $(n).val();
	    return o;
	});
	
};


