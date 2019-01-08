package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.TitledBorder;

import project.Client;
import project.Producte;
import project.Programa;
import project.Proveidor;
import project.Tipus;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import ficheros.Filtro;

import javax.swing.event.ChangeEvent;

public class ConsultaWindow {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private Tipus tipu = null;
	private boolean flag = false; 
	private Producte prod = new Producte();
	private Proveidor prov = new Proveidor();
	private Object[] data = {"","","","","","","","",""};
	private List<Producte> array = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaWindow window = new ConsultaWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultaWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 949, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 933, 144);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		array = Programa.elMeuMagatzem.getProductes();
		
		JLabel lblNewLabel = new JLabel("Consulta de Productes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(7, -2, 204, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codi Poducte");
		lblNewLabel_1.setBounds(8, 51, 89, 14);
		panel.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(91, 48, 53, 20);
		panel.add(textPane);
		textPane.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Nom Producte");
		lblNewLabel_2.setBounds(177, 48, 90, 14);
		panel.add(lblNewLabel_2);
		
		List<Producte> combo = new ArrayList<>();
		combo.addAll(Programa.elMeuMagatzem.getProductes()); 
		combo.add(0, new Producte("-"));
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(combo.toArray()));
		comboBox.setBounds(265, 46, 263, 20);
		panel.add(comboBox);
		comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if(value instanceof Producte){
                    prod = (Producte) value;
                    
                    setText(prod.getNomProducte());
                    if(!prod.getNomProducte().equals("-")) {
                    textPane.setText(prod.getCodiProducte()+"");
                    }
                    else {
                    	textPane.setText("-");	
                    }
                }
               return this;
            }
        } );
		
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Tipus Producte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(587, 8, 103, 92);
		panel.add(verticalBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tots");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipu = null;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(100, 149, 237));
		verticalBox.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnVendible = new JRadioButton("Vendibles");
		rdbtnVendible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipu = Tipus.VENDIBLE;
			}
		});
		buttonGroup.add(rdbtnVendible);
		rdbtnVendible.setBackground(new Color(100, 149, 237));
		verticalBox.add(rdbtnVendible);
		
		JRadioButton rdbtnIngredents = new JRadioButton("Ingredents");
		rdbtnIngredents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipu = Tipus.INGREDIENT;
			}
		});
		buttonGroup.add(rdbtnIngredents);
		rdbtnIngredents.setBackground(new Color(100, 149, 237));
		verticalBox.add(rdbtnIngredents);
		
		JCheckBox chckbxSolament = new JCheckBox("Solament Trencament Stock");
		chckbxSolament.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(chckbxSolament.isSelected()) {
					flag = true;
				}else {
					flag = false;
				}
			}
		});
		chckbxSolament.setBackground(new Color(100, 149, 237));
		chckbxSolament.setBounds(730, 7, 190, 23);
		
		panel.add(chckbxSolament);
		
		JLabel lblNewLabel_3 = new JLabel("Proveeïdor");
		lblNewLabel_3.setBounds(9, 91, 63, 14);
		panel.add(lblNewLabel_3);
		
		
		
		List<Proveidor> combo1 = Programa.elMeuMagatzem.getProveidors();
		combo1.add(0, new Proveidor("-"));
		JComboBox comboBox_1 = new JComboBox(new DefaultComboBoxModel(combo1.toArray()));
		comboBox_1.setBounds(88, 89, 192, 20);
		panel.add(comboBox_1);
		comboBox_1.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Proveidor){
                    prov = (Proveidor) value;
                    
                    setText(prov.getNomProveidor());
                }   
               return this;
            }
        } );
		
		
		
		String[] col = {"ID", "Nom", "Stock", "Stock Min", "Unitat", "Tipus", "Proveidor", "Preu", "Pes" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		try {
			for(Producte p : array)
			{	
				data[0] = p.getCodiProducte();
				data[1] = p.getNomProducte();
				data[2] = p.getStock();
				data[3] = p.getStockMinim();
				data[4] = p.getUnitatMesura();
				data[5] = p.getTipus();
				data[6] = p.getProveidor().getNomProveidor();
				data[7] = p.getPreuVenda();
				data[8] = p.getPes();
				
				tableModel.addRow(data);
			}
		} catch (Exception e1) {
		}
		table = new JTable(tableModel);
		JScrollPane dale = new JScrollPane(table);
		dale.setBounds(1, 144, 933, 334);
		frame.getContentPane().add(dale);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Producte> venga = new ArrayList<Producte>();
				
				
				
				int count = tableModel.getRowCount();
				  for(int i = count -1; i >= 0; i--)
				  {
					  tableModel.removeRow(i);
				  }
				  if(comboBox.getSelectedIndex() != 0)
				  {
					  if(venga.isEmpty()) {
						  venga = Filtro.productePerNom(prod, array);
						}else {
							venga = Filtro.productePerNom(prod, venga);
						}
				  }
				  if(comboBox_1.getSelectedIndex() != 0)
				  {
					  if(venga.isEmpty()) {
						  venga = Filtro.productePerProveidor(prov, array);
						}else {
							venga = Filtro.productePerProveidor(prov, venga);
						}
				  }
				  
				  
				  
				  if(flag) {
					  if(venga.isEmpty()) {
					  venga = Filtro.producteLessStock(array);
					  }else {
						  venga = Filtro.producteLessStock(venga);
					  }
				  }
				  
				  if(tipu != null) {
					  if(venga.isEmpty()) {
						  venga = Filtro.productePerTipus(tipu, array);
					  }else {
						  venga = Filtro.productePerTipus(tipu, venga);
					  }
				  }
				  
				  
				  if(comboBox.getSelectedIndex() == 0 && comboBox_1.getSelectedIndex() == 0 && !flag && tipu == null) {
					  venga = array;
				  }
				  
				  try {
						for(Producte p : venga)
						{	
							data[0] = p.getCodiProducte();
							data[1] = p.getNomProducte();
							data[2] = p.getStock();
							data[3] = p.getStockMinim();
							data[4] = p.getUnitatMesura();
							data[5] = p.getTipus();
							data[6] = p.getProveidor().getNomProveidor();
							data[7] = p.getPreuVenda();
							data[8] = p.getPes();
							
							tableModel.addRow(data);
						}
					} catch (Exception e1) {
					}
				  
			}
		});
		btnBuscar.setBounds(831, 77, 89, 23);
		panel.add(btnBuscar);
		
		JButton button = new JButton("Sortir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(831, 108, 89, 23);
		panel.add(button);
	}
}
