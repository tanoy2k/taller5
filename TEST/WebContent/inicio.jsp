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
int perfil;
HttpSession sesion=request.getSession();
sesion.setMaxInactiveInterval(1);
if(null == sesion.getAttribute("perfil"))
	{
	perfil=0;
	}
else
{
	perfil=(Integer)sesion.getAttribute("perfil");
}

if (perfil==0 )
{
	out.print("Ingese sus datos");
}

else
	{
	out.print("usuario logueado");
	out.println("PERFIL:"+perfil);
	response.sendRedirect("masterpage.html");
	}

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