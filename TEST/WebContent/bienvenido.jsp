<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <jsp:useBean id="users" class="home.usuarios" scope="application"/>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<style type="text/css">

h1 {
   font-size: 35px; 
   color: #445668; 
   text-transform: uppercase;
   text-align: center; 
   margin: 0 0 35px 0; 
   text-shadow: 0px 1px 0px #f2f2f2;
   }
</style>

</head>
<body>
<div id="box">
<br>
<h1 class="center" style="color:black;text-transform:uppercase;position:absolute;left:25%;top:80px">Bienvenido/a <b><%HttpSession sesion=request.getSession();
if (users.getUsuarios() == null)
	response.sendRedirect("inicio.jsp");
else	
 out.print( users.getUsuarios().toUpperCase() ); %></b></h1>
 </div>
</body>
</html>