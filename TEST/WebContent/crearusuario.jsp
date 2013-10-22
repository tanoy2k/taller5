<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de nuevo usuario</title>
</head>
<body>
<form action=alta.jsp method=post>
<table>
<tr><td>Usuario</td><td><input name="user"></td></tr>
<tr><td>Password</td><td><input type="password" name="password"></td></tr>
<tr><td>Reitere el password</td><td><input type="password" name="password2"></td></tr>
</table>
<input type="submit" />
</form>
</body>
<%

%>
</html>