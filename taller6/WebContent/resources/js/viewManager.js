$(document).ready(function() {
	window.viewManager = new ViewManager;
	viewManager.init();
});



var ViewManager = function(ambito){
	var self = this;
	this.contenido 	= $('#contenedor') ; // con esta prop donde poner el contenido
	this.acciones 	= $('#cabecera');
	// incluir scripts requeridos
	this.includeRequired = function(scriptJs){
		$.getScript( scriptJs )
		  .done(function( script, textStatus ) {
			// join es mas performante que concatenar stings, recordar q un string es un arreglo de chars.. (?)  
		    console.log( ['Cargando: ', scriptJs, textStatus].join(' ') );
		  });
	};
	this.init = function(){ 
		self.includeRequired('resources/js/alumnos.js');
		self.includeRequired('resources/js/materias.js');
		self.includeRequired('resources/js/finales.js');
		self.includeRequired('resources/js/charts.js'); 
		

		// inicializo app
		self.mostrarInicio();
	};
	

	this.tableize =  "";	
	this.configTableize = function(thead,id){
		//alert(["viewManger dice..tableize!: ", thead ].join("") );
		// tablizar?...ponele
	    self.tableize = ["<table id='", id ,"'class='table table-striped'><thead>",thead,"</thead><tbody></tbody></table>"].join("");
	};
	
	
	// limpia el contenido de la vista
	this.limpiar 	= function(){
						$('#contenedor').html('');
				   	};	
    // view manager hace las cosas de la pantalla, 
    // y bajo consejo de Dami�n, crea un boton generic
    this.makeButtonGeneric = ['<button type="button" id="generic" class="btn btn-info btn-sm">Generic Enroll</button>'].join(""); 				   	

    // mostrar inicio			   	
	this.mostrarInicio = function()
	{

		
		// agrego un botón, a modo de pruebas, que tenga el action 'listarMaterias'... 
		var btnGetMaterias = $('<button/>')
				 			.attr('type','button')
				 			.attr('id','getMaterias')
				 			.text('Listar todas las materias')					 			
				 			.addClass('btn btn-primary btn-lg btn-block')					 			
				 			.click(function(){
								self.listarMaterias();
				 			});
		$(self.acciones).append(btnGetMaterias);
		
		// agrego un botón, a modo de pruebas, que tenga el action 'listarMaterias'.... 
		var btnGetAlumnos = $('<button/>')
				 			.attr('type','button')
				 			.attr('id','getAlumnos')
				 			.text('Listar todos los alumnos')					 			
				 			.addClass('btn btn-primary btn-lg btn-block')					 			
				 			.click(function(){
								self.listarAlumnos();
				 			});
		$(self.acciones).append(btnGetAlumnos);
		
		// agrego un botón, a modo de pruebas, que tenga el action 'logout'
		var btnFinales = $('<button/>')
			 			.attr('type','button')
			 			.attr('id','finales')
			 			.text('Inscribir a Finales')
			 			.addClass('btn btn-primary btn-lg btn-block')
			 			.click(function(){
							self.listarFinales();
			 			});
		$(self.acciones).append(btnFinales);		
				
		// agrego un botón, a modo de pruebas, que tenga el action 'logout'
		var btnLogout = $('<button/>')
			 			.attr('type','button')
			 			.attr('id','logout')
			 			.text('Salir de la aplicaci\u00F3n')
			 			.addClass('btn btn-primary btn-lg btn-block')
			 			.click(function(){
			 				$.getJSON('logout.htm', 
			 							function(data){
			 						    	console.log(' logout: '+JSON.stringify(data)); // x debug en chrome unicamente, quitar
			 						    	alert(data.msg);
			 						    	window.top.location.href = data.redirect;
			 						    }
			 			    );
			 			});
		$(self.acciones).append(btnLogout);
		
		// agrego un botón, a modo de pruebas, que tenga el action 'showStats()'
		var btnStats = $('<button/>')
			 			.attr('type','button')
			 			.attr('id','logout')
			 			.text('Mostrar Estad�sticas')
			 			.addClass('btn btn-primary btn-lg btn-block')
			 			.click(function(){
			 				self.mostrarEstadisticas();
			 			});
		$(self.acciones).append(btnStats);		
		
	}; // mostrar inicio	

	
this.drawChart = function() {

//	var data = google.visualization.arrayToDataTable([
//	['Cuatrimestre', 'Cursadas', 'Finales'],
//	['1er',  6,      4],
//	['2do',  7,      9],
//	['3ro',  8,       10],
//	['5to',  6,      8],
//	['6to',  5,      9]
//	]);
//	 
//	var options = {
//	title: 'Promedio de cursadas y finales por cuatrimetre',
//	hAxis: {title: 'Cuatrimetre', titleTextStyle: {color: 'red'}}
//	};
//	 
//	var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
//	chart.draw(data, options);
	var charts = new Charts();
	charts.getStats();
			  	
}; 		
	
	
	
	this.mostrarEstadisticas = function(){
		self.limpiar();
//		var myCharts = new Charts();
//		myCharts.showStats();
		
//		google.load("visualization", "1", {packages:["corechart"], callback:drawChart});
		
		google.load("visualization", "1", {packages:["corechart"], callback:this.drawChart});		
		
	};
	this.listarFinales = function(){
		self.limpiar();
		var misFinales = new Finales();
		misFinales.getTodosLosFinales();
	};
	this.listarMaterias = function(){
		self.limpiar();
		// instancio el objeto mis alumnos, que contendr� una coleccion de �stos...
		var misMaterias = new Materias();			
		misMaterias.getMateriasCuatrimestre();		
	};
	this.listarAlumnos = function(){
		self.limpiar();
		// instancio el objeto mis alumnos, que contendrà una coleccion de èstos...
		var misAlumnos = new Alumnos();			
		misAlumnos.getTodosLosAlumnos(); //<-- este lo puedo pasar al constructor...cuando lo instancio, q se liste
		//misAlumnos.listarAlumnosJson();
	};
};



