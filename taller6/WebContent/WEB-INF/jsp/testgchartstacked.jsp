<script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <!-- ...Incluyo framework jQuery -->
        <script type="text/javascript" src="./jquery-1.10.2.js"></script>
<script type="text/javascript">
  google.load("visualization", "1", {packages:["corechart"]});
 
  var dataSet = [
        ['year', 'foo', 'bar', 'rest'],
        ['1900', 20, 10, 20],
        ['2000', 20, 30, 10],
        ['2100', 20, 10, 10]
        ];

  // The first chart

  google.setOnLoadCallback(drawChart1); 
  function drawChart1() {
	  
  	// defino la url al recurso que me entrega la data
  	var url = 'chartdata.htm'; // no hace falta poner localhost a fuego!
  	// usando jquery traemos el json desde esa url
  	$.getJSON(url , function(dataSet){ 
  		
  		console.log(JSON.stringify(dataSet));
  		
  	    var data = new google.visualization.DataTable( dataSet );

  	    var options = {
  	      title: 'Stacked histogram\nTotals',
  	      vAxis: {title: 'total', maxValue: 100},  // sets the maximum value
  	      backgroundColor: {strokeWidth: 2 },  // to draw a nice box all around the chart
  	      isStacked: 'true'                    //  = rowstacked in gnuplot
  	    };

  	    var chart = new google.visualization.ColumnChart(document.getElementById('chart_div1'));
  	    chart.draw(data, options);
	  
  	});
  }

  // The second chart

  var dataSet2    = dataSet;
  google.setOnLoadCallback(drawChart2);
  function drawChart2() {
    // Calculate the percentages
    var sum = new Array();
    for(row=1; row<dataSet.length; row++) {
      sum[row]        = 0;
      for(col=1; col<dataSet[row].length; col++) {
        sum[row]        += dataSet[row][col];
      }
      for(col=1; col<dataSet[row].length; col++) {
        dataSet2[row][col]      = 100*dataSet[row][col]/sum[row];
      }
    }

    var data = google.visualization.arrayToDataTable(dataSet2);

    var options = {
      title: 'Stacked histogram\n% Totals',
      vAxis: {title: 'total', maxValue: 100},  // sets the maximum value
      backgroundColor: {strokeWidth: 2 },  // to draw a nice box all around the chart
      isStacked: 'true'                    //  = rowstacked in gnuplot
    };

    var chart = new   google.visualization.ColumnChart(document.getElementById('chart_div2'));
    chart.draw(data, options);
  }
</script>

<div style="display: table;">
  <div style="display: table-row">
    <div id="chart_div1" style="width: 300px; height: 300px; display: table-cell;"></div>
    <div id="chart_div2" style="width: 300px; height: 300px; display: table-cell;"></div>
  </div>
</div>