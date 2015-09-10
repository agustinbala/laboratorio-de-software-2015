package ejercicio6;

public class PaintTest {

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.init();
		
		paint.getPaleta().
		
		for (FiguraGeometrica figuraGeometrica : paint.getPaleta()) {
			figuraGeometrica.area();			
			if(figuraGeometrica instanceof Circulo){
				System.out.println("Llamando al radio "+((Circulo) figuraGeometrica).getRadio());
			}
		}
	}

}
