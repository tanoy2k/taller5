
	$(document).ready(function(){ 
		iniciar();
	});
	
	
var iniciar = function(){
	
	$("#btnIngresar").on("click",function(){
		console.log("anda el coso, probando el get");
		$.get('./authlogin.htm?usuario=emilio',function(data){
			window.document.location.href = data;})});
	var inputs = $("input");
	var obj = $.map(inputs, function(n, i)
	{
	    var o = {};
	    o[n.name] = $(n).val();
	    return o;
	});
	
};


