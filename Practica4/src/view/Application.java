package view;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfugue.player.Player;

import view.domain.Figura;
import view.domain.Nota;

public class Application {

	static Figura figura;
	static Nota nota;
	static Label labelNotas;
	static Button play;
	static ArrayList<Nota> notas = new ArrayList<Nota>();
	static ArrayList<Figura> figuras = new ArrayList<Figura>();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Contenedor de Alto nivel");
		frame.setSize(950, 450);

		Container cont = frame.getContentPane();
		JComponent contentpane = (JComponent) cont;
		frame.getContentPane().setLayout(new GridLayout(1, 2));

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo
				.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

		JPanel panel1 = new JPanel();
		panel1.setSize(225, 750);
		panel1.setLayout(new GridLayout(7, 1));
		panel1.add(createPanel(Figura.REDONDA));
		panel1.add(createPanel(Figura.BLANCA));
		panel1.add(createPanel(Figura.NEGRA));
		panel1.add(createPanel(Figura.CORCHEA));
		panel1.add(createPanel(Figura.SEMICORCHEA));
		panel1.add(createPanel(Figura.FUSA));
		panel1.add(createPanel(Figura.SEMIFUSA));
		panelIzquierdo.add(panel1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.setSize(225, 200);
		labelNotas = new Label();
		labelNotas.setSize(100, 100);
		panel2.add(labelNotas);
		panelIzquierdo.add(panel2);

		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.setSize(225, 200);
		play = new Button("Play");
		play.setSize(25, 25);
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Player player = new Player();
				labelNotas.setText("E/0.25 C/0.5 D/1 A/0.125");	
				player.play(labelNotas.getText());

			}
		});

		panel3.add(play);
		panelIzquierdo.add(panel3);
		contentpane.add(panelIzquierdo);

		JPanelWithBackground panelImagen = new JPanelWithBackground(
				"images/penta.png");
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
				System.out.println("Coordenadas " + arg0.getX() + " "
						+ arg0.getY());
				setSelectedNote(arg0);
			}

		});
		contentpane.add(panelImagen);

		frame.show();

	}

	private static void setSelectedNote(MouseEvent arg0) {
		if (arg0.getX() >= 100 && arg0.getX() <= 140 && arg0.getY() <= 310
				&& arg0.getY() >= 280) {
			nota = Nota.C;
		} else {
			if (arg0.getX() >= 140 && arg0.getX() <= 180 && arg0.getY() <= 280
					&& arg0.getY() >= 250) {
				nota = Nota.D;
			} else {
				if (arg0.getX() >= 180 && arg0.getX() <= 220
						&& arg0.getY() <= 250 && arg0.getY() >= 220) {
					nota = Nota.E;
				} else {
					if (arg0.getX() >= 220 && arg0.getX() <= 260
							&& arg0.getY() <= 220 && arg0.getY() >= 190) {
						nota = Nota.F;
					} else {
						if (arg0.getX() >= 260 && arg0.getX() <= 300
								&& arg0.getY() <= 190 && arg0.getY() >= 160) {
							nota = Nota.G;
						} else {
							if (arg0.getX() >= 300 && arg0.getX() <= 340
									&& arg0.getY() <= 160 && arg0.getY() >= 130) {
								nota = Nota.A;
							} else {
								if (arg0.getX() >= 340 && arg0.getX() <= 380
										&& arg0.getY() <= 130
										&& arg0.getY() >= 100) {
									nota = Nota.B;
								} else {
									nota = null;
								}
							}
						}
					}
				}
			}
		}
		if (nota != null && figura != null) {
			System.out.println("La nota elegida es " + nota.getNota());
			labelNotas.setText(labelNotas.getText() + " " + nota.getNota()
					+ figura.getDescripcion());			
			nota = null;
			figura = null;
		} else {
			System.out.println("No se eligi� nunca nota");

		}
	}

	private static JPanel createPanel(final Figura figuraTemp)
			throws IOException {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(new Label(figuraTemp.getNombre()));
		panel.add(new Label("------------------------->"));

		JPanelWithBackground panelImagen = new JPanelWithBackground(
				figuraTemp.getImagen());
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
				System.out.println("La figura elegida es "
						+ figuraTemp.getDescripcion());
				Application.figura = figuraTemp;
			}
		});
		panel.add(panelImagen);

		return panel;
	}

}
