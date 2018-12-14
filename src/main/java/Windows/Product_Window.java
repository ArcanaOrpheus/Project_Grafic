package Windows;

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

import project.Producte;
import project.Proveidor;

import javax.swing.JRadioButton;
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

public class Product_Window{

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table;
	private JTable table_1;
	private final Action action = new SwingAction();
	private String name2;
	public static JTextArea Textname2 = new JTextArea();
	public static JTextArea ProducteID = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Window window = new Product_Window();
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
	public Product_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	static int IDProd=0;
	
	static String descripcio = "";
	static int stock =0;
	static int stockmin =0;
	static String unitat = "";
	static String tipus = "";
	static Proveidor proveidor = null;
	static double preuVenda= 0;
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 720, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producte");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setBounds(0, 11, 72, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIdproducte = new JLabel("idProducte:");
		lblIdproducte.setBounds(10, 46, 62, 14);
		frame.getContentPane().add(lblIdproducte);
		
		
		ProducteID.setBounds(82, 40, 118, 20);
		frame.getContentPane().add(ProducteID);
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblNom);
		
		Textname2.setBounds(82, 71, 302, 20);
		frame.getContentPane().add(Textname2);
		
		
		
		JLabel lblDescripcio = new JLabel("descripcio:");
		lblDescripcio.setBounds(10, 96, 62, 14);
		frame.getContentPane().add(lblDescripcio);
				
		JTextPane desc = new JTextPane();
		desc.setBounds(82, 96, 302, 123);
		frame.getContentPane().add(desc);
		
		
		JLabel lblNewLabel_1 = new JLabel("preuVenta");
		lblNewLabel_1.setBounds(10, 236, 62, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane preuV = new JTextPane();
		preuV.setBounds(82, 230, 118, 20);
		frame.getContentPane().add(preuV);
		
		JLabel lblStock = new JLabel("stock");
		lblStock.setBounds(10, 261, 46, 14);
		frame.getContentPane().add(lblStock);
		
		JTextPane stack = new JTextPane();
		stack.setBounds(82, 261, 118, 20);
		frame.getContentPane().add(stack);
		
		JLabel lblStockminim = new JLabel("stockMinim");
		lblStockminim.setBounds(210, 261, 62, 14);
		frame.getContentPane().add(lblStockminim);
		
		JTextPane minstack = new JTextPane();
		minstack.setBounds(266, 255, 118, 20);
		frame.getContentPane().add(minstack);
		
		Box Type = Box.createVerticalBox();
		Type.setBorder(new TitledBorder(null, "Tipus de producte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Type.setBounds(10, 381, 118, 69);
		frame.getContentPane().add(Type);
		
		JRadioButton rdbtnVendible = new JRadioButton("Vendible");
		buttonGroup_1.add(rdbtnVendible);
		Type.add(rdbtnVendible);
		
		JRadioButton rdbtnIngredient = new JRadioButton("Ingredient");
		buttonGroup_1.add(rdbtnIngredient);
		Type.add(rdbtnIngredient);
		
		Box Unity = Box.createVerticalBox();
		Unity.setBorder(new TitledBorder(null, "Unitat de mesura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Unity.setBounds(138, 341, 118, 109);
		frame.getContentPane().add(Unity);
		
		JRadioButton rdbtnLitre = new JRadioButton("Litre");
		buttonGroup.add(rdbtnLitre);
		Unity.add(rdbtnLitre);
		
		JRadioButton rdbtnGram = new JRadioButton("Gram");
		buttonGroup.add(rdbtnGram);
		Unity.add(rdbtnGram);
		
		JRadioButton rdbtnUnitat = new JRadioButton("Unitat");
		buttonGroup.add(rdbtnUnitat);
		Unity.add(rdbtnUnitat);
		
		JButton btnAfegir = new JButton("Afegir");
		btnAfegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name2 = Textname2.getText();
				IDProd = Integer.parseInt(ProducteID.getText());
				Producte p = new Producte (name2);
				p.set
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
		
		table = new JTable();
		table.setBounds(436, 71, 252, 111);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(436, 261, 242, 111);
		frame.getContentPane().add(table_1);
		
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
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public void componentAdded(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
