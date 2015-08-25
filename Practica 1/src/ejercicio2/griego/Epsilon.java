package ejercicio2.griego;

public class Epsilon {

	//Si esta en el mismo paquete, a menos que este privado puede acceder
	//Como no hereda de Alpha, no puede ver el método
	void unMetodoB(Alpha a){
		a.x=10;
		a.otroMetodoA();	
	}
}
