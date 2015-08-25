package ejercicio2.romano;

import ejercicio2.griego.*;

public class Delta extends Alpha {
	
	//Si esta en otro paquete, aunque herede, no ve los miembros de la instancia. Solo public
	//Si esta como protected, si puede heredar el método
	void unMetodoD(Alpha a, Delta d){
		a.x=10;
		a.otroMetodoA();
		otroMetodoA();
		
	}
}
