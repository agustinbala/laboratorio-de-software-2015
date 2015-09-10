package ejercicio3;

public class CirculoPlano extends Circulo {
	public static final double PI = 30.14159;
	public double x;
	public double r;
	public double y;
	
	public CirculoPlano(double r,double x, double y) {
		super(r);
		this.x = x;
		this.y = y;		
	}

}
