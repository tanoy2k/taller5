/*
 * simula la clase Materias
 * 
 */

//////////////////////////////////////////////////////////
var Materia = function(materiaJson) {// simulo el objeto en javascript

	// [{"materia":1,"anio":1,"descripcion":"ORGANIZACION
	// EMPRESARIAL","cuatrimestre":1}

	// por convenciòn hago referencia a traves de self a la instancia de mi
	// objeto.
	var self = this;
	// establezco las propiedades
	this.materiaId = materiaJson.materia;
	this.anio = materiaJson.anio;
	this.descripcion = materiaJson.descripcion;
	this.cuatrimestre = materiaJson.cuatrimestre;

	// establezco getters y setters
	this.setMateriaId = function(materiaId) {
		self.materiaId = materiaId;
	};
	this.getMateriaId = function() {
		return self.materiaId;
	};
	this.setAnio = function(anio) {
		self.anio = anio;
	};
	this.getAnio = function() {
		return self.anio;
	};
	this.setCuatrimestre = function(cuatrimestre) {
		self.cuatrimestre = cuatrimestre;
	};
	this.getCuatrimestre = function() {
		return self.cuatrimestre;
	};
	this.setMateriaDescripcion = function(descripcion) {
		self.descripcion = descripcion;
	};
	this.getMateriaDescripcion = function() {
		return self.descripcion;
	};
	this.setEstado = function(estado) {
		self.estado = estado;
	};
	this.getEstado = function() {
		return self.estado;
	};

	// Le doy conocimiento a mi alumno de còmo mostrarse en un row de una
	// tabla...
	this.getRow = function() {
		var rowHtml = '<tr><td>' + self.getAnio() 
					+ '</td><td>'
					+ self.getCuatrimestre() 
					+ '</td><td>'
					+ self.getMateriaDescripcion() 
					+ '</td><td>'
					+ self.getMateriaId() 
					+ '</td></tr>';
		return rowHtml;
	};
};

var Materias = function() {
	var self = this;// <-- por convencion
	this.materias = new Array(); // defino que contendr� una collection ( object materia )
	this.addMateria = function(materia) {
		self.materias.push(materia);
	};

	this.getMateriasCuatrimestre = function() {
		// defino la url al recurso que me entrega la data
		var url = 'getmaterias.htm'; // no hace falta poner localhost a fuego!
		// usando jquery traemos el json desde esa url
		$.getJSON(url, function(materiasJson) { // aca el controller me responde con un json

			// como bien dijo el profe Damiàn, usemos las convenciones y
			// estandares, pasamos la data json otra vez a obj:
			jQuery.each(materiasJson, function(pos, materia) {
				var miMateria = new Materia(materia); // instancio un objeto
														// de mi clase Materia
				self.addMateria(miMateria);
			}); // Fin JQuery.each

			// Luego de bajar la data JSON al 'objeto' js, le digo que se
			// muestre en una tabla mediante otro comportamiento de la misma
			// clase:
			self.mostrarEnTabla();
		});// Fin getJSON
	}; // end class

	// el siguiente comportamiento de la clase Alumnos, es mostrar su estado
	// actual en una tabla HTML:
	this.mostrarEnTabla = function() {
		// // Creo, en este caso la tabla como elem del DOM ( document object
		// model , estructura jerarquica del documento en el navegador web.)

		// primero blanqueo...
		$('#tablaMaterias').remove();
		var tbl = $("<table/>").attr("id", "tablaMaterias");
		var theadHtml = '<tr><th>Anio</th><th>Cuatrimestre</th><th>Descripcion</th><th>Estado</th></tr>';
		var thead = $('<thead/>').attr('class', 'tablaMateriasEncabezado');
		var tbody = $('<tbody/>').attr('class', 'tablaMateriasCuerpo');
		$("#contenedor").append(tbl);
		$('#tablaMaterias').append(thead);
		$('#tablaMaterias').append(tbody);
		$('#tablaMaterias').find('thead').append(theadHtml);
		$('#tablaMaterias').addClass("table table-striped");

		// usando jquery y su sintaxis recomendada por convencion, recorremos el
		// array de objetos Materia
		$.each(self.materias, function(i, materia) {
			$('#tablaMaterias').find('tbody').append(materia.getRow());
		}); // fin .each
	}; // fin mostrarEnTabla
}; // fin Materias

// clase de PRUEBA , solo para chequear el includeRequired() desde
// viewManager();
var MateriasManager = function(msg) {
	var self = this;
	this.mensaje = msg;
	alert(self.mensaje);
};
