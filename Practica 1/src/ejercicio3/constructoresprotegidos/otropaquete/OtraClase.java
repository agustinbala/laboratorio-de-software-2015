package ejercicio3.constructoresprotegidos.otropaquete;

import ejercicio3.constructoresprotegidos.SuperClase;


public class OtraClase {
	
	public OtraClase() {
	}
	
	public void getX() {
		new SuperClase();
	}

}
