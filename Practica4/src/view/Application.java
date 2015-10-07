package view;



import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfugue.player.Player;

import view.domain.Figura;
import view.domain.Nota;

public class Application {

	static Figura figura;
	static Nota nota;
	static ArrayList<Nota> notas = new ArrayList<Nota>();
	static ArrayList<Figura> figuras = new ArrayList<Figura>();
	static JTextField labelNotas;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		final JFrame frame = new JFrame("Pentagrama");
		frame.setSize(950, 450);

		Container cont = frame.getContentPane();
		JComponent contentpane = (JComponent) cont;
		frame.getContentPane().setLayout(new GridLayout(1, 2));

		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo
				.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelIzquierdo.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel panel1 = new JPanel();
		
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
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setLayout(new GridLayout(2,1));
		labelNotas = new JTextField();
		labelNotas.setFocusable(true);
		labelNotas.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.add(labelNotas);
		
		JButton button = new JButton("Reproducir");

	
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
				
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog = new JDialog(frame);
				dialog.setSize(400, 100);
				dialog.setAlwaysOnTop(true);
				dialog.setModal(true);
				dialog.setLayout(new GridLayout(1, 2) );
				final JTextField textField = new JTextField();
				dialog.add(textField);
				JButton button = new JButton("Reproducir");
				button.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						 Player player = new Player();
						 player.play(textField.getText());
					}
				});
				dialog.add(button);
				dialog.setVisible(true);
			}
		});
		
		panel2.add(button);
		panelIzquierdo.add(panel2);
		contentpane.add(panelIzquierdo);
		
		
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
				System.out.println("Coordenadas " + arg0.getX() + " "
						+ arg0.getY());
				setSelectedNote(arg0);
			}

		});
		contentpane.add(panelImagen);

		frame.setVisible(true);

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
			System.out.println("No se eligio nunca nota");

		}
	}

	private static JPanel createPanel(final Figura figuraTemp)
			throws IOException {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));
		panel.add(new JLabel(figuraTemp.getNombre()));
		panel.add(new JLabel("------------------------->"));

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
