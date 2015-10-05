package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application {
	
	static String figura = "";
	static String nota = "";

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Contenedor de Alto nivel");
		frame.setSize(950, 450);
		
		
		Container cont=frame.getContentPane();
		JComponent contentpane=(JComponent) cont;
		frame.getContentPane().setLayout(new GridLayout(1, 2));
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7, 1));
		
		panel1.add(createPanel("Redonda","images/redonda.png"));
		panel1.add(createPanel("Blanca","images/blanca.png"));
		panel1.add(createPanel("Negra","images/negra.png"));
		panel1.add(createPanel("Corchea","images/corchea.png"));
		panel1.add(createPanel("Semicorchea","images/semicorchea.png"));
		panel1.add(createPanel("Fusa","images/fusa.png"));
		panel1.add(createPanel("Semifusa","images/semifusa.png"));
		
		
	
		
		contentpane.add(panel1);
		
		
		JPanelWithBackground panelImagen = new JPanelWithBackground("images/penta.png");
		panelImagen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Coordenadas "+arg0.getX()+" "+arg0.getY());
				
				if(arg0.getX() >= 100 && arg0.getX() <= 140 && arg0.getY() >= 310 && arg0.getY() <= 280){
					nota = "C";
				}else{
					if(arg0.getX() >= 140 && arg0.getX() <= 180 && arg0.getY() >= 280 && arg0.getY() <= 250){
						nota = "D";
					}
					else{
						if(arg0.getX() >= 180 && arg0.getX() <= 220 && arg0.getY() >= 250 && arg0.getY() <= 220){
							nota = "E";
						}
						else{
							if(arg0.getX() >= 220 && arg0.getX() <= 260 && arg0.getY() >= 220 && arg0.getY() <= 190){
								nota = "F";
							}
							else{
								if(arg0.getX() >= 260 && arg0.getX() <= 300  && arg0.getY() >= 190 && arg0.getY() <= 160){
									nota = "G";
								}
								else{
									if(arg0.getX() >= 300 && arg0.getX() <= 340 && arg0.getY() >= 160 && arg0.getY() <= 130){
										nota = "A";
									}else{
										if(arg0.getX() >= 340 && arg0.getX() <= 380 && arg0.getY() >= 130 && arg0.getY() <= 100){
											nota = "B";
										}
									}
								}
							}
						}
					}
				}
			}
		});
		contentpane.add(panelImagen);
		

		frame.show();

	}
	
	private static JPanel createPanel(final String titulo, String imagePath) throws IOException{
		JPanel panel =  new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(new Label(titulo));
		panel.add(new Label("------------------------->"));
		
		JPanelWithBackground panelImagen = new JPanelWithBackground(imagePath);
		panelImagen.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("La figura elegida es "+titulo);
				figura =  titulo;
			}
		});
		panel.add(panelImagen);
		
		return panel;
	}
	
}
