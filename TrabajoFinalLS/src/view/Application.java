package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

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
	private JComboBox<Label> labelsDelete;
	private JComboBox<Label> labelsUpdate;
	
	private JComboBox<Content> contentsFilterComboBox;
	private JComboBox<Label> labelFilterComboBox;
	private JComboBox<Category> categoriesFilterComboBox;
	private JComboBox<Context> contextsFilterComboBox;
	private JComboBox<Child> childsFilterComboBox;
	private JDateChooser dateFromFilter;
	private JDateChooser dateToFilter;
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
		if(isNewDB){
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
		panelIzquierdo
				.setLayout(new FlowLayout(FlowLayout.LEFT));
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

		container.setLayout(new GridBagLayout());
		JLabel contenido = new JLabel("Contenido:");
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contenido, c);
		
		contentsFilterComboBox = new JComboBox(contents.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(contentsFilterComboBox,c );

		JLabel contexto = new JLabel("Contexto:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contexto, c);
		contextsFilterComboBox = new JComboBox(contexts.toArray());

		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(contextsFilterComboBox, c);

		JLabel categoria = new JLabel("Categoria:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 0);
		container.add(categoria, c);

		categoriesFilterComboBox =new JComboBox(categories.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(categoriesFilterComboBox, c);

		JLabel niño = new JLabel("Niñ@:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(niño, c);

		childsFilterComboBox = new JComboBox(childs.toArray()); 
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(childsFilterComboBox, c);

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

		dateFromFilter= new JDateChooser();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;		
		container.add(dateFromFilter, c);

		JLabel fechaHasta = new JLabel("hasta:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		container.add(fechaHasta, c);

		dateToFilter = new JDateChooser();
		c.weightx =0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;			
		container.add(dateToFilter, c);

		JLabel etiquetaLabel = new JLabel("Etiqueta:");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(etiquetaLabel, c);

		labelFilterComboBox = new JComboBox(etiquetas.toArray());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 8;
		c.insets = new Insets(10, 0, 0, 0);

		container.add(labelFilterComboBox, c);

		JButton filtrar = new JButton("Filtrar");
		c.weightx = 0.5;
		c.insets = new Insets(20, 50, 0, 0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		container.add(filtrar, c);

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
				Date dateFrom = dateFromFilter.getDate();
				Date dateTo = dateToFilter.getDate();
				List<Notification> list = service.getNotificationListByFilter(cat, context, cont, child, lab, dateFrom, dateTo);
				reloadGrid(list);
			}
		});

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
					showDialog("Etiqueta creada", "Se creo la etiqueta correctamente");
				}
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

		labelsDelete = new JComboBox(etiquetas.toArray());
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 1;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(labelsDelete, d);

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
				Label label = (Label) labelsDelete.getSelectedItem();
				if (label != null && label.getId() != null) {
					service.deleteLabel(label);
					etiquetas.clear();
					etiquetas.add(new Label());
					for (Label aux : service.getLabelList()) {
						etiquetas.add(aux);
					}
					updateEtiquetaComboBox();
					reloadGrid();
					showDialog("Etiqueta eliminada", "Se elimino la etiqueta correctamente");
				}
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
					showDialog("Etiqueta actualizada", "Se actualizo la etiqueta correctamente");
				}	
				
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

		labelsAsign = new JComboBox(etiquetas.toArray());
		d.weightx = 0.5;
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 1;
		d.gridy = 2;
		d.insets = new Insets(10, 10, 0, 0);
		container.add(labelsAsign, d);

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
					showDialog("Etiqueta asignada", "Se asigno la etiqueta correctamente");
				}

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
		
		DefaultTableModel model = new DefaultTableModel() {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		model.setColumnIdentifiers(new String[] { "N°", "Fecha/Hora envio",  "Fecha/Hora recibido",
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
		JScrollPane scrollPane= new  JScrollPane(grid);
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
		labelsDelete.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		labelsUpdate.setModel(new javax.swing.DefaultComboBoxModel(etiquetas
				.toArray()));
		labelFilterComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				etiquetas.toArray()));
	}
	
	private void showDialog(String title, String message){
		JOptionPane.showMessageDialog(frame,
			    title,
			    message,
			    JOptionPane.PLAIN_MESSAGE);
	}
}
