/*
 * simula la clase Finales
 * 
 */

/*[{"finalId":1,
 *  "materiaId":1,
 *  "materiaDescripcion":"ORGANIZACION EMPRESARIAL",
 *  "fecha":"jul 26, 2014",
 *  "profesores":
 *    [{"legajo":0,
 *      "titulo":"DOCTOR",
 *      "nombre":"PROFESOR",
 *      "apellido":"UNO"
 *    }],
 *  "llamado":1
 *}]*/


var Final = function(finalJson){// simulo el objeto en javascript
	// por convenciòn hago referencia a traves de self a la instancia de mi objeto.
	var self = this;
	// establezco las propiedades
	this.finalId = finalJson.finalId;
	this.llamadoId = finalJson.llamado;
	this.materiaId = finalJson.materiaId;
	this.materiaDescripcion = finalJson.materiaDescripcion;	
	this.fecha = finalJson.fecha;
	this.profesores = finalJson.profesores;
	// establezco getters y setters
	this.getFinalId = function()
	{
		return self.finalId;
	};	
	this.getMateriaId = function(){
		return self.materiaId;
	};
	this.getLlamadoId = function(){
		return self.llamadoId;
	};
	this.getFechaFinal = function(){
		return self.fecha;
	};
	this.getMateriaDescripcion = function(){
		return self.materiaDescripcion;
	};
	this.getProfesoresDeLaMesa = function(){
		var profesoresDeLaMesa = new Array();
		$.each(self.profesores,function(i,profesor){
			profesoresDeLaMesa.push(profesor.apellido + ", " + profesor.nombre + "; ");
		});
		return profesoresDeLaMesa;
	};
	// agrego un botón, a modo de pruebas, que tenga el action 'inscribir'
	this.enrollButton = function(id){
		var myEnrollButton = $('<button/>')
							.attr('type','button')
							.attr('id',id)
							.text('Inscribir a final')
							.addClass('btn')
							.click(function(){
								$.getJSON('inscribirfinal.htm?matid='+ self.getMateriaId() +'&finid='+self.getFinalId()+'&llamid='+self.getLlamadoId(), //<--pruebaaaaa 
											function(data){
										    	console.log(' inscribirFinal: '+JSON.stringify(data));
										    }
							    );
							});
		return $(myEnrollButton);
	};
		
	// Le doy conocimiento a mi final de còmo mostrarse en un row de una tabla...
	this.getRow = function(){
       	var rowHtml = $('<tr><td>'
       		        + self.getFechaFinal() 
       		        +'</td><td>'
       		        + self.getMateriaDescripcion()
       		        +'</td><td>'
       		        + self.getProfesoresDeLaMesa()
       		        + '</td><td class="action">'
       		        +'</td></tr>');
       	//Agrego un botòn con la accion Inscribir
       	var rowId = "enrollButton_" + self.finalId + "_" + self.llamadoId;
       	$(rowHtml).find(".action")
       	          .append( self.enrollButton(rowId) );
       	return rowHtml;
	};	
};

var Finales = function(){
	var self = this;// <-- por convencion
	this.finales = new Array(); // defino que contendr� una collection ( object alumno )
	this.addFinal = function(ffinal){
		self.finales.push(ffinal);
	};
	
    this.getTodosLosFinales = function(){ 
    	// defino la url al recurso que me entrega la data
    	var url = 'finales.htm'; // no hace falta poner localhost a fuego!
    	// usando jquery traemos el json desde esa url
    	$.getJSON(url , function(finalesJson){ // aca el controller me responde con un json
    		
    		// como bien dijo el profe Dami�n, usemos las convenciones y estandares, pasamos la data json otra vez a obj:
    		jQuery.each(finalesJson, function(pos, ffinal){
    			var unFinal = new Final(ffinal); // instancio un objeto de mi clase alumno, èste ya "nace" con la data del item
    			self.addFinal( unFinal );
    		});  //Fin JQuery.each
    		
    		// Luego de bajar la data JSON al 'objeto' js, le digo que se muestre en una tabla mediante otro comportamiento de la misma clase:
    		self.mostrarEnTabla();
    	});// Fin getJSON	    	
    }; // end class
	

	// el siguiente comportamiento de la clase Finales, es mostrar su estado actual en una tabla HTML:
	this.mostrarEnTabla = function(){
//		// Creo, en este caso la tabla como elem del DOM ( document object model , estructura jerarquica del documento en el navegador web.)
		
		$('#tablaFinales').remove();
		var tbl = $("<table/>").attr("id","tablaFinales");
		var theadHtml = '<tr><th>Fecha</th><th>Materia</th><th>Profesores de la mesa</th><th>Acciones</th></tr>';		
		var thead = $('<thead/>').attr('class','tablaFinalesEncabezado');
		var tbody = $('<tbody/>').attr('class','tablaFinalesCuerpo');
		$("#contenedor").append(tbl);		
		$('#tablaFinales').append(thead);
		$('#tablaFinales').append(tbody);
		$('#tablaFinales').find('thead').append(theadHtml);
		$('#tablaFinales').addClass("table table-striped");
		
		// usando jquery y su sintaxis recomendada por convencion, recorremos el array de objetos Alumno
	    $.each(self.finales, function(i,ffinal){
	    	// apoyandonos en el framework twitter bootstrap, dibujamos la tabla en la vista:                
	       	$('#tablaFinales').find('tbody').append(ffinal.getRow());	       	
        }); // fin .each
	}; // fin mostrarEnTabla
	
	// la siguiente funcion es solo a modo de debug en la consola de chrome
	this.listarFinales = function(){
		console.log( "getFinalesTodos(): "+  JSON.stringify(this.finales ) ); // ojo con console.log, en viejos navegadores no funciona 
	};
	
};	// fin Finales


////accedo a prototype(metodo de clase ,estatico)
//Finales.prototype.addAlumno = function(alumno){ 
//	console.log("Finales.prototype.addFinales: " + alumno);
//    this.finales.push(ffinal); //<-- "mete" al objeto alumno que viene como parm a la lista    
//}; 


//una generica solo por PRUEBAAAAAAAAAAAAA!
var FinalesManager = function(msg){
	var self = this;
	this.mensaje = msg;
	alert(self.mensaje);	
	$("#contenedor").html(msg);	
};