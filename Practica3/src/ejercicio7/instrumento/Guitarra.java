package ejercicio7.instrumento;

import ejercicio7.FrecuenciasDeLA;
import ejercicio7.Notas;

public class Guitarra implements InstrumentoMusical {

	@Override
	public void hacerSonar() {
		System.out.println("Suena Guitarra");		
	}

	@Override
	public String queEs() {
		return "Guitarra";
	}

	@Override
	public void afinar() {
		System.out.println("Afinando Guitarra");
	}

	@Override
	public void afinar(FrecuenciasDeLA f) {
		System.out.println("Afinando Guitarra con frecuencia "+f.getFrecuencia());		
	}

	@Override
	public void hacerSonar(Notas n, int duracion) {
		System.out.println("Suena Guitarra con nota "+n.getCodigo()+" durante "+duracion+ " segundos");
	}

}
