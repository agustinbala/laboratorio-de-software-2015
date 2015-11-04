package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private JTable grid;
	private JComboBox<Label> labelsAsign;
	private JComboBox<Label> labels;
	private JComboBox<Label> labelsUpdate;
	
	private JComboBox<Content> contentsFilterComboBox;
	private JComboBox<Label> labelFilterComboBox;
	private JComboBox<Category> categoriesFilterComboBox;
	private JComboBox<Context> contextsFilterComboBox;
	private JComboBox<Child> childsFilterComboBox;
	private JTextField dateFromFilter;
	private JTextField dateToFilter;
	private Notification notificationSelected;

	private DBHelper dbHelper = new DBHelper();

	private List<Label> etiquetas = new ArrayList<Label>();
	private List<Context> contexts = new ArrayList<Context>();
	private List<Category> categories = new ArrayList<Category>();
	private List<Child> childs = new ArrayList<Child>();
	private List<Content> contents = new ArrayList<Content>();
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
		if (isNewDB) {
			MockUtil.initData();
		}

		initComboBoxList();

		frame = new JFrame("Hermes");
		frame.setSize(950, 700);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(2, 1));

		panelSuperior = new JPanel();
		panelSuperior.setSize(950, 250);
		panelSuperior.setBackground(new Color(102, 255, 102));

		panelSuperior.setLayout(new GridLayout(1, 2));

		panelIzquierdo = new JPanel();
		panelIzquierdo.setSize(450, 500);
		panelIzquierdo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Filtros"));
		panelSuperior.add(panelIzquierdo);

		setViewPanelIzquierdo();
		panelDerecho = new JPanel();
		panelDerecho.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelDerecho.setSize(450, 300);
		panelDerecho.setBorder(BorderFactory.createTitledBorder("Etiquetas"));
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

		etiquetas.add(new Label());
		for (Label label : service.getLabelList()) {
			etiquetas.add(label);
		};

		contexts.add(new Context());
		for (Context context : service.getContextList()) {
			contexts.add(context);
		};

		categories.add(new Category());
		for (Category category : service.getCategoryList()) {
			categories.add(category);
		};

		childs.add(new Child());
		for (Child child : service.getChildList()) {
			childs.add(child);
		};

		contents.add(new Content());
		for (Content content : service.getContentList()) {
			contents.add(content);
		};

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setViewPanelIzquierdo() {

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));

		JPanel contenido = new JPanel();
		contenido.setLayout(new GridLayout(1, 2));
		contenido.add(new JLabel("Contenido"));
		contentsFilterComboBox = new JComboBox(contents.toArray());
		contenido.add(contentsFilterComboBox);
		container.add(contenido);

		JPanel contexto = new JPanel();
		contexto.setLayout(new GridLayout(1, 4));
		contexto.add(new JLabel("Contexto"));
		contextsFilterComboBox = new JComboBox(contexts.toArray());
		contexto.add(contextsFilterComboBox);

		contexto.add(new JLabel("Categoria"));
		categoriesFilterComboBox =new JComboBox(categories.toArray());
		contexto.add(categoriesFilterComboBox);

		container.add(contexto);

		JPanel niño = new JPanel();
		niño.setLayout(new GridLayout(1, 2));
		niño.add(new JLabel("Niño"));

		childsFilterComboBox = new JComboBox(childs.toArray()); 
		niño.add(childsFilterComboBox);
		container.add(niño);

		JPanel fecha = new JPanel();
		fecha.setLayout(new GridLayout(1, 2));
		fecha.add(new JLabel("Fecha/Hora"));
		JPanel fecha2 = new JPanel();
		fecha2.setLayout(new GridLayout(2, 2));
		fecha2.add(new JLabel("desde:"));
		dateFromFilter = new JTextField();
		fecha2.add(dateFromFilter);
		fecha2.add(new JLabel("hasta:"));
		dateToFilter = new JTextField();
		fecha2.add(dateToFilter);
		fecha.add(fecha2);

		container.add(fecha);

		JPanel etiquetaLabel = new JPanel();
		etiquetaLabel.setLayout(new GridLayout(1, 2));
		etiquetaLabel.add(new JLabel("Etiqueta"));
		labelFilterComboBox = new JComboBox(etiquetas.toArray());
		etiquetaLabel.add(labelFilterComboBox);
		container.add(etiquetaLabel);

		JButton filtrar = new JButton("Filtrar");
		filtrar.setPreferredSize(new Dimension(450, 30));
		filtrar.addMouseListener(new MouseListener() {
			
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
				Category cat = (Category) categoriesFilterComboBox.getSelectedItem();
				Content cont = (Content) contentsFilterComboBox.getSelectedItem();
				Context context = (Context) contextsFilterComboBox.getSelectedItem();
				Label lab = (Label) labelFilterComboBox.getSelectedItem();
				Child child = (Child) childsFilterComboBox.getSelectedItem();
				String dateFrom = dateFromFilter.getText();
				String dateTo = dateToFilter.getText();
				List<Notification> list = service.getNotificationListByFilter(cat, context, cont, child, lab, dateFrom, dateTo);
				reloadGrid(list);
			}
		});
		
		
		panelIzquierdo.add(container);
		panelIzquierdo.add(filtrar);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setViewPanelDerecho() {

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));
		JPanel crearEtiqueta = new JPanel();
		crearEtiqueta.setLayout(new GridLayout(1, 3));
		crearEtiqueta.add(new JLabel("Crear etiqueta"));
		final JTextField labelName = new JTextField();
		crearEtiqueta.add(labelName);
		JButton crear = new JButton("Crear");
		crear.addMouseListener(new MouseListener() {

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
				Label newLabel = new Label(labelName.getText());
				if (!newLabel.getName().equals("")) {
					service.createLabel(newLabel);
					labelName.setText("");
					etiquetas.clear();
					etiquetas.add(new Label());
					for (Label label : service.getLabelList()) {
						etiquetas.add(label);
					}
					;
					updateEtiquetaComboBox();
					reloadGrid();
				}
			}
		});
		crearEtiqueta.add(crear);
		container.add(crearEtiqueta);

		JPanel eliminarEtiqueta = new JPanel();
		eliminarEtiqueta.setLayout(new GridLayout(1, 3));
		eliminarEtiqueta.add(new JLabel("Eliminar etiqueta"));
		labels = new JComboBox(etiquetas.toArray());
		eliminarEtiqueta.add(labels);
		JButton eliminar = new JButton("Eliminar");
		eliminar.addMouseListener(new MouseListener() {

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
				Label label = (Label) labels.getSelectedItem();
				if (label != null && label.getId() != null) {
					service.deleteLabel(label);
					etiquetas.clear();
					etiquetas.add(new Label());
					for (Label aux : service.getLabelList()) {
						etiquetas.add(aux);
					}
					updateEtiquetaComboBox();
					reloadGrid();
				}
			}
		});
		eliminarEtiqueta.add(eliminar);
		container.add(eliminarEtiqueta);

		JPanel asignarEtiqueta = new JPanel();
		asignarEtiqueta.setLayout(new GridLayout(1, 3));
		asignarEtiqueta.add(new JLabel("Asignar etiqueta"));
		labelsAsign = new JComboBox(etiquetas.toArray());
		asignarEtiqueta.add(labelsAsign);
		JButton asignar = new JButton("Asignar");
		asignar.addMouseListener(new MouseListener() {

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
				Label label = (Label) labelsAsign.getSelectedItem();
				if (label != null && label.getId() != null) {
					service.asignLabel(notificationSelected.getId(),
							label.getId());
					reloadGrid();
				}

			}
		});

		asignarEtiqueta.add(asignar);
		container.add(asignarEtiqueta);

		JPanel renombrarEtiqueta = new JPanel();
		renombrarEtiqueta.setLayout(new GridLayout(1, 2));
		renombrarEtiqueta.add(new JLabel("Renombrar etiqueta"));
		labelsUpdate = new JComboBox(etiquetas.toArray());
		renombrarEtiqueta.add(labelsUpdate);
		container.add(renombrarEtiqueta);

		JPanel nuevoNombreEtiqueta = new JPanel();
		nuevoNombreEtiqueta.setLayout(new GridLayout(1, 3));
		nuevoNombreEtiqueta.add(new JLabel("Nuevo nombre"));
		final JTextField newLabel = new JTextField();
		nuevoNombreEtiqueta.add(newLabel);
		JButton renombrar = new JButton("Renombrar");
		renombrar.addMouseListener(new MouseListener() {

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
				Label label = (Label) labelsUpdate.getSelectedItem();
				if (label != null && label.getId() != null && !newLabel.getText().equals("")) {
					service.updateLabel(label, newLabel.getText());
					newLabel.setText("");
					etiquetas.clear();
					etiquetas.add(new Label());
					for (Label aux : service.getLabelList()) {
						etiquetas.add(aux);
					};
					updateEtiquetaComboBox();
					reloadGrid();
				}
			}
		});
		nuevoNombreEtiqueta.add(renombrar);
		container.add(nuevoNombreEtiqueta);

		panelDerecho.add(container);

	}

	private void setViewPanelInferior() {

		grid = new JTable();
		grid.setBackground(Color.WHITE);
		
		DefaultTableModel model = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		model.setColumnIdentifiers(new String[] { "N°", "Fecha/Hora envio",
				"Contenido", "Contexto", "Categoria", "Niño", "Etiquetas" });

		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}

		grid.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (grid.getSelectedRow() != -1) {
							int valueSelected = Integer.valueOf((String) grid
									.getValueAt(grid.getSelectedRow(), 0));
							for (Notification notification : service
									.getNotificationList()) {
								if (notification.getId().equals(valueSelected)) {
									notificationSelected = notification;
								}

							}
						}
					}
				});

		grid.setModel(model);
		JScrollPane scrollPane = new JScrollPane(grid);
		panelInferior.add(scrollPane);

	}

	private void reloadGrid() {
		DefaultTableModel model = (DefaultTableModel) grid.getModel();
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}

		grid.setModel(model);
	}
	
	private void reloadGrid(List<Notification> list) {
		DefaultTableModel model = (DefaultTableModel) grid.getModel();
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
		for (Notification notification : list) {
			model.addRow(notification.toArray());
		}

		grid.setModel(model);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void updateEtiquetaComboBox() {
		labelsAsign.setModel(new javax.swing.DefaultComboBoxModel(
				etiquetas.toArray()));
		labels.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		labelsUpdate.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		labelFilterComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				etiquetas.toArray()));
	}
}
