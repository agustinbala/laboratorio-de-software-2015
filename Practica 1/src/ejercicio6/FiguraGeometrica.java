package ejercicio6;

public abstract class FiguraGeometrica {

	protected String Color;
	
	public FiguraGeometrica(String color){
		super();
		this.Color = color;
	}
	
	abstract void dibujar();
	
	abstract void area();
	
	public void setColor(String color){
		this.Color = color;
	}
	
	public String getColor(){
		return Color;
	}
	
}
