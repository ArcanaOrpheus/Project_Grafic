package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ficheros.GestioProductes;
import project.Client;
import project.ComandaEstat;
import project.ComandaLinia;
import project.LotDesglossat;
import project.Producte;
import project.Programa;
import project.Proveidor;
import project.Tipus;
import project.UnitatMesura;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProducteWindow{

	public List<Producte> lp;
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable composicio;
	public static JTextArea Textname2 = new JTextArea();
	public static JTextArea ProducteID = new JTextArea();
	public static JTextArea Preu = new JTextArea();
	public static JTextArea stack = new JTextArea();
	public static JTextArea stackmin = new JTextArea();
	public static JTextArea desc= new JTextArea();
	private int IDProd = 0;
	private Object[] data = {"","","","","","","","",""};
	private Object[] data1 = {"","","",""};
	private Tipus tipo = null;
	private UnitatMesura mesura = null;
	private Producte y = null;
	private Proveidor prov = new Proveidor();
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProducteWindow window = new ProducteWindow();
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
	public ProducteWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	protected void initialize() {
		
		Programa.main(null);
		IDProd = Programa.elMeuMagatzem.getProductes().size();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1029, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 1013, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producte");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 11, 72, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIdproducte = new JLabel("ID:");
		lblIdproducte.setBounds(10, 52, 62, 14);
		frame.getContentPane().add(lblIdproducte);
		
		
		ProducteID.setBounds(68, 48, 118, 20);
		frame.getContentPane().add(ProducteID);
		ProducteID.setText(IDProd+1+"");
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(10, 80, 46, 14);
		frame.getContentPane().add(lblNom);
		
		Textname2.setBounds(68, 80, 302, 20);
		frame.getContentPane().add(Textname2);
		
		JLabel lblDescripcio = new JLabel("Pes:");
		lblDescripcio.setBounds(10, 121, 62, 14);
		frame.getContentPane().add(lblDescripcio);
				
		desc.setBounds(68, 117, 118, 20);
		frame.getContentPane().add(desc);
		
		
		JLabel lblNewLabel_1 = new JLabel("Preu:");
		lblNewLabel_1.setBounds(210, 121, 62, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		Preu.setBounds(252, 117, 118, 20);
		frame.getContentPane().add(Preu);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 163, 46, 14);
		frame.getContentPane().add(lblStock);
		
		stack.setBounds(68, 159, 118, 20);
		frame.getContentPane().add(stack);
		
		JLabel lblStockminim = new JLabel("Stock Minim:");
		lblStockminim.setBounds(198, 159, 101, 23);
		frame.getContentPane().add(lblStockminim);
		
		stackmin.setBounds(281, 159, 89, 20);
		frame.getContentPane().add(stackmin);
		
		Box Type = Box.createVerticalBox();
		Type.setBorder(new TitledBorder(null, "Tipus de producte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Type.setBounds(39, 264, 129, 82);
		frame.getContentPane().add(Type);
		
		JRadioButton rdbtnVendible = new JRadioButton("Vendible");
		buttonGroup_1.add(rdbtnVendible);
		rdbtnVendible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = Tipus.VENDIBLE;
			}
		});
		Type.add(rdbtnVendible);
		
		JRadioButton rdbtnIngredient = new JRadioButton("Ingredient");
		buttonGroup_1.add(rdbtnIngredient);
		rdbtnIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = Tipus.INGREDIENT;
			}
		});
		Type.add(rdbtnIngredient);
				
		Box Unity = Box.createVerticalBox();
		Unity.setBorder(new TitledBorder(null, "Unitat de mesura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Unity.setBounds(210, 255, 118, 109);
		frame.getContentPane().add(Unity);
		
		JRadioButton rdbtnLitre = new JRadioButton("Litre");
		buttonGroup.add(rdbtnLitre);
		rdbtnLitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesura = UnitatMesura.LITRES;
			}
		});
		Unity.add(rdbtnLitre);
		
		JRadioButton rdbtnGram = new JRadioButton("Gram");
		buttonGroup.add(rdbtnGram);
		rdbtnGram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesura = UnitatMesura.GRAMS;
			}
		});
		Unity.add(rdbtnGram);
		
		JRadioButton rdbtnUnitat = new JRadioButton("Unitat");
		buttonGroup.add(rdbtnUnitat);
		rdbtnUnitat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesura = UnitatMesura.UNITATS;
			}
		});
		Unity.add(rdbtnUnitat);	
		
		
		String[] col = {"ID", "Nom", "Stock", "Stock Min", "Unitat", "Tipus", "Proveidor", "Preu", "Pes" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		try {
			Set<Producte> peta = Programa.elMeuMagatzem.getProductes().get(IDProd -1).getComposicio().keySet();
			Object[] products = peta.toArray();
			for(int i = 0; i < Programa.elMeuMagatzem.getProductes().get(IDProd-1).getComposicio().size(); i++)
			{
				
				Producte p = (Producte) products[i];
				
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
		composicio = new JTable(tableModel);
		JScrollPane jscroll = new JScrollPane(composicio);
		jscroll.setBounds(436, 71, 511, 154);
		frame.getContentPane().add(jscroll);
		
		String[] col1 = {"ID", "Quantitat", "Data Entrada", "Data Caducitat"};
		DefaultTableModel tableModel1 = new DefaultTableModel(col1, 0);
		
		try {
			for(LotDesglossat ld : Programa.elMeuMagatzem.getProductes().get(IDProd+1).getLots())
			{
				data1[0] = ld.getLot();
				data1[1] = ld.getQuantitat();
				data1[2] = ld.getDataEntrada();
				data1[3] = ld.getDataCaducitat();
				tableModel1.addRow(data1);
			}
		} catch (Exception e2) {
		}
		table = new JTable(tableModel1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(436, 264, 511, 154);
		frame.getContentPane().add(scrollPane);
		
		
		
		JLabel lblComposicio = new JLabel("Composicio");
		lblComposicio.setBounds(434, 57, 67, 14);
		frame.getContentPane().add(lblComposicio);
		
		JLabel lblNewLabel_2 = new JLabel("Lots");
		lblNewLabel_2.setBounds(436, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(Programa.elMeuMagatzem.getProveidors().toArray()));
		comboBox.setBounds(100, 205, 129, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setRenderer(new DefaultListCellRenderer() {
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
		
		JLabel lblPreveedor = new JLabel("Proveidor:");
		lblPreveedor.setBounds(10, 208, 62, 14);
		frame.getContentPane().add(lblPreveedor);
		
		ProducteID.getDocument().addDocumentListener(new DocumentListener() {
			 public void changedUpdate(DocumentEvent e) {
			
				  }
			 public void removeUpdate(DocumentEvent e) {

				  }
			 public void insertUpdate(DocumentEvent e) {
				  try {
					  y = Programa.elMeuMagatzem.getProductes().get(Integer.parseInt(ProducteID.getText())-1);
				  }catch(Exception e3) {
					  y = null;
				  }
				 if(y != null)
				 {
					 
					 Proveidor prov2 = y.getProveidor();
					 comboBox.setSelectedIndex(prov2.getIdProveidor()-2);
					 Textname2.setText(y.getNomProducte());
					 Preu.setText(y.getPreuVenda()+"");
					 stack.setText(y.getStock()+"");
					 stackmin.setText(y.getStockMinim()+"");
					 desc.setText(y.getPes()+"");
					 
				 int count = tableModel.getRowCount();
				  for(int i = count -1; i >= 0; i--)
				  {
					  tableModel.removeRow(i);
				  }
					 int count1 = tableModel1.getRowCount();
					 for(int i = count1 -1; i >= 0; i--)
					  {
						  tableModel1.removeRow(i);
					  }
				  Set<Producte> peta = y.getComposicio().keySet();
					Object[] products = peta.toArray();
					for(int i = 0; i < y.getComposicio().size(); i++)
					{
						
						Producte p = (Producte) products[i];
						
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
					composicio = new JTable(tableModel);
					jscroll.add(composicio);
					for(LotDesglossat ld : y.getLots())
					{
						data1[0] = ld.getLot();
						data1[1] = ld.getQuantitat();
						data1[2] = ld.getDataEntrada();
						data1[3] = ld.getDataCaducitat();
						tableModel1.addRow(data1);
					}
					table = new JTable(tableModel1);
					scrollPane.add(table);
					tipo = y.getTipus();
					mesura = y.getUnitatMesura();
					switch(tipo)
					{
					case INGREDIENT:
						rdbtnIngredient.setSelected(true);
						break;
					case VENDIBLE:
						rdbtnVendible.setSelected(true);
						break;
					}
				  
					switch(mesura)
					{
					case UNITATS:
						rdbtnUnitat.setSelected(true);
						break;
					case LITRES:
						rdbtnLitre.setSelected(true);
						break;
					case GRAMS:
						rdbtnGram.setSelected(true);
						break;
					}
				 
				 }
				 else
				 {
					 Textname2.setText("");
					 Preu.setText("");
					 stack.setText("");
					 stackmin.setText("");
					 desc.setText("");
					 int count = tableModel.getRowCount();
					 for(int i = count -1; i >= 0; i--)
					  {
						  tableModel.removeRow(i);
					  }
					 int count1 = tableModel1.getRowCount();
					 for(int i = count1 -1; i >= 0; i--)
					  {
						  tableModel1.removeRow(i);
					  }
					 table = new JTable(tableModel1);
					 scrollPane.add(table);
					 tipo = null;
					 mesura = null;
					 buttonGroup.clearSelection();
					 buttonGroup_1.clearSelection();
				 }
				 
				 IDProd = Integer.parseInt(ProducteID.getText())-1;
			 }
			 
		});
		
		JButton btnAfegir = new JButton("Afegir");
		btnAfegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Producte p = new Producte (Textname2.getText());
				p.setPreuVenda(Double.parseDouble(Preu.getText()));
				p.setStockMinim(Integer.parseInt(stackmin.getText()));
				p.setStock(Integer.parseInt(stack.getText()));
				p.setCodiProducte(Integer.parseInt(ProducteID.getText()));
				p.setTipus(tipo);
				p.setPes(Double.parseDouble(desc.getText()));
				p.setUnitatMesura(mesura);
				p.setProveidor(prov);
				Programa.elMeuMagatzem.add(p);
				System.out.println("Producte Afegit");
				
				IDProd++;
				ProducteID.setText(""+IDProd);
			}
		});
		btnAfegir.setBounds(25, 428, 89, 23);
		frame.getContentPane().add(btnAfegir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(126, 428, 89, 23);
		frame.getContentPane().add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestioProductes.productePerId(IDProd+1);
					Programa.elMeuMagatzem.getProductes().get(IDProd).setPreuVenda(Double.parseDouble(Preu.getText()));
					Programa.elMeuMagatzem.getProductes().get(IDProd).setStockMinim(Integer.parseInt(stackmin.getText()));
					Programa.elMeuMagatzem.getProductes().get(IDProd).setStock(Integer.parseInt(stack.getText()));
					Programa.elMeuMagatzem.getProductes().get(IDProd).setTipus(tipo);
					Programa.elMeuMagatzem.getProductes().get(IDProd).setPes(Double.parseDouble(desc.getText()));
					Programa.elMeuMagatzem.getProductes().get(IDProd).setUnitatMesura(mesura);
					Programa.elMeuMagatzem.getProductes().get(IDProd).setProveidor(prov);
					Programa.elMeuMagatzem.getProductes().get(IDProd).setNomProducte(Textname2.getText());
					System.out.println("Producte modificat");
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
				
		JButton btnEsborrar = new JButton("Esborrar");
		btnEsborrar.setBounds(227, 428, 89, 23);
		frame.getContentPane().add(btnEsborrar);
		btnEsborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(y != null)
				{
					if(Programa.elMeuMagatzem.delete(y))
					{
						System.out.println("Producte eliminat");
					}else {
						System.out.println("Producte no existeix");
					}
				}else {
					System.out.println("Producte no existeix");
				}
			}
		});
		
		
	}
}
