<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:useBean id="usuarios" class="home.usuarios" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

<%
usuarios.setUsuarios(request.getParameter("user"));
usuarios.setPassword(request.getParameter("password"));
if (usuarios.existeUsuario(request.getParameter("user")))
	
	{
	out.println("Existe usuario");
	
	}
		
		else
		{

		if ((request.getParameter("password")).equals((request.getParameter("password2"))) )
			{
			usuarios.guardarusuario();
			}
		
			else
			{
			out.println("No coinciden passwords");
			out.println("<A HREF='http://localhost:8080/TEST/crearusuario.jsp' TITLE='Volver atras'>Volver Atras</A>");
		    
			}
		}
	
%>
