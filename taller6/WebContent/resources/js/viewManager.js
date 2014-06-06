$(document).ready(function() {
	var viewManager = new ViewManager;
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
		    console.log( 'Cargando '+ scriptJs +': ' + textStatus );
		  });
	};
	this.init = function(){
		self.includeRequired('resources/js/alumnos.js');
		self.includeRequired('resources/js/materias.js');
		self.includeRequired('resources/js/finales.js');
		self.mostrarInicio();
	};
	// limpia el contenido de la vista
	this.limpiar 	= function(){
						$('#contenedor').html('');
				   	};	
	// mostrar inicio			   	
	this.mostrarInicio = function()
	{
		// agrego un botón, a modo de pruebas, que tenga el action 'listarMaterias'
		var btnGetMaterias = $('<button/>')
				 			.attr('type','button')
				 			.attr('id','getMaterias')
				 			.text('Listar todas las materias')					 			
				 			.addClass('btn btn-primary btn-lg btn-block')					 			
				 			.click(function(){
								self.listarMaterias();
				 			});
		$(self.acciones).append(btnGetMaterias);
		
		// agrego un botón, a modo de pruebas, que tenga el action 'listarMaterias'
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
			 						    	console.log(' logout: '+JSON.stringify(data));
			 						    }
			 			    );
			 			});
		$(self.acciones).append(btnLogout);									
	}; // mostrar inicio	
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



