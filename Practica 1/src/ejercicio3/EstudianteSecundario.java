package ejercicio3;

import ejercicio1.Estudiante;

public class EstudianteSecundario extends Estudiante {

	private Integer materiasPrevias;
	private float promedio;
	
	public EstudianteSecundario(Integer materiasPrevias, float promedio,String nombre, String apellido, String legajo) {
		super(nombre, apellido, legajo);
		this.materiasPrevias = materiasPrevias;
		this.promedio = promedio;
	}

	public Integer getMateriasPrevias() {
		return materiasPrevias;
	}

	public void setMateriasPrevias(Integer materiasPrevias) {
		this.materiasPrevias = materiasPrevias;
	}

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	
}
