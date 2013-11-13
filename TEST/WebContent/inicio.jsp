<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="home.LoginServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#center {
position: absolute;
top:0;
left:0;
right:0;
bottom:0;
margin: auto;
background: yellow;
border: solid blue;
height: 200px;
width: 300px;
padding-left:  50px;
padding-top: 20px;

}
</style>

</head>
<body>
<form action="auth.jsp" method="post">

<div id="center">
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
	out.print("<span>Por favor, ingese sus datos</span><br>");
}

else
	{
	out.print("usuario logueado");
	out.println("PERFIL:"+perfil);
	response.sendRedirect("masterpage.html");
	}

%> 


        <br>		
		<table > 
			<tr>
				<td>Usuario</td>
				<td><input name="user" /></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" Value="Ingresar"/>
	</form>
	
	
	<form action=crearusuario.jsp>
	<input type="submit" value="Crear Usuario"/>
	</form>
  
</div>
</body>
</html>