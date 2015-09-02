package ejercicio2;

public class Paint {

	private FiguraGeometrica[] paleta = new FiguraGeometrica[5];
	
	public Paint() {
		super();
	}

	public FiguraGeometrica[] getPaleta() {
		return paleta;
	}

	public void setPaleta(FiguraGeometrica[] paleta) {
		this.paleta = paleta;
	}
	
	public void init(){
		Circulo circulo1 =  new Circulo(22, "azul");
		Circulo circulo2 =  new Circulo(3, "amarillo");
		Rectangulo rectangulo1 = new Rectangulo(2,2212312, "verde");
		Rectangulo rectangulo2 = new Rectangulo(4, 1, "rojo");
		Rectangulo rectangulo3 = new Rectangulo(8, 1, "negro");
		paleta[0] = circulo1;
		paleta[1] = circulo2;
		paleta[2] = rectangulo1;
		paleta[3] = rectangulo2;
		paleta[4] = rectangulo3;
		
	}

}
