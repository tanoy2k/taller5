<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="home.datos" %>
     <%@ page import = "java.sql.*"%> 
     <jsp:useBean id="datos" class="home.datos" scope="application"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>
<table>
<thead>
<tr>
	<td><span>APELLIDO, NOMBRE / RAZÓN SOCIAL</span> </td>
	<td><span>CUIT</span> </td>
	<td><span>TELEFONO</span> </td>
</tr>
</thead>

<%
int perfil;
HttpSession sesion=request.getSession();
sesion.setMaxInactiveInterval(15);
if(null == sesion.getAttribute("perfil"))
	{
	response.sendRedirect("salir.jsp");
	}
else
{
	datos data=new datos();
	data.conectar();
	ResultSet rs=data.rs;
	String SQL = "SELECT * FROM PROVEEDORES";
	Statement stmt = data.con.createStatement(); 
	rs=stmt.executeQuery(SQL);
	while (rs.next())
	{
		System.out.println("hola");
		out.print("<tr>");
		out.print("<td><span>"+ (String) rs.getString(2) +"</span></td>");
		out.print("<td><span>"+ (String) rs.getString(4) +"</span></td>");
		out.print("<td><span>"+ (String) rs.getString(8) +"</span></td>");
		out.print("<tr>");
		
				
	}
	
}


%>
</table>

</body>
</html>