package ejercicio7;

public enum Notas {

	
   DO("C"),
   RE("D"),
   MI("E"),
   FA("F"),
   SOL("G"),
   LA("A"),
   SI("B");
   
   private String codigo;
   
   Notas(String codigo){
	   this.codigo = codigo;
   }
   
   public String getCodigo(){
	   return this.codigo;
   }
}
