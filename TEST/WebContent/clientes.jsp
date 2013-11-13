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
	String SQL = "SELECT * FROM CLIENTES";
	Statement stmt = data.con.createStatement(); 
	rs=stmt.executeQuery(SQL);
	out.print("<ul>");
	while (rs.next())
	{
		System.out.println("hola");
		
		
		String articulo	 =rs.getString(2);
		String precio = rs.getString(3);
		out.print("<li>" + articulo +"-"+precio+ "</li>" );
				
	}
	out.print("<ul>");
}


%>
</head>
<body>

</body>
</html>