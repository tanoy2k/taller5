<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:useBean id="usuarios" class="home.usuarios" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">.error{color:red;}</style>
</head>
<body>

</body>
</html>

<%
usuarios.setUsuarios(request.getParameter("user"));
usuarios.setPassword(request.getParameter("password"));
if (usuarios.usuarios.isEmpty())
{ 
	out.println("<h4 class='error'>Usuario no puede ser nulo</h4>");
	out.println("<A HREF='./crearusuario.jsp' TITLE='Volver atras'>Volver Atras</A>");
}
else
{
	if (usuarios.existeUsuario(request.getParameter("user")))	
	{
		out.println("<h4 class='error'>Usuario ya existente</h4>");
		out.println("<A HREF='./crearusuario.jsp' TITLE='Volver atras'>Volver Atras</A>");
    }
	else
	{
		if ((request.getParameter("password")).equals((request.getParameter("password2"))) )
		{
			usuarios.guardarusuario();
			out.println("<h4>Alta efectuada correctamente</h4>");
			out.println("<A HREF='./inicio.jsp' TITLE='Volver atras'>Volver Atras</A>");
		}
		else
		{
			out.println("<h4 class='error'>No coinciden passwords</h4>");
			out.println("<A HREF='./crearusuario.jsp' TITLE='Volver atras'>Volver Atras</A>");
	   	}
	}
}

	
%>
