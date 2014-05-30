package ar.com.twitter.model;

public  class InscripcionFinal implements InterfaceInscripcion{
	private boolean materiaHabilitada;

	public boolean inscribir(int alumnoDni){
		if (alumnoDni  > 0){
			materiaHabilitada = true;
		}else{
			materiaHabilitada = false;
		}
		return materiaHabilitada;
		
	}
}
