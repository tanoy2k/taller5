<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de nuevo usuario</title>
<style type="text/css">

}
</style>

<link rel="stylesheet" type="text/css" href="./css/estilos.css">
</head>
<body>

<div id="center">
<form action=alta.jsp method=post>
<table>
<tr><td><label>Usuario</label></td><td><input name="user"></td></tr>
<tr><td><label>Password</label></td><td><input type="password" name="password"></td></tr>
<tr><td><label>Reitere el password</label></td><td><input type="password" name="password2"></td></tr>
</table>
<table style="width:500px">	
	<tr>
		<td style="width:50%">
			<input type="submit" value="Crear Usuario"/>
			</form>
		</td>
		<td>
			<form action=inicio.jsp method=post>
				<input type="submit"  value="Volver"/>
			</form>				
		</td>
	</tr> 
</table>



</body>
<%
 // ahora con estilo!
%>
</div>
</html>