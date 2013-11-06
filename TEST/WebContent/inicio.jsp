<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="home.LoginServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="auth.jsp" method="post">


<%
HttpSession sesion=request.getSession();
String mensaje=(String)sesion.getAttribute("msg");

if (mensaje == null )
	out.print("<p> mensaje nulo: "+  mensaje + "</p>");
else
	out.print("<p> mensaje NO nulo: "+  mensaje + "</p>");


%> 
		<table> 
			<tr>
				<td>Users</td>
				<td><input name="user" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>articulo</td>
				<td><input name="articulo" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
	
	
	<form action=crearusuario.jsp>
	<td>
	</td>
	<input type="submit" value="Crear Usuario"/>
	</form>

</body>
</html>