<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="home.LoginServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>


<link rel="stylesheet" type="text/css" href="./css/estilos.css">
</head>
<body>

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
	out.print("<h6>Por favor, ingese sus datos</h6>");
}

else
	{
	out.print("usuario logueado");
	out.println("PERFIL:"+perfil);
	response.sendRedirect("masterpage.html");
	}

%> 


		<form action=auth.jsp>
        <br>		
		<table > 
			<tr>
				<td align=left><label>Usuario</label></td>
				<td align=right><input name="user" /></td>
			</tr>
			<tr>
				<td align=left><label>Contraseña</label></td>
				<td align=right><input type="password" name="password" /></td>
			</tr>
		</table>
		<br>
		<table style="width:500px">	
			<tr>
				<td style="width:50%">
						<input type="submit" Value="Ingresar"/>
					</form>									
				</td>
				<td>
					<form action=crearusuario.jsp>
						<input type="submit" value="Crear Usuario"/>
					</form>				
				</td>
			</tr> 
		</table>
	
	
  
</div>
</body>
</html>