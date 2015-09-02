package ejercicio2;

public class Rectangulo extends FiguraGeometrica{
	
	private int ancho;
	private int alto;

	public Rectangulo(int ancho, int alto,String color) {
		super(color);
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	@Override
	void dibujar() {
		System.out.println("Se dibuja un rectangulo de alto "+alto+", de ancho "+ancho+" y de color "+Color);
	}

	@Override
	float area() {
		return alto*ancho;
	}

	
}
