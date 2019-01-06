package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.TitledBorder;

import project.Tipus;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaWindow {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private Tipus tipu = null;

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
		
		JLabel lblNewLabel_2 = new JLabel("Nom Producte");
		lblNewLabel_2.setBounds(177, 48, 90, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(265, 46, 263, 20);
		panel.add(comboBox);
		
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
		chckbxSolament.setBackground(new Color(100, 149, 237));
		chckbxSolament.setBounds(730, 7, 190, 23);
		panel.add(chckbxSolament);
		
		JLabel lblNewLabel_3 = new JLabel("Proveeïdor");
		lblNewLabel_3.setBounds(9, 91, 63, 14);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(88, 89, 192, 20);
		panel.add(comboBox_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(827, 114, 89, 23);
		panel.add(btnBuscar);
		
		table = new JTable();
		table.setBounds(1, 144, 933, 334);
		frame.getContentPane().add(table);
	}
}
