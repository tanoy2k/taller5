<html>
<head>
<title>Ejemplo en Google Charts</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.load("visualization", "1", {packages:["corechart"]});
google.setOnLoadCallback(drawChart);
function drawChart() {
var data = google.visualization.arrayToDataTable([
['Cuatrimestre', 'Cursadas', 'Finales'],
['1er',  6,      4],
['2do',  7,      9],
['3ro',  8,       10],
['5to',  6,      8],
['6to',  5,      9]
]);
 
var options = {
title: 'Promedio de cursadas y finales por cuatrimetre',
hAxis: {title: 'Cuatrimetre', titleTextStyle: {color: 'red'}}
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