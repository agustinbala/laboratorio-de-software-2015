package ejercicio7.test;

import java.util.EnumMap;

import ejercicio7.Musico;
import ejercicio7.Notas;

public class TestMusico {

	public static void main(String[] args) {
		
		EnumMap<Notas, Integer> cancion = new EnumMap<Notas, Integer>(Notas.class);
		cancion.put(Notas.DO, 10);
		cancion.put(Notas.RE, 5);
		cancion.put(Notas.FA, 22);
		Musico.CHARLY_GARCIA.tocar(cancion);
	}

}
