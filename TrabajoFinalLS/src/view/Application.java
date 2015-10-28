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

import service.Service;
import service.ServiceImpl;
import util.MockUtil;
import db.DBHelper;
import domain.Category;
import domain.Child;
import domain.Content;
import domain.Context;
import domain.Label;
import domain.Notification;

public class Application {

	private JFrame frame;
	private JPanel panelSuperior;
	private JPanel panelIzquierdo;
	private JPanel panelDerecho;
	private JPanel panelInferior;
	private DBHelper dbHelper = new DBHelper();

	private List<String> etiquetas = new ArrayList<String>();
	private List<String> contexts = new ArrayList<String>();
	private List<String> categories = new ArrayList<String>();
	private List<String> childs = new ArrayList<String>();
	private List<String> contents = new ArrayList<String>();
	private Service service = new ServiceImpl();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		new Application().initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		Boolean isNewDB = dbHelper.createDB();
		if(isNewDB){
			MockUtil.initData();
		}				
		
		initComboBoxList();
		
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

	private void initComboBoxList() {
		for (Label label : service.getLabelList()) {
			etiquetas.add(label.getName());
		};

		for (Context context : service.getContextList()) {
			contexts.add(context.getName());
		};
		
		for (Category category : service.getCategoryList()) {
			categories.add(category.getName());
		};
		
		for (Child child : service.getChildList()) {
			childs.add(child.getName());
		};
		
		for (Content content : service.getContentList()) {
			contents.add(content.getName());
		};		
		
	}

	private void setViewPanelIzquierdo() {

		JLabel titulo = new JLabel("Filtros");

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));

		JPanel contenido = new JPanel();
		contenido.setLayout(new GridLayout(1, 2));
		contenido.add(new JLabel("Contenido"));
		
		contenido.add(new JComboBox(contents.toArray()));
		container.add(contenido);

		JPanel contexto = new JPanel();
		contexto.setLayout(new GridLayout(1, 4));
		contexto.add(new JLabel("Contexto"));
		contexto.add(new JComboBox(contexts.toArray()));
		
		contexto.add(new JLabel("Categoria"));
		contexto.add(new JComboBox(categories.toArray()));

		container.add(contexto);

		JPanel niño = new JPanel();
		niño.setLayout(new GridLayout(1, 2));
		niño.add(new JLabel("Niño"));
	
		niño.add(new JComboBox(childs.toArray()));
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

		JPanel etiquetaLabel = new JPanel();
		etiquetaLabel.setLayout(new GridLayout(1, 2));
		etiquetaLabel.add(new JLabel("Etiqueta"));		
		etiquetaLabel.add(new JComboBox(etiquetas.toArray()));
		container.add(etiquetaLabel);

		JButton filtrar = new JButton("Filtrar");

		panelIzquierdo.add(titulo);
		panelIzquierdo.add(container);
		panelIzquierdo.add(filtrar);

	}

	private void setViewPanelDerecho() {

		JLabel titulo = new JLabel("Etiquetas");
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(5, 1));
		JPanel crearEtiqueta = new JPanel();
		crearEtiqueta.setLayout(new GridLayout(1, 3));
		crearEtiqueta.add(new JLabel("Crear etiqueta"));
		crearEtiqueta.add(new JTextField());
		crearEtiqueta.add(new JButton("Crear"));
		container.add(crearEtiqueta);

		JPanel eliminarEtiqueta = new JPanel();
		eliminarEtiqueta.setLayout(new GridLayout(1, 3));
		eliminarEtiqueta.add(new JLabel("Eliminar etiqueta"));
		eliminarEtiqueta.add(new JComboBox(etiquetas.toArray()));
		eliminarEtiqueta.add(new JButton("Eliminar"));
		container.add(eliminarEtiqueta);

		JPanel asignarEtiqueta = new JPanel();
		asignarEtiqueta.setLayout(new GridLayout(1, 3));
		asignarEtiqueta.add(new JLabel("Asignar etiqueta"));
		asignarEtiqueta.add(new JComboBox(etiquetas.toArray()));
		asignarEtiqueta.add(new JButton("Asignar"));
		container.add(asignarEtiqueta);

		JPanel renombrarEtiqueta = new JPanel();
		renombrarEtiqueta.setLayout(new GridLayout(1, 2));
		renombrarEtiqueta.add(new JLabel("Renombrar etiqueta"));
		renombrarEtiqueta.add(new JComboBox(etiquetas.toArray()));
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

	private void setViewPanelInferior() {

		JTable container = new JTable();
		
		container.setBackground(Color.WHITE);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String [] { "Fecha/Hora envio", "Contenido", "Contexto", "Categoria", "Niño", "Etiquetas"});
		
		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}
		
		container.setModel(model);
		JScrollPane scrollPane= new  JScrollPane(container);
		panelInferior.add(scrollPane);

	}

}
