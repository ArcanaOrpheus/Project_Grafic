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

import ficheros.GestioComandes;
import project.Client;
import project.Comanda;
import project.Programa;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ComandaWindow {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	static JTextPane textComanda = new JTextPane();
	static JTextPane textIdClient = new JTextPane();
	static JTextPane textDataC = new JTextPane();
	static JTextPane textDataLl = new JTextPane();
	static JTextPane textPorts = new JTextPane();
	static JTextPane textImport = new JTextPane();
	private int idComanda = Programa.elMeuMagatzem.getComandes().size() + 1;
	private LocalDate today = LocalDate.now(ZoneId.of("Europe/Madrid"));
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate nextweek = today.plusDays(7);
	

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
		
		textComanda.setBounds(66, 41, 161, 20);
		frame.getContentPane().add(textComanda);
		textComanda.setText(""+idComanda);
		textComanda.setEditable(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panel_1.setBounds(20, 87, 685, 116);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(31, 22, 46, 14);
		panel_1.add(lblClient);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 19, 532, 20);
		panel_1.add(comboBox);
		
		
		textIdClient.setBounds(629, 11, 46, 20);
		panel_1.add(textIdClient);
		textIdClient.setEditable(false);
		
		JLabel lblDatacomanda = new JLabel("dataComanda");
		lblDatacomanda.setBounds(18, 50, 73, 14);
		panel_1.add(lblDatacomanda);
		
		
		textDataC.setBounds(97, 47, 234, 20);
		panel_1.add(textDataC);
		textDataC.setText(today.format(dtf));
		textDataC.setEditable(false);
		
		
		
		JLabel lblDatalliurament = new JLabel("dataLliurament");
		lblDatalliurament.setBounds(341, 50, 83, 14);
		panel_1.add(lblDatalliurament);
		
		
		textDataLl.setBounds(422, 47, 241, 20);
		panel_1.add(textDataLl);
		textDataLl.setText(nextweek.format(dtf));
		
		JLabel lblPorts = new JLabel("Portes:");
		lblPorts.setBounds(546, 91, 46, 14);
		panel_1.add(lblPorts);
		
		
		textPorts.setBounds(602, 85, 73, 20);
		panel_1.add(textPorts);
		
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
		btnNovaComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Comanda c = new Comanda();
				c.setIdComanda(idComanda);
				Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
				c.setDataComanda(date);
				LocalDate lc = LocalDate.parse(textDataLl.getText(), dtf);
				Date date2 = Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
				c.setDataLliurament(date2);
				c.setPortes(Double.parseDouble(textPorts.getText()));
				Client cli = new Client();
				c.setClient(cli);
				
			}
		});
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
		
		
		textImport.setBounds(732, 403, 97, 20);
		frame.getContentPane().add(textImport);
		textImport.setEditable(false);
		try {
			textImport.setText(""+GestioComandes.calcularPreu(idComanda));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			textImport.setText(""+0);
		}
	}
}