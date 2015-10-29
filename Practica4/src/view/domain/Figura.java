package view.domain;

public enum Figura {

	REDONDA("Redonda","/1", "/images/redonda.png"),
	BLANCA("Blanca","/0.5", "/images/blanca.png"),
	NEGRA("Negra","/0.25", "/images/negra.png"),
	CORCHEA("Corchea","/0.125", "/images/corchea.png"),
	SEMICORCHEA("Semicorchea","/0.0625", "/images/semicorchea.png"),
	FUSA("Fusa","/0.03125", "/images/fusa.png"),
	SEMIFUSA("Semifusa","/0.015625", "/images/semifusa.png");
	

	private String descripcion;
	private String imagen;
	private String nombre;
	
	private Figura(String nombre, String descripcion, String imagen){
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
