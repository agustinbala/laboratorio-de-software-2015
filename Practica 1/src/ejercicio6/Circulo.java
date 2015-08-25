package ejercicio6;

public class Circulo extends FiguraGeometrica {

	private int radio;
	
	public Circulo(int radio, String color) {
		super(color);
		this.radio = radio;
	}


	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	void dibujar() {
		System.out.println("Se dibuja un circulo de radio "+radio+" y de color "+Color);
	}

	@Override
	void area() {
		System.out.println("Area Circulo");
	}

}
