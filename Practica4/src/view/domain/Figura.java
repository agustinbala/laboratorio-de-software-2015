package view.domain;

public enum Figura {

	REDONDA("Redonda", "images/redonda.png"),
	BLANCA("Blanca", "images/blanca.png"),
	NEGRA("Negra", "images/negra.png"),
	CORCHEA("Corchea", "images/corchea.png"),
	SEMICORCHEA("Semicorchea", "images/semicorchea.png"),
	FUSA("Fusa", "images/fusa.png"),
	SEMIFUSA("Semifusa", "images/semifusa.png");
	

	private String descripcion;
	private String imagen;
	
	private Figura(String descripcion, String imagen){
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
