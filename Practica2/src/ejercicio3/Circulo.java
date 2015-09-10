package ejercicio3;

public class Circulo {

	public static final double PI = 3.14159;
	public double r;
	
	public Circulo(double r){this.r = r;}
	
	public double area(){
		return PI * this.r * this.r;
	}
}
