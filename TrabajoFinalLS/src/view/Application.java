package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
	private JTable grid;
	private JComboBox asignarEtiquetas; 
	private JComboBox labels;
	private JComboBox labelsUpdate;
	private JComboBox etiquetasComboBox;
	
	
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
		etiquetasComboBox =new JComboBox(etiquetas.toArray());
		etiquetaLabel.add(etiquetasComboBox);
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
				 JDialog dialog = new JDialog();
				 dialog.setSize(400, 400);
				 dialog.add(new JTextField("Notificaciones"));
				 List<Notification> notificaciones = new ArrayList<Notification>();
				 
				 for (Notification noti : service.getNotificationList()) {
						notificaciones.add(noti);
					};
				 final JComboBox notificacionesBox = new JComboBox(notificaciones.toArray());
				 JButton button = new JButton("Aceptar");
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
							Notification noti = new Notification();
							noti = (Notification)notificacionesBox.getSelectedItem();
							Label label = (Label)asignarEtiquetas.getSelectedItem();
							service.asignLabel(noti.getId(), label.getId());
							reloadGrid();
							
						}});
		         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		         dialog.setVisible(true);		

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
				Label label =(Label) labels.getSelectedItem();
				service.updateLabel(label, newLabel.getText());
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

		panelDerecho.add(titulo);
		panelDerecho.add(container);

	}

	private void setViewPanelInferior() {

		
		grid = new JTable();
		grid.setBackground(Color.WHITE);
		
			
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String [] { "Fecha/Hora envio", "Contenido", "Contexto", "Categoria", "Niño", "Etiquetas"});
		
		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}
		
		grid.setModel(model);
		JScrollPane scrollPane= new  JScrollPane(grid);
		panelInferior.add(scrollPane);

	}
	
	private void reloadGrid(){
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String [] { "Fecha/Hora envio", "Contenido", "Contexto", "Categoria", "Niño", "Etiquetas"});
		
		for (Notification notification : service.getNotificationList()) {
			model.addRow(notification.toArray());
		}
		
		grid.setModel(model);
	}
	
	private void updateEtiquetaComboBox(){
		asignarEtiquetas.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		labels.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		labelsUpdate.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
		etiquetasComboBox.setModel(new javax.swing.DefaultComboBoxModel(etiquetas.toArray()));
	}
}
