<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="home.datos" %>
     <%@ page import = "java.sql.*"%> 
     <jsp:useBean id="datos" class="home.datos" scope="application"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de nuevo usuario</title>
<style type="text/css">
#center {
position: absolute;
top:0;
left:0;
right:0;
bottom:0;
margin: auto;
background: #ddd;
border: solid blue;
height: 200px;
width: 300px;
padding-left:  50px;
padding-top: 20px;

}
</style>
</head>
<body>

<div id="center">
<form action=modiusu.jsp method=post>
<table>
<tr><td>Usuario</td><td>
		<select>
		<%
		
			datos data=new datos();
			data.conectar();
			ResultSet rs=data.rs;
			String SQL = "SELECT USUARIO FROM USUARIOS";
			Statement stmt = data.con.createStatement(); 
			rs=stmt.executeQuery(SQL);
			while (rs.next())
			{
				System.out.println("hola");
				out.print("<option value='"+  rs.getString(1) +"'>"+  rs.getString(1) +"</option>");
						
			}
			
		%>
		</select>
</td></tr>
<tr>
	<td>Perfil</td>
	<td>
		<select>
		<%
		datos data2=new datos();
		data2.conectar();
		ResultSet rs2=data2.rs;
		String SQL2 = "SELECT DESCRIPCION FROM PERFILES";
		Statement stmt2 = data.con.createStatement(); 
		rs2=stmt2.executeQuery(SQL2);
		while (rs2.next())
		{
			System.out.println("hola");
			out.print("<option value='"+  rs2.getString(1) +"'>"+  rs2.getString(1) +"</option>");
					
		}
		%>
		</select>
	</td>
</tr>
</table>
<input type="submit" />
</form>
</body>
<%
 // ahora con estilo!
%>
</div>
</html>