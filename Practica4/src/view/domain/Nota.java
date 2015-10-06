package view.domain;

public enum Nota {

	C("C"),
	D("D"),
	E("E"),
	F("F"),
	G("G"),
	A("A"),
	B("B");
	
	private String nota;

	
	private Nota(String nota){
		this.nota = nota;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	
}
