<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="home.datos" %>
     <%@ page import = "java.sql.*"%> 
     <jsp:useBean id="datos" class="home.datos" scope="application"/>
    
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MENU DE APLICACION</title>
</head>
<body>
<%
int perfil;
HttpSession sesion=request.getSession();
perfil=(Integer)sesion.getAttribute("perfil");

datos data=new datos();
data.conectar();
ResultSet rs=data.rs;
String SQL = "SELECT PAGINA FROM PAGINAS WHERE PERFIL="+perfil; 
Statement stmt = data.con.createStatement(); 

rs=stmt.executeQuery(SQL);

out.print("<ul>");
while (rs.next())
{
	System.out.println("hola");
	
	
	String pagina = 	rs.getString(1);
	out.print("<li><a href='" + pagina + ".jsp' target='contenido'>" + pagina + "</a></li>" );
	
	rs.getString(1);
	
}

out.print("</ul>");

%>

</body>
</html>