<html>
<head>
<title>Tutorial Monsters: Ejemplo en Google Charts</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
var data = google.visualization.arrayToDataTable([
['Año', 'Ventas', 'Gastos'],
['2004',  1000,      400],
['2005',  1170,      460],
['2006',  660,       1120],
['2007',  1030,      540]
]);
 
var options = {
title: 'Informe de Ventas/Gastos',
hAxis: {title: 'Años', titleTextStyle: {color: 'red'}}
};
 
var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
chart.draw(data, options);
}
</script>
</head>
<body>
<div id="chart_div" style="width: 900px; height: 500px;"></div>
<div style="padding-top:15px"><a href="http://www.tutorialmonsters.com/google-charts-graficas-en-tu-web/" title="Google Charts">www.tutorialmonsters.com</a></div>
</body>
</html>