package ejercicio7.test;

import ejercicio7.FrecuenciasDeLA;
import ejercicio7.Notas;
import ejercicio7.instrumento.Guitarra;

public class TestGuitarra {

	public static void main(String[] args) {
		Guitarra g = new Guitarra();
		g.afinar(FrecuenciasDeLA.BACH);
		g.hacerSonar(Notas.MI, 20);
	}

}
