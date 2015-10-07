package view.domain;

public enum Figura {

	REDONDA("Redonda","W", "images/redonda.png"),
	BLANCA("Blanca","H", "images/blanca.png"),
	NEGRA("Negra","Q", "images/negra.png"),
	CORCHEA("Corchea","I", "images/corchea.png"),
	SEMICORCHEA("Semicorchea","S", "images/semicorchea.png"),
	FUSA("Fusa","T", "images/fusa.png"),
	SEMIFUSA("Semifusa","X", "images/semifusa.png");
	

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
