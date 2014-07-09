<script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <!-- ...Incluyo framework jQuery -->
        <script type="text/javascript" src="./jquery-1.10.2.js"></script>
<script type="text/javascript">
  google.load("visualization", "1", {packages:["corechart"]});
  google.load("visualization", "1", {packages:["table"]});
    // The first chart

  google.setOnLoadCallback(drawChart1); 
  function drawChart1() {
	  
  	// defino la url al recurso que me entrega la data
  	var url = 'chartdata.htm'; // no hace falta poner localhost a fuego!
  	// usando jquery traemos el json desde esa url
  	$.getJSON(url , function(dataSet){ 
  		
  		console.log(JSON.stringify(dataSet));
  		
  	    var data = new google.visualization.DataTable( dataSet );

  	    data.addColumn('string','cuatrimestre');
  	  data.addColumn('number','aprob');
  	data.addColumn('number','desa');
  	data.addColumn('number','ause');

    for (var i = 0; i < dataSet.length; i++) {
        data.addRow(['orden: ' + dataSet[i].cuatrimestreOrden, dataSet[i].aprobadosCant, dataSet[i].desaprobadosCant,dataSet[i].ausentesCant]);
    }
  	
  	    var options = {
  	      title: 'Cantidad de Aprobadas, Desaprobadas y ausentes por cuatrimestre\nTotals',
  	      vAxis: {title: 'total', maxValue: 100},
  	      hAxis: {title: 'cuatrimestre orden'},// sets the maximum value
  	      backgroundColor: {strokeWidth: 2 },  // to draw a nice box all around the chart
  	      isStacked: 'true'                    //  = rowstacked in gnuplot
  	    };

  	    var chart = new google.visualization.ColumnChart(document.getElementById('chart_div1'));
  	    chart.draw(data, options);
	    
  	    var visualization = new google.visualization.Table(document.getElementById('table'));
  	    visualization.draw(data,null);
  	});
  }

  
</script>

<div style="display: table;">
  <div style="display: table-row">
    <div id="chart_div1" style="width: 100%; height: 100%; display: table-cell;"></div>
    <div id="table" style="width: 300px; height: 300px; display: table-cell;"></div>
  </div>
</div>