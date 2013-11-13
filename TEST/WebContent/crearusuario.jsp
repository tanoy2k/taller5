<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de nuevo usuario</title>
<style type="text/css">
#center {
position: absolute;
top:0;
left:0;
right:0;
bottom:0;
margin: auto;
background: #ddd;
border: solid blue;
height: 200px;
width: 300px;
padding-left:  50px;
padding-top: 20px;

}
</style>
</head>
<body>

<div id="center">
<form action=alta.jsp method=post>
<table>
<tr><td>Usuario</td><td><input name="user"></td></tr>
<tr><td>Password</td><td><input type="password" name="password"></td></tr>
<tr><td>Reitere el password</td><td><input type="password" name="password2"></td></tr>
</table>
<input type="submit" />
</form>
<form action=inicio.jsp method=post>
<input type="submit"  value="Volver"/>
</body>
<%
 // ahora con estilo!
%>
</div>
</html>