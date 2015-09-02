package ejercicio1.b;

public class InstrumentoDeCuerda implements InstrumentoMusical {
	public void hacerSonar(){
		 System.out.println("Sonar Cuerdas");
	}

	public String queEs() {
		 return "Instrumento de Cuerda";
	}

	@Override
	public void afinar() {
		// TODO Auto-generated method stub
		
	}
}