package ejercicio2.romano;

import ejercicio2.griego.Alpha;

public class Gamma {

	//Si esta en otro paquete, no ve los miembros de la instancia a menos que sean public
	void unM�todoG(){
		Alpha a = new Alpha();
		a.x=10;
		a.otroMedotoA();
	}
}
