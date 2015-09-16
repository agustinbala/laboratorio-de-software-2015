package ejercicio7;

public enum FrecuenciasDeLA {

	  ISO_16("440 Hz"),
	  AFINACION_CAMARA("444 Hz"),
	  RENACIMIENTO ("446 Hz"),
	  BACH("480 Hz");
	  
	 private String frecuencia;
	 
	 FrecuenciasDeLA(String frecuencia) {
		this.frecuencia = frecuencia;
	}
	 
	 public String getFrecuencia(){
		 return this.frecuencia;
	 }
}
