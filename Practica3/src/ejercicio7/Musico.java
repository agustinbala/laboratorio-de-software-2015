package ejercicio7;

import java.util.EnumMap;
import java.util.List;

import ejercicio7.instrumento.Guitarra;
import ejercicio7.instrumento.InstrumentoMusical;

public enum Musico {

	CHARLY_GARCIA("Charly Garcia", new Guitarra());
	
	private InstrumentoMusical instrumento;
	private String nombre;
	
	Musico(String nombre, InstrumentoMusical instrumento){
		this.nombre = nombre;
        this.instrumento = instrumento;
	}
	
	public void tocar(EnumMap<Notas, Integer> cancion){
		System.out.println(nombre + " va a tocar....");
		for (Notas n: cancion.keySet()){
			instrumento.hacerSonar(n, cancion.get(n));
		}
	}
}
