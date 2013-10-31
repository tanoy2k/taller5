<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.Collection" %>
    <%@ page import="home.datos" %> 
    <%@ page import="home.LoginServlet" %>
 <jsp:useBean id="datos" class="home.datos" scope="application"/>
 <jsp:useBean id="login" class="home.LoginServlet" scope="application"/>
 <jsp:useBean id="users" class="home.usuarios" scope="application"/>
<jsp:setProperty name="datos" property="*"/> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%
users.setUsuarios(request.getParameter("user"));
users.setPassword(request.getParameter("password"));
if (users.usuariovalido())
	System.out.println("valido");
else
	System.out.println("invalido");

%>
</body>
</html>