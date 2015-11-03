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
		for (Label label : service.getLabelList()) {
			etiquetas.add(label);
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setViewPanelIzquierdo() {

		JPanel container = new JPanel();

		container.setLayout(new GridLayout(5, 1));

		JPanel contenido = new JPanel();
		contenido.setLayout(new GridLayout(1, 2));
		contenido.add(new JLabel("Contenido"));
		JComboBox contentsCombo = new JComboBox(contents.toArray());
		contenido.add(contentsCombo);
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
		etiquetasComboBox =new JComboBox(etiquetas.toArray());
		etiquetaLabel.add(etiquetasComboBox);
		container.add(etiquetaLabel);

		JButton filtrar = new JButton("Filtrar");
		filtrar.setPreferredSize(new Dimension(450, 30));

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
				 service.createLabel(newLabel);
				 labelName.setText("");
				 etiquetas.clear();
				 for (Label label : service.getLabelList()) {
					 	etiquetas.add(label);
				};				
				updateEtiquetaComboBox();
				reloadGrid();
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
				Label label =(Label) labels.getSelectedItem();
				service.deleteLabel(label);
				etiquetas.clear();
				 for (Label aux : service.getLabelList()) {
					 	etiquetas.add(aux);					 	
				};
				updateEtiquetaComboBox();
				reloadGrid();
			}
		});
		eliminarEtiqueta.add(eliminar);
		container.add(eliminarEtiqueta);

		JPanel asignarEtiqueta = new JPanel();
		asignarEtiqueta.setLayout(new GridLayout(1, 3));
		asignarEtiqueta.add(new JLabel("Asignar etiqueta"));
		asignarEtiquetas = new JComboBox(etiquetas.toArray());
		asignarEtiqueta.add(asignarEtiquetas);
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
				Label label = (Label)asignarEtiquetas.getSelectedItem();
				service.asignLabel(notificationSelected.getId(), label.getId());
				reloadGrid();
				
			}});
		       
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
				Label label =(Label) labelsUpdate.getSelectedItem();
				service.updateLabel(label, newLabel.getText());
				newLabel.setText("");
				etiquetas.clear(); 
				for (Label aux : service.getLabelList()) {
					 	etiquetas.add(aux);
				};
				updateEtiquetaComboBox();
				reloadGrid();
			}
		});
		nuevoNombreEtiqueta.add(renombrar);
		container.add(nuevoNombreEtiqueta);

		panelDerecho.add(container);

	}

	private void setViewPanelInferior() {

		
		grid = new JTable();
		grid.setBackground(Color.WHITE);
		
			
		DefaultTableModel model = new DefaultTableModel();
		grid.setEnabled(false);
		model.setColumnIdentifiers(new String [] {"N°", "Fecha/Hora envio", "Contenido", "Contexto", "Categoria", "Niño", "Etiquetas"});
		
		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}
		
		grid.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	       
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(grid.getSelectedRow() != -1){
				int valueSelected = Integer.valueOf((String) grid.getValueAt(grid.getSelectedRow(), 0));				
					for (Notification notification : service.getNotificationList()) {
						if(notification.getId().equals(valueSelected)){
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
	
	private void reloadGrid(){
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void updateEtiquetaComboBox(){
		asignarEtiquetas.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		labels.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		labelsUpdate.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		etiquetasComboBox.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
	}
}
