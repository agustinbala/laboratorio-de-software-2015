package ejercicio3;

import ejercicio1.Estudiante;

public class EstudiantePrimario extends Estudiante {

	private Integer ausencias;
	private Boolean repitio;
	
	public EstudiantePrimario(Integer ausencias, Boolean repitio, String nombre, String apellido, String legajo) {
		super(nombre, apellido, legajo);
		this.ausencias = ausencias;
		this.repitio = repitio;
	}

	public Integer getAusencias() {
		return ausencias;
	}

	public void setAusencias(Integer ausencias) {
		this.ausencias = ausencias;
	}

	public Boolean getRepitio() {
		return repitio;
	}

	public void setRepitio(Boolean repitio) {
		this.repitio = repitio;
	}

	
	
}
