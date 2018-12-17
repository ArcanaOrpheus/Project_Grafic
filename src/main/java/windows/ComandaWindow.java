package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ficheros.GestioComandes;
import project.Client;
import project.Comanda;
import project.ComandaEstat;
import project.ComandaLinia;
import project.Programa;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

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
	private int idComanda = 0;
	private LocalDate today = LocalDate.now(ZoneId.of("Europe/Madrid"));
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate nextweek = today.plusDays(7);
	private Client person = new Client();
	private Comanda c = new Comanda();
	private Comanda y = null;
	private Object[] data = {"","",""};
	private ComandaEstat ce = null;
	

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
		Programa.main(null);
		idComanda = Programa.elMeuMagatzem.getComandes().size()+1;
		
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
		lblComanda.setBounds(24, 49, 57, 14);
		frame.getContentPane().add(lblComanda);	
		
		textComanda.setBounds(93, 45, 57, 25);
		frame.getContentPane().add(textComanda);
		textComanda.setText(""+idComanda);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 5));
		panel_1.setBounds(18, 87, 685, 116);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(31, 22, 46, 14);
		panel_1.add(lblClient);
		
		textIdClient.setBounds(629, 11, 46, 20);
		panel_1.add(textIdClient);
		textIdClient.setEditable(false);
		
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(Programa.elMeuMagatzem.getClients().toArray()));
		comboBox.setBounds(89, 19, 532, 20);
		panel_1.add(comboBox);
		comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Client){
                    person = (Client) value;
                    
                    setText(person.getNomClient());
                    textIdClient.setText(person.getIdClient()-1+"");
                }   
               return this;
            }
        } );
		

		
		JLabel lblDatacomanda = new JLabel("dataComanda");
		lblDatacomanda.setBounds(18, 50, 73, 14);
		panel_1.add(lblDatacomanda);
		
		textDataC.setBounds(97, 47, 234, 20);
		panel_1.add(textDataC);
		textDataC.setEditable(false);
		
		JLabel lblDatalliurament = new JLabel("dataLliurament");
		lblDatalliurament.setBounds(341, 50, 83, 14);
		panel_1.add(lblDatalliurament);
		
		textDataLl.setBounds(426, 47, 241, 20);
		panel_1.add(textDataLl);
		
		
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
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce = ComandaEstat.PENDENT;
			}
		});
		verticalBox.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPreparada = new JRadioButton("Preparada");
		buttonGroup.add(rdbtnPreparada);
		rdbtnPreparada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce = ComandaEstat.PREPARADA;
			}
		});
		verticalBox.add(rdbtnPreparada);
		
		JRadioButton rdbtnTransport = new JRadioButton("Transport");
		buttonGroup.add(rdbtnTransport);
		rdbtnTransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce = ComandaEstat.TRANSPORT;
			}
		});
		verticalBox.add(rdbtnTransport);
		
		JRadioButton rdbtnLliurada = new JRadioButton("Lliurada");
		buttonGroup.add(rdbtnLliurada);
		rdbtnLliurada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ce = ComandaEstat.LLIURADA;
			}
		});
		verticalBox.add(rdbtnLliurada);
		
		/*TABLA*/
		String col[] = {"Producte","Quantitat","Preu Venda"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		try {
			for(ComandaLinia cll : Programa.elMeuMagatzem.getComandes().get(idComanda-1).getLinies())
			{
				String nomProd = cll.getProducte().getNomProducte();
				int quant = cll.getQuantitat();
				double preu = cll.getPreuVenda();
				
				data[0] = nomProd;
				data[1] = quant;
				data[2] = preu;
				tableModel.addRow(data);
			}
		} catch (Exception e1) {
		}
		table = new JTable(tableModel);
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.setBounds(20, 216, 809, 182);
		frame.getContentPane().add(jscroll);
		
		
		
		
		
		JLabel lblImportTotal = new JLabel("Import Total");
		lblImportTotal.setBounds(629, 409, 76, 14);
		frame.getContentPane().add(lblImportTotal);
		
		textImport.setBounds(732, 403, 97, 20);
		frame.getContentPane().add(textImport);
		textImport.setEditable(false);

		
		
		textImport.setText("0.0");
		textDataLl.setText(nextweek.format(dtf));
		textDataC.setText(today.format(dtf));
		textPorts.setText("0.0");
		
		JButton btnNewButton_2 = new JButton("Editar Linea");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 403, 105, 23);
		frame.getContentPane().add(btnNewButton_2);
	
	
	
	textComanda.getDocument().addDocumentListener(new DocumentListener() {
		 public void changedUpdate(DocumentEvent e) {
			  
			  }
		 public void removeUpdate(DocumentEvent e) {
			 
			  }
		 public void insertUpdate(DocumentEvent e) {
			  try {
					y = GestioComandes.comandaPerId(Integer.parseInt(textComanda.getText())+1);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					y = null;
				} catch (Exception e1) {
					y = null;
				}
			  if (y != null)
				{
				  Client person2 = y.getClient();
				  comboBox.setSelectedIndex(person2.getIdClient()-2);
				  textIdClient.setText(person2.getIdClient()-1+"");
				  LocalDate lul = y.getDataLliurament().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				  textDataLl.setText(lul.format(dtf));
				  lul = y.getDataComanda().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				  textDataC.setText(lul.format(dtf));
				  textPorts.setText(y.getPortes()+"");
				  ce = y.getEstat();
				  switch(ce)
				  {
				  case PENDENT:
					  rdbtnNewRadioButton.setSelected(true);
					  break;
				  case PREPARADA:
					  rdbtnPreparada.setSelected(true);
					  break;
				  case TRANSPORT:
					  rdbtnTransport.setSelected(true);
					  break;
				  case LLIURADA:
					  rdbtnLliurada.setSelected(true);
					  break;
				  }
				  
				  int count = tableModel.getRowCount();
				  for(int i = count -1; i >= 0; i--)
				  {
					  tableModel.removeRow(i);
				  }
				  
				  for(ComandaLinia cll : y.getLinies())
					{
					  data[0] = cll.getProducte().getNomProducte();
					  data[1] = cll.getQuantitat();
					  data[2] = cll.getPreuVenda();
					  tableModel.addRow(data);
					}
				  table = new JTable(tableModel);
				  jscroll.add(table);
				  try {
					textImport.setText(""+GestioComandes.calcularPreu(y.getIdComanda()));
				} catch (Exception e1) {
					textImport.setText("0");
				}
				}else {
					 int count = tableModel.getRowCount();
					 
					  for(int i = count -1; i >= 0; i--)
					  {
						  tableModel.removeRow(i);
					  }
					  table = new JTable(tableModel);
					  textImport.setText("0.0");
					  jscroll.add(table);
					  textDataLl.setText(nextweek.format(dtf));
					  textDataC.setText(today.format(dtf));
					  textPorts.setText("0.0");
					  ce = null;
					  buttonGroup.clearSelection();
				}
		
			  }
		
	});
	
	JButton btnNovaComanda = new JButton("Nova Comanda");
	btnNovaComanda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			c = new Comanda();
			c.setIdComanda(idComanda+1);
			Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
			c.setDataComanda(date);
			LocalDate lc = LocalDate.parse(textDataLl.getText(), dtf);
			Date date2 = Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
			c.setDataLliurament(date2);
			c.setPortes(Double.parseDouble(textPorts.getText()));
			c.setClient(person);
			c.setEstat(ce);
			
			Programa.elMeuMagatzem.getComandes().add(c);
			System.out.println("Comanda Afegida");
			
			idComanda++;
			textComanda.setText(""+idComanda);
			
			
			
			
		}
	});
	
	btnNovaComanda.setBounds(10, 434, 105, 23);
	frame.getContentPane().add(btnNovaComanda);
	
	JButton btnNewButton = new JButton("Esborrar Comanda");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (y != null)
			{
				if(Programa.elMeuMagatzem.deleteComanda(y))
				{
					System.out.println("Comanda Borrada");
				}
				else
				{
					System.out.println("Comanda no existeix");
				}
			}
		}
	});
	btnNewButton.setBounds(125, 434, 143, 23);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnEditarComanda = new JButton("Editar Comanda");
	btnEditarComanda.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		}
	});
	btnEditarComanda.setBounds(278, 434, 114, 23);
	frame.getContentPane().add(btnEditarComanda);
	
	
	}
}