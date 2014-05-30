<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">.test{color:#f00;}</style>
<!-- fundamental el definir el content y el charset-->
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<!-- cargo el canal ofical de twitter bootstrap (framework css) -->  
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
<!-- cargo jquery (framework javascript) -->
<script type="text/javascript" src="jquery-1.10.2.js"></script>
<script  src="./logintest.js "></script> 
<script type="text/javascript">
//   jQuery.getJSON( "http://localhost:8080/twitter/test.htm",success(data, textStatus, jqXHR)] )
</script>

</head>
<body>

 
<h1>TALLER 6 - LOGIN</h1><div id="indicator"></div><div id="twitts"></div>

<label id="lblUsuario">Usuario</label>
<input id="loginUsuario" name="loginUsuario" type="text" placeholder="Ingrese el Usuario" class="input-xlarge"><br>
<label id="lblPassword">Contraseña</label>
<input id="loginPassword" name="loginPassword" type="password" placeholder="Ingrese la Contraseña" class="input-xlarge">
<br><button id="btnIngresar" class="btn btn-default">Ingresar</button><span>  </span><button id="btn3logout" class="btn btn-default">Logout</button> 
</body>
</html> 