package ar.com.twitter.model;

public  class InscripcionFinal implements InterfaceInscripcion{
	private boolean materiaHabilitada;

	public boolean validarMateria(int alumnoDni){
		if (alumnoDni  > 0){
			materiaHabilitada = true;
		}else{
			materiaHabilitada = false;
		}
		return materiaHabilitada;
		
	}
}
