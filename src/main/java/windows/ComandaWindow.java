package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JButton;

public class ComandaWindow {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComandaWindow window = new ComandaWindow();
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
	public ComandaWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 855, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 839, 32);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Comandes TTB");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 133, 14);
		panel.add(lblNewLabel);
		
		JLabel lblComanda = new JLabel("Comanda");
		lblComanda.setBounds(10, 43, 57, 14);
		frame.getContentPane().add(lblComanda);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(77, 37, 161, 20);
		frame.getContentPane().add(textPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panel_1.setBounds(20, 87, 685, 116);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(22, 22, 46, 14);
		panel_1.add(lblClient);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 19, 532, 20);
		panel_1.add(comboBox);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(629, 11, 46, 20);
		panel_1.add(textPane_1);
		
		JLabel lblDatacomanda = new JLabel("dataComanda");
		lblDatacomanda.setBounds(22, 47, 73, 14);
		panel_1.add(lblDatacomanda);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(97, 47, 234, 20);
		panel_1.add(textPane_2);
		
		JLabel lblDatalliurament = new JLabel("dataLliurament");
		lblDatalliurament.setBounds(341, 50, 83, 14);
		panel_1.add(lblDatalliurament);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(434, 44, 241, 20);
		panel_1.add(textPane_3);
		
		JLabel lblPorts = new JLabel("Ports:");
		lblPorts.setBounds(546, 91, 46, 14);
		panel_1.add(lblPorts);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(602, 85, 73, 20);
		panel_1.add(textPane_4);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new TitledBorder(null, "Estat Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		verticalBox.setBounds(715, 43, 114, 116);
		frame.getContentPane().add(verticalBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pendent");
		buttonGroup.add(rdbtnNewRadioButton);
		verticalBox.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPreparada = new JRadioButton("Preparada");
		buttonGroup.add(rdbtnPreparada);
		verticalBox.add(rdbtnPreparada);
		
		JRadioButton rdbtnTransport = new JRadioButton("Transport");
		buttonGroup.add(rdbtnTransport);
		verticalBox.add(rdbtnTransport);
		
		JRadioButton rdbtnLliurada = new JRadioButton("Lliurada");
		buttonGroup.add(rdbtnLliurada);
		verticalBox.add(rdbtnLliurada);
		
		table = new JTable();
		table.setBounds(20, 216, 809, 182);
		frame.getContentPane().add(table);
		
		JButton btnNovaComanda = new JButton("Nova Comanda");
		btnNovaComanda.setBounds(10, 434, 105, 23);
		frame.getContentPane().add(btnNovaComanda);
		
		JButton btnNewButton = new JButton("Esborrar Comanda");
		btnNewButton.setBounds(125, 434, 143, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditarComanda = new JButton("Editar Comanda");
		btnEditarComanda.setBounds(278, 434, 114, 23);
		frame.getContentPane().add(btnEditarComanda);
		
		JButton button = new JButton("<");
		button.setBounds(583, 434, 46, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton(">");
		button_1.setBounds(639, 434, 46, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setBounds(705, 434, 57, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_2 = new JButton(">>");
		button_2.setBounds(772, 434, 57, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblImportTotal = new JLabel("Import Total");
		lblImportTotal.setBounds(629, 409, 76, 14);
		frame.getContentPane().add(lblImportTotal);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(732, 403, 97, 20);
		frame.getContentPane().add(textPane_5);
	}
}
