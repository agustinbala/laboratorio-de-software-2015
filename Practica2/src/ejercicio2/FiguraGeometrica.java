package ejercicio2;

public abstract class FiguraGeometrica implements Comparable<FiguraGeometrica>{

	protected String Color;
	
	public FiguraGeometrica(String color){
		super();
		this.Color = color;
	}
	
	abstract void dibujar();
	
	abstract float area();
	
	public void setColor(String color){
		this.Color = color;
	}
	
	public String getColor(){
		return Color;
	}
	

	@Override
	public int compareTo(FiguraGeometrica o) {
		if(o== null){
			return 1;
		}else{
			if(this.area() == o.area()){
				return 0;
			}else{
				if(this.area() < o.area()){
					return -1;
				}
				else{
					return 1;
				}
			}
		}
		
	}
}
