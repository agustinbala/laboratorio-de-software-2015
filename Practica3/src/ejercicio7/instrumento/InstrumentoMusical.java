package ejercicio7.instrumento;

import ejercicio7.FrecuenciasDeLA;
import ejercicio7.Notas;

public interface InstrumentoMusical {
	
	 void hacerSonar();
	 String queEs();
	 void afinar();
	 void afinar(FrecuenciasDeLA f);
	 void hacerSonar(Notas n, int duracion);
}
