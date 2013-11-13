<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <jsp:useBean id="users" class="home.usuarios" scope="application"/>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<style type="text/css">

#box{
position:absolute;
background: #ddd;
border: solid blue;
height: 200px;
width: 500px;
margin-left:20%;
padding-left:  50px;
padding-top: 20px;

}
</style>
</head>
<body>
<div id="box">
<h1 class="center" style="color:blue;position:absolute;left:25%;top:10px">Bienvenido <b><%HttpSession sesion=request.getSession();
if (users.getUsuarios() == null)
	response.sendRedirect("inicio.jsp");
else	
 out.print( users.getUsuarios().toUpperCase() ); %></b></h1>
 </div>
</body>
</html>