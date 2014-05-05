<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">.test{color:#f00;}</style>
<script src="./jquery-1.10.2.js"></script> 
<script type="text/javascript">
//   jQuery.getJSON( "http://localhost:8080/twitter/test.htm",success(data, textStatus, jqXHR)] )

// Assign handlers immediately after making the request,
// and remember the jqxhr object for this request
var jqxhr = $.getJSON( "http://localhost:8080/twitter/test.htm", function() {
  console.log( "success" );
  $('#indicator').html("cargando..");
})
  .done(function(json) {
    console.log( "second success" );
    
    $.each(json,function(i,j){
    	
        $(j).each(function(k,v){    
        	
        	console.log(k);
         console.log(v.mensaje);
         console.log(v.autor);
         console.log(v.fecha);
         //$('#twitts').append(v.mensaje);
         
         $( "<div/>", {
        	  "class": "test",
        	  text:  v.mensaje, 
        	  id: i,
        	  style: "cursor:pointer",
        	  tooltip: v.autor + " - " + v.fecha,
        	  click: function() {
        	    $( this ).toggleClass( "test" );
        	    $( this ).hide();
        	    $( this ).fadeIn();
        	    //$( this ).attr('style','cursor:hand');
        	    
        	  }
        	  //html:"<p>" + v.mensaje + "</p>"
        	})
        	  .appendTo( $('#twitts') );
         
        });
    });
   // $('#twitts').append(myP)
   // .fadeIn()
    
    ;
    $('p')
    .html('hola')
    .attr({ id : 'prueba' })
  })
  .fail(function() {
    console.log( "error" );
  })
  .always(function(data) {
    console.log( "complete\n" +  JSON.stringify(data));
  });
 
// Perform other work here ...
 
// Set another completion function for the request above
jqxhr.complete(function() {
  console.log( "second complete" );
});
   
</script>
</head>
<body>
<h1>hola</h1><div id="indicator"></div><div id="twitts"></div>
</body>
</html> 