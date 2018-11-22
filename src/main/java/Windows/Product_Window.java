package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Product_Window {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table;
	private JTable table_1;

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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(82, 40, 118, 20);
		frame.getContentPane().add(textPane);
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(82, 71, 302, 20);
		frame.getContentPane().add(textPane_1);
		
		JLabel lblDescripcio = new JLabel("descripcio:");
		lblDescripcio.setBounds(10, 96, 62, 14);
		frame.getContentPane().add(lblDescripcio);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(82, 96, 302, 123);
		frame.getContentPane().add(textPane_2);
		
		JLabel lblNewLabel_1 = new JLabel("preuVenta");
		lblNewLabel_1.setBounds(10, 236, 62, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(82, 230, 118, 20);
		frame.getContentPane().add(textPane_3);
		
		JLabel lblStock = new JLabel("stock");
		lblStock.setBounds(10, 261, 46, 14);
		frame.getContentPane().add(lblStock);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(82, 261, 118, 20);
		frame.getContentPane().add(textPane_4);
		
		JLabel lblStockminim = new JLabel("stockMinim");
		lblStockminim.setBounds(210, 261, 62, 14);
		frame.getContentPane().add(lblStockminim);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(266, 255, 118, 20);
		frame.getContentPane().add(textPane_5);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Tipus de producte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.setBounds(10, 381, 118, 69);
		frame.getContentPane().add(verticalBox);
		
		JRadioButton rdbtnVendible = new JRadioButton("Vendible");
		buttonGroup_1.add(rdbtnVendible);
		verticalBox.add(rdbtnVendible);
		
		JRadioButton rdbtnIngredient = new JRadioButton("Ingredient");
		buttonGroup_1.add(rdbtnIngredient);
		verticalBox.add(rdbtnIngredient);
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBorder(new TitledBorder(null, "Unitat de mesura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox_1.setBounds(138, 341, 118, 109);
		frame.getContentPane().add(verticalBox_1);
		
		JRadioButton rdbtnLitre = new JRadioButton("Litre");
		buttonGroup.add(rdbtnLitre);
		verticalBox_1.add(rdbtnLitre);
		
		JRadioButton rdbtnGram = new JRadioButton("Gram");
		buttonGroup.add(rdbtnGram);
		verticalBox_1.add(rdbtnGram);
		
		JRadioButton rdbtnUnitat = new JRadioButton("Unitat");
		buttonGroup.add(rdbtnUnitat);
		verticalBox_1.add(rdbtnUnitat);
		
		JButton btnAfegir = new JButton("Afegir");
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
}
