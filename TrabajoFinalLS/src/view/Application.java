package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
	@SuppressWarnings("rawtypes")
	private JComboBox asignarEtiquetas;
	@SuppressWarnings("rawtypes")
	private JComboBox labels;
	@SuppressWarnings("rawtypes")
	private JComboBox labelsUpdate;
	@SuppressWarnings("rawtypes")
	private JComboBox etiquetasComboBox;
	private Notification notificationSelected;

	private DBHelper dbHelper = new DBHelper();

	private List<Label> etiquetas = new ArrayList<Label>();
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
		for (Label label : service.getLabelList()) {
			etiquetas.add(label);
		}
		;

		for (Context context : service.getContextList()) {
			contexts.add(context.getName());
		}
		;

		for (Category category : service.getCategoryList()) {
			categories.add(category.getName());
		}
		;

		for (Child child : service.getChildList()) {
			childs.add(child.getName());
		}
		;

		for (Content content : service.getContentList()) {
			contents.add(content.getName());
		}
		;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setViewPanelIzquierdo() {

		JPanel container = new JPanel();

		container.setLayout(new GridBagLayout());
		JLabel contenido = new JLabel("Contenido:");
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contenido, c);
		JComboBox contentsCombo = new JComboBox(contents.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(contentsCombo, c);

		JLabel contexto = new JLabel("Contexto:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contexto, c);
		JComboBox contextsCombo = new JComboBox(contexts.toArray());

		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contextsCombo, c);

		JLabel categoria = new JLabel("Categoria:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(categoria, c);

		JComboBox categoiasCombo = new JComboBox(categories.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(categoiasCombo, c);

		JLabel niño = new JLabel("Niñ@:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(niño, c);

		JComboBox niños = new JComboBox(childs.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(niños, c);

		JLabel fecha = new JLabel("Fecha/Hora:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(fecha, c);

		JLabel fechaDesde = new JLabel("desde:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		container.add(fechaDesde, c);

		JTextField fechaDesdeText = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		container.add(fechaDesdeText, c);

		JLabel fechaHasta = new JLabel("hasta:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		container.add(fechaHasta, c);

		JTextField fechaHastaText = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		container.add(fechaHastaText, c);

		JLabel etiquetaLabel = new JLabel("Etiqueta:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(etiquetaLabel, c);

		etiquetasComboBox = new JComboBox(etiquetas.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(etiquetasComboBox, c);

		JButton filtrar = new JButton("Filtrar");
		c.weightx = 0.5;
		c.insets = new Insets(20, 50, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		container.add(filtrar, c);

		panelIzquierdo.add(container);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setViewPanelDerecho() {

		JPanel container = new JPanel();

		container.setLayout(new GridBagLayout());
		JLabel crearEtiqueta = new JLabel("Crear etiqueta:");
		GridBagConstraints d = new GridBagConstraints();
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 0;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(crearEtiqueta, d);
		final JTextField labelName = new JTextField(10);
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 0;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(labelName, d);
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
				service.createLabel(newLabel);
				labelName.setText("");
				etiquetas.clear();
				for (Label label : service.getLabelList()) {
					etiquetas.add(label);
				}
				;
				updateEtiquetaComboBox();
				reloadGrid();
			}
		});

		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 2;
		d.gridy = 0;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(crear, d);

		JLabel eliminarEtiqueta = new JLabel("Eliminar etiqueta:");
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 1;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(eliminarEtiqueta, d);

		labels = new JComboBox(etiquetas.toArray());
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 1;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(labels, d);

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
				service.deleteLabel(label);
				etiquetas.clear();
				for (Label aux : service.getLabelList()) {
					etiquetas.add(aux);
				}
				;
				updateEtiquetaComboBox();
				reloadGrid();
			}
		});

		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 2;
		d.gridy = 1;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(eliminar, d);

		JLabel renombrarEtiqueta = new JLabel("Renombrar etiqueta:");
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 3;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(renombrarEtiqueta, d);

		labelsUpdate = new JComboBox(etiquetas.toArray());
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 3;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(labelsUpdate, d);

		JLabel nuevoNombreEtiqueta = new JLabel("Nuevo nombre:");
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 4;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(nuevoNombreEtiqueta, d);

		final JTextField newLabel = new JTextField();
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 4;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(newLabel, d);

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
				Label label = (Label) labels.getSelectedItem();
				service.updateLabel(label, newLabel.getText());
				etiquetas.clear();
				for (Label aux : service.getLabelList()) {
					etiquetas.add(aux);
				}
				;
				updateEtiquetaComboBox();
				reloadGrid();
			}
		});

		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 2;
		d.gridy = 4;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(renombrar, d);
      
		JLabel asignarEtiqueta = new JLabel("Asignar etiqueta:");
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 2;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(asignarEtiqueta, d);

		asignarEtiquetas = new JComboBox(etiquetas.toArray());
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 2;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(asignarEtiquetas, d);

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
				Label label = (Label) asignarEtiquetas.getSelectedItem();
				service.asignLabel(notificationSelected.getId(), label.getId());
				reloadGrid();

			}
		});

		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 2;
		d.gridy = 2;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(asignar, d);

		panelDerecho.add(container);

	}

	private void setViewPanelInferior() {

		grid = new JTable();
		grid.setBackground(Color.WHITE);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "N°", "Fecha/Hora envio",
				"Contenido", "Contexto", "Categoria", "Niño", "Etiquetas" });

		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}

		grid.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						int valueSelected = Integer.valueOf((String) grid
								.getValueAt(grid.getSelectedRow(), 0));
						for (Notification notification : service
								.getNotificationList()) {
							if (notification.getId().equals(valueSelected)) {
								notificationSelected = notification;
							}

						}

						// TODO:Ver como hacer para que no quede mas el foco

					}
				});

		grid.setModel(model);
		JScrollPane scrollPane = new JScrollPane(grid);
		panelInferior.add(scrollPane);

	}

	private void reloadGrid() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "N°", "Fecha/Hora envio",
				"Contenido", "Contexto", "Categoria", "Niño", "Etiquetas" });

		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}

		grid.setModel(model);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void updateEtiquetaComboBox() {
		asignarEtiquetas.setModel(new javax.swing.DefaultComboBoxModel(
				etiquetas.toArray()));
		labels.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		labelsUpdate.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		etiquetasComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				etiquetas.toArray()));
	}
}
