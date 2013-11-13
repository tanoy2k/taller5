<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="JavaScript">
function mueveReloj(){
	momentoActual = new Date();
	hora = momentoActual.getHours();
	minuto = momentoActual.getMinutes();;
	segundo = momentoActual.getSeconds()
	
	str_segundo = new String (segundo);
	if (str_segundo.length == 1) 
		segundo = "0" + segundo;
		
	str_minuto = new String (minuto);
	if (str_minuto.length == 1) 
		minuto = "0" + minuto;

	str_hora = new String (hora);
	if (str_hora.length == 1) 
		hora = "0" + hora;
		
	horaImprimible =  hora + " : " + minuto + " : " + segundo;
	
	document.form_reloj.reloj.value = horaImprimible;
	
	setTimeout("mueveReloj()",1000);
}
</script>


</head>
<body onload="mueveReloj()">
<a href="bienvenido.jsp" target="contenido"><img alt="logo_irso" src="./img/logoirso.gif" syle="float:left;position:relative;"></a>
<div style="position:absolute;left:35%;top:10px"><h1 style="color:darkblue">Trabajo Práctico - Taller 5</h1></div>
<div style="position:absolute;top:20px;right:40px" >
<form  name="form_reloj">
<input type="text" name="reloj" size="30" style="background-color : Black; color : White; font-family : Verdana, Arial, Helvetica; font-size : 8pt; text-align : center;" onfocus="window.document.form_reloj.reloj.blur()">
</form>
</div> 

</body>

</html>