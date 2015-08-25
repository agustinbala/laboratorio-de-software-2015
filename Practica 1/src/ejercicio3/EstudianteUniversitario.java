package ejercicio3;

import java.util.Date;

import ejercicio1.Estudiante;

public class EstudianteUniversitario extends Estudiante {

	private Date ingreso;
	
	public EstudianteUniversitario(Date ingreso, String nombre, String apellido, String legajo) {
		super(nombre, apellido, legajo);
		this.ingreso = ingreso;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	
}
