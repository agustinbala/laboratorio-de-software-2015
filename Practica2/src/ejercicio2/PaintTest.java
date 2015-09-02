package ejercicio2;

import java.util.Arrays;

public class PaintTest {

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.init();
		
		Arrays.sort(paint.getPaleta());
		
		for (FiguraGeometrica figuraGeometrica : paint.getPaleta()) {
			System.out.println(figuraGeometrica.area());			
//			if(figuraGeometrica instanceof Circulo){
//				System.out.println("Llamando al radio "+((Circulo) figuraGeometrica).getRadio());
//			}
		}
	}

}
