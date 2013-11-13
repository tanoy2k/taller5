<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 	
request.getSession().invalidate(); //kill session
// vamos al inicio // no podia evitar, emilio, hacer algo web y no poner alguna cochinada JS
%>
<script type="text/javascript">window.top.location.href='./inicio.jsp';</script>
</body>
</html>