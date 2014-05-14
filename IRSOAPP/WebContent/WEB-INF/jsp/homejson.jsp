<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery.getJSON demo</title>
  <style>
  img {
    height: 200px;
    float: left;
  }
  </style>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  
  <script>
var prueba = function() {
  var flickerAPI = "http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?"; 
  var myTags = (($(":text").val() != "")?$(":text").val():"JR10");
  $.getJSON( flickerAPI, {
    tags: myTags ,
    tagmode: "any",
    format: "json"
  })
    .done(function( data ) {
      $.each( data.items, function( i, item ) {
        $( "<img>" ).attr( "src", item.media.m ).appendTo( "#images" );
        if ( i === 3 ) {
          return false;
        }
      });
    });
};
</script>
</head>
<body>
<input type="text" id="myText" value="Some text..."> 
<button onclick="prueba()">Try it</button>
<div id="images"></div>
 

 
</body>
</html>