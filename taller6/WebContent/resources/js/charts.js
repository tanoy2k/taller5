/*
 * simula la clase Charts
 * 
 */

var Chart = function(chartJson){// simulo el objeto en javascript
	
//	private int cuatrimestreOrden;
//	private int aprobadosCant;
//	private int ausentesCant;
//	private int desaprobadosCant;
//	public int getAprobados() {

	// por convenciòn hago referencia a traves de self a la instancia de mi objeto.
	var self = this;
	// establezco las propiedades
	this.cuatrimestreOrden = chartJson.cuatrimestreOrden;
	this.aprobadosCant = chartJson.aprobadosCant;
	this.ausentesCant = chartJson.ausentesCant;
	this.DesaprobadosCant = chartJson.desaprobadosCant;
	// establezco getters y setters
	this.setCuatrimestreOrden = function(pCuatrimestreOrden)
	{
		self.cuatrimestreOrden = pCuatrimestreOrden;
	};
	this.getCuatrimestreOrden = function()
	{
		return self.cuatrimestreOrden;
	};
	this.setAprobadosCant = function(pAprobadosCant)
	{
		self.aprobadosCant = pAprobadosCant;
	};
	this.getAprobadosCant = function()
	{
		return self.aprobadosCant;
	};	
	this.setAusentesCant = function(pAusentesCant)
	{
		self.ausentesCant = pAusentesCant;
	};
	this.getAusentesCant = function()
	{
		return self.ausentesCant;
	};
	this.setDesaprobadosCant = function(pDesaprobadosCant)
	{
		self.desaprobadosCant = pDesaprobadosCant;
	};	
	this.getDesaprobadosCant = function(){
		return self.desaprobadosCant;
	};
};	
	
	
////accedo a prototype(metodo de clase ,estatico)
//Alumnos.prototype.addAlumno = function(alumno){ 
//	console.log("Alumnos.prototype.addAlumnos: " + alumno);
//    this.alumnos.push(alumno); //<-- "mete" al objeto alumno que viene como parm a la lista    
//}; 

var Charts = function(){
	var self = this;// <-- por convencion
	this.charts = new Array(); // defino que contendrá una collection ( object chart, en este caso )
	this.addChart = function(chart){
		self.charts.push(chart);
		console.log('miarray: ' +  JSON.stringify(self.charts) );
	};
		
this.getStats = function(){
	console.log('drawgrafica');
	//$('ajaxLoader').show();
  	var urlChartStats = 'chartdata.htm'; // no hace falta poner localhost a fuego!, uri relativa
  	// usando jquery traemos el json desde esa url
  	$.getJSON(urlChartStats , function(chartData){ 	  		 
  		console.log(JSON.stringify(chartData));// ojo con console.log , si el navegador no soporta la fnc, doy soporte ò hago q se continue con la ejecucion, o con utilitarios q la implementen en los navegadores q no la soportan
		// como bien dijo el profe Damián, usemos las convenciones y estándares, pasamos la data json otra vez a un objeto simulado en la vista con javascript:
		jQuery.each(chartData, function(pos, chart){
			var miChart = new Chart(chart); // instancio un objeto de mi clase , èsta ya "nace" con la data del item
			//console.log('soy un item del chart: ' + JSON.stringify(miChart) );
			self.addChart( miChart ); // collection de object... 
		});  //Fin JQuery.each
		
		console.log('miarray FINAL: ' +  JSON.stringify(self.charts) );
		
	  	// Luego de bajar la data JSON al 'objeto' js, le digo que se muestre en una tabla mediante otro comportamiento de la misma clase:
		//self.mostrarEnTablaGchart();
		

		var data = new google.visualization.DataTable( self.charts);
		// encabezado
		data.addColumn('string','cuatrimestre');
		data.addColumn('number','aprob');
		data.addColumn('number','desa');
		data.addColumn('number','ause');
		// data json, no uso jQuery para mantener el ejemplito...cuestión de tiempo, vio?
		for (var i = 0; i < chartData.length; i++) {
			data.addRow(['orden: ' + chartData[i].cuatrimestreOrden, chartData[i].aprobadosCant, chartData[i].desaprobadosCant,chartData[i].ausentesCant]);
		};
	
		//			jQuery.each(chartData, function(chart, chartData){
		//		        data.addRow(['orden: ' + dataSet[i].cuatrimestreOrden, dataSet[i].aprobadosCant, dataSet[i].desaprobadosCant,dataSet[i].ausentesCant]);
		//		    });  //Fin JQuery.each
		
		var options = {
			  title: 'Cantidad de Aprobadas, Desaprobadas y ausentes por cuatrimestre\nTotals',
			  vAxis: {title: 'total', maxValue: 100},
			  hAxis: {title: 'cuatrimestre orden'},// sets the maximum value
			  backgroundColor: {strokeWidth: 2 },  // to draw a nice box all around the chart
			  isStacked: 'true'                    //  = rowstacked in gnuplot
			};
	      
		var chart = new google.visualization.ColumnChart(window.top.document.getElementById("chart_div")); //
		//$('ajaxLoader').hide();
		chart.draw(data, options);
    });
		
};	
	
};	// fin Charts

