package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import parser.JSONParser;
import db.DBHelper;
import db.NotificationDAO;
import db.NotificationDAOImpl;
import domain.Notification;

public class Application {

	private static JFrame frame;
	private static JPanel panelSuperior;
	private static JPanel panelIzquierdo;
	private static JPanel panelDerecho;
	private static JPanel panelInferior;
	private static DBHelper dbHelper = new DBHelper();
	private static List<Notification> notificationList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		NotificationDAO dao = new NotificationDAOImpl();
		dbHelper.createDB();
		List<Notification> notificaciones = new JSONParser().getNotificationList();
		for (Notification notification : notificaciones) {
			dao.saveNotification(notification);
		}
		notificationList = dao.listNotifications();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		
		
		frame = new JFrame("Hermes");
		frame.setSize(950, 450);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(2, 1));

		panelSuperior = new JPanel();
		panelSuperior.setSize(950, 250);
		panelSuperior.setBackground(new Color(102, 255, 102));

		panelSuperior.setLayout(new GridLayout(1, 2));

		panelIzquierdo = new JPanel();
		panelIzquierdo.setSize(450, 250);
		panelIzquierdo
				.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelSuperior.add(panelIzquierdo);

		setViewPanelIzquierdo();
		panelDerecho = new JPanel();
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		panelDerecho.setSize(450, 250);

		panelSuperior.add(panelDerecho);

		setViewPanelDerecho();

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setSize(950, 200);
		panelInferior.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

		setViewPanelInferior();

		frame.getContentPane().add(panelSuperior);
		frame.getContentPane().add(panelInferior);

		frame.setVisible(true);
	}

	private static void setViewPanelIzquierdo() {

		JLabel titulo = new JLabel("Filtros");

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));

		JPanel contenido = new JPanel();
		contenido.setLayout(new GridLayout(1, 2));
		contenido.add(new JLabel("Contenido"));
		String[] options = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };
		contenido.add(new JComboBox(options));
		container.add(contenido);

		JPanel contexto = new JPanel();
		contexto.setLayout(new GridLayout(1, 4));
		contexto.add(new JLabel("Contexto"));
		String[] contextos = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };
		contexto.add(new JComboBox(contextos));
		contexto.add(new JLabel("Categoria"));
		String[] categorias = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };
		contexto.add(new JComboBox(categorias));

		container.add(contexto);

		JPanel niño = new JPanel();
		niño.setLayout(new GridLayout(1, 2));
		niño.add(new JLabel("Niño"));
		String[] niños = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };
		niño.add(new JComboBox(niños));
		container.add(niño);

		JPanel fecha = new JPanel();
		fecha.setLayout(new GridLayout(1, 2));
		fecha.add(new JLabel("Fecha/Hora"));
		JPanel fecha2 = new JPanel();
		fecha2.setLayout(new GridLayout(2, 2));
		fecha2.add(new JLabel("desde:"));
		fecha2.add(new JTextField());
		fecha2.add(new JLabel("hasta:"));
		fecha2.add(new JTextField());
		fecha.add(fecha2);

		container.add(fecha);

		JPanel etiqueta = new JPanel();
		etiqueta.setLayout(new GridLayout(1, 2));
		etiqueta.add(new JLabel("Etiqueta"));
		String[] etiquetas = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };
		etiqueta.add(new JComboBox(etiquetas));
		container.add(etiqueta);

		JButton filtrar = new JButton("Filtrar");

		panelIzquierdo.add(titulo);
		panelIzquierdo.add(container);
		panelIzquierdo.add(filtrar);

	}

	private static void setViewPanelDerecho() {

		JLabel titulo = new JLabel("Etiquetas");

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));

		JPanel crearEtiqueta = new JPanel();
		crearEtiqueta.setLayout(new GridLayout(1, 3));
		crearEtiqueta.add(new JLabel("Crear etiqueta"));
		crearEtiqueta.add(new JTextField());
		crearEtiqueta.add(new JButton("Crear"));
		container.add(crearEtiqueta);

		String[] etiquetas = { "Option1", "Option2", "Option3", "Option4",
				"Option15" };

		JPanel eliminarEtiqueta = new JPanel();
		eliminarEtiqueta.setLayout(new GridLayout(1, 3));
		eliminarEtiqueta.add(new JLabel("Eliminar etiqueta"));
		eliminarEtiqueta.add(new JComboBox(etiquetas));
		eliminarEtiqueta.add(new JButton("Eliminar"));
		container.add(eliminarEtiqueta);

		JPanel asignarEtiqueta = new JPanel();
		asignarEtiqueta.setLayout(new GridLayout(1, 3));
		asignarEtiqueta.add(new JLabel("Asignar etiqueta"));
		asignarEtiqueta.add(new JComboBox(etiquetas));
		asignarEtiqueta.add(new JButton("Asignar"));
		container.add(asignarEtiqueta);

		JPanel renombrarEtiqueta = new JPanel();
		renombrarEtiqueta.setLayout(new GridLayout(1, 2));
		renombrarEtiqueta.add(new JLabel("Renombrar etiqueta"));
		renombrarEtiqueta.add(new JComboBox(etiquetas));
		container.add(renombrarEtiqueta);

		JPanel nuevoNombreEtiqueta = new JPanel();
		nuevoNombreEtiqueta.setLayout(new GridLayout(1, 3));
		nuevoNombreEtiqueta.add(new JLabel("Nuevo nombre"));
		nuevoNombreEtiqueta.add(new JTextField());
		nuevoNombreEtiqueta.add(new JButton("Renombrar"));
		container.add(nuevoNombreEtiqueta);

		panelDerecho.add(titulo);
		panelDerecho.add(container);

	}

	private static void setViewPanelInferior() {

		JTable container = new JTable();
		
		container.setBackground(Color.WHITE);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String [] { "Fecha/Hora envio", "Contenido", "Contexto", "Categoria", "Niño", "Etiquetas"});
		
		for (Notification notification : notificationList) {
			List<String> not = new ArrayList<String>();
			not.add(notification.getDate().toString());
			not.add(notification.getContent());
			not.add(notification.getContext());
			not.add(notification.getCategory());
			not.add(notification.getChild());
			//TODO
			not.add("");
			model.addRow(not.toArray());
		}
		
		container.setModel(model);
		JScrollPane scrollPane= new  JScrollPane(container);
		panelInferior.add(scrollPane);

	}

}
