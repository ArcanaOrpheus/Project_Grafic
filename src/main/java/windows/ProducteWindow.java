package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
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

import project.ComandaEstat;
import project.ComandaLinia;
import project.Producte;
import project.Programa;
import project.Proveidor;
import project.Tipus;
import project.UnitatMesura;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
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
	private String name2;
	public static JTextArea Textname2 = new JTextArea();
	public static JTextArea ProducteID = new JTextArea();
	public static JTextArea Preu = new JTextArea();
	public static JTextArea stack = new JTextArea();
	public static JTextArea stackmin = new JTextArea();
	public static JTextArea desc= new JTextArea();
	private int IDProd = 0;
	private String descripcio = "";
	private int stock = 0;
	private int stockmin = 0;
	private String unitat = "";
	private String tipus = "";
	private Proveidor proveidor = null;
	private double preuVenda = 0;
	private Object[] data = {"","","","","","","","",""};
	private Tipus tipo = null;
	private UnitatMesura mesura = null;
	private Producte y = null;
	
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
		
		JLabel lblIdproducte = new JLabel("idProducte:");
		lblIdproducte.setBounds(10, 46, 62, 14);
		frame.getContentPane().add(lblIdproducte);
		
		
		ProducteID.setBounds(82, 40, 118, 20);
		frame.getContentPane().add(ProducteID);
		ProducteID.setText(IDProd+1+"");
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblNom);
		
		Textname2.setBounds(82, 71, 302, 20);
		frame.getContentPane().add(Textname2);
		
		JLabel lblDescripcio = new JLabel("descripcio:");
		lblDescripcio.setBounds(10, 96, 62, 14);
		frame.getContentPane().add(lblDescripcio);
				
		desc.setBounds(82, 96, 302, 123);
		frame.getContentPane().add(desc);
		
		
		JLabel lblNewLabel_1 = new JLabel("preuVenta");
		lblNewLabel_1.setBounds(10, 236, 62, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		Preu.setBounds(82, 230, 118, 20);
		frame.getContentPane().add(Preu);
		
		JLabel lblStock = new JLabel("stock");
		lblStock.setBounds(10, 261, 46, 14);
		frame.getContentPane().add(lblStock);
		
		stack.setBounds(82, 261, 118, 20);
		frame.getContentPane().add(stack);
		
		JLabel lblStockminim = new JLabel("stockMinim");
		lblStockminim.setBounds(210, 261, 62, 14);
		frame.getContentPane().add(lblStockminim);
		
		stackmin.setBounds(266, 255, 118, 20);
		frame.getContentPane().add(stackmin);
		
		Box Type = Box.createVerticalBox();
		Type.setBorder(new TitledBorder(null, "Tipus de producte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Type.setBounds(10, 381, 118, 69);
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
		Unity.setBounds(138, 341, 118, 109);
		frame.getContentPane().add(Unity);
		
		JRadioButton rdbtnLitre = new JRadioButton("Litre");
		buttonGroup.add(rdbtnLitre);
		rdbtnLitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesura = UnitatMesura.LLITRE;
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
				mesura = UnitatMesura.UNITAT;
			}
		});
		Unity.add(rdbtnUnitat);
		
		JButton btnAfegir = new JButton("Afegir");
		btnAfegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name2 = Textname2.getText();
				IDProd = Integer.parseInt(ProducteID.getText());
				preuVenda = Double.parseDouble((Preu.getText()));
				stockmin = Integer.parseInt(stackmin.getText());
				Producte p = new Producte (name2);
				p.setPreuVenda(preuVenda);
				p.setStockMinim(stockmin);
				Program.addProducte(p);
			}
		});
		btnAfegir.setBounds(10, 461, 89, 23);
		frame.getContentPane().add(btnAfegir);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(109, 461, 89, 23);
		frame.getContentPane().add(btnModificar);
				
		JButton btnEsborrar = new JButton("Esborrar");
		btnEsborrar.setBounds(210, 461, 89, 23);
		frame.getContentPane().add(btnEsborrar);
		btnEsborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name2 = Textname2.getText();
				try {
					Program.delProducte(name2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
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
		
		
		
		JLabel lblComposicio = new JLabel("Composicio");
		lblComposicio.setBounds(434, 57, 67, 14);
		frame.getContentPane().add(lblComposicio);
		
		JLabel lblNewLabel_2 = new JLabel("Lots");
		lblNewLabel_2.setBounds(436, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 292, 129, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPreveedor = new JLabel("Proveedor");
		lblPreveedor.setBounds(10, 295, 62, 14);
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
					 
					 
					 Textname2.setText(y.getNomProducte());
					 Preu.setText(y.getPreuVenda()+"");
					 stack.setText(y.getStock()+"");
					 stackmin.setText(y.getStockMinim()+"");
					 
				 int count = tableModel.getRowCount();
				  for(int i = count -1; i >= 0; i--)
				  {
					  tableModel.removeRow(i);
				  }
				  Set<Producte> peta = y.getComposicio().keySet();
					Object[] products = peta.toArray();
					System.out.println(y.getComposicio().size());
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
						
						composicio = new JTable(tableModel);
						jscroll.add(composicio);
					}
				  
				 
				 }
				 else
				 {
					 Textname2.setText("");
					 Preu.setText("");
					 stack.setText("");
					 stackmin.setText("");
					 int count = tableModel.getRowCount();
					 for(int i = count -1; i >= 0; i--)
					  {
						  tableModel.removeRow(i);
					  }
				 }
			 }
			 
		});
		
		
	}

}
