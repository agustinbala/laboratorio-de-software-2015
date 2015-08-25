package ejercicio3.constructoresprivados;

import java.awt.Dialog;
import java.awt.Frame;

public class Dialoguito extends Dialog {
	
	public Dialoguito() {
		super(new Frame());
		System.out.println("Dialoguito") ;
	}	
}