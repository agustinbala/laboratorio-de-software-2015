package ejercicio2.griego;


public class Beta extends Alpha{

	//Si esta en el mismo paquete, a menos que este privado puede acceder
	//A menos que este private, puede heredar el método
	void unMetodoB(Alpha a){
		a.x=10;
		a.otroMetodoA();	
		otroMetodoA();
	}
}
