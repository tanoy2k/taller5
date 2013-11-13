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
<%
usuarios.setUsuarios(request.getParameter("user"));
usuarios.setProfile( Integer.parseInt( request.getParameter("profile") ));
if (!usuarios.existeUsuario(request.getParameter("user")))
{
	out.println("No Existe Usuario!");
}
else
{
	if ( usuarios.updateprofile()  > 0) 
		out.println("Modificación efectuada correctamente. Usuario: " + usuarios.usuarios + ", Perfil: " + usuarios.profile ); 
	else
		out.println("Se ha producido un error al intentar Actualizar. Usuario: " + usuarios.usuarios + ", Perfil: " + usuarios.profile );
}

				
%>
</body>
</html>


