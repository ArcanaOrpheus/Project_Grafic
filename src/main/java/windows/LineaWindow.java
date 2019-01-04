package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import project.ComandaLinia;
import project.Producte;
import project.Programa;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LineaWindow {

	private JFrame frame;
	private JTable composicio;
	private JTextField quantitat;
	private JTextField preuV;
	private Producte p = new Producte();
	private int q = 0;
	private Double preu = 0.0;
	private Object[] data = {"","",""};
	private int click;
	
	/**
	 * Launch the application.
	 */
	public static void main(int comandaid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LineaWindow window = new LineaWindow(comandaid);
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
	public LineaWindow(int comandaid) {
		initialize(comandaid);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	protected static void initialize(int comandaid) {
	

		JDialog frame = new JDialog();

		frame.setVisible(true);
		frame.setBounds(100, 100, 643, 532);
		frame.getContentPane().setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 1013, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Object[] data = {"","",""};
		JTextField quantitat;
		JTextField preuV;
		Producte p = new Producte();
		int q = 0;
		Double preu = 0.0;
		int click;
		
		JLabel lblNewLabel = new JLabel("Linea Comanda "+comandaid);
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 11, 161, 14);
		panel.add(lblNewLabel);
		
		
		String col[] = {"Producte","Quantitat","Preu Venda"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		try {
			for(ComandaLinia cll : ComandaWindow.cl)
			{
				String nomProd = cll.getProducte().getNomProducte();
				int quant = cll.getQuantitat();
				double preu2 = cll.getPreuVenda();
				
				data[0] = nomProd;
				data[1] = quant;
				data[2] = preu2;
				tableModel.addRow(data);
			}
		} catch (Exception e1) {
		}
		JTable composicio = new JTable(tableModel);
		JScrollPane jscroll = new JScrollPane(composicio);
		jscroll.setBounds(22, 162, 578, 220);
		frame.getContentPane().add(jscroll);
		
		JLabel lblQuantitat = new JLabel("Quantitat");
		lblQuantitat.setBounds(285, 67, 56, 16);
		frame.getContentPane().add(lblQuantitat);
		
		quantitat = new JTextField();
		quantitat.setBounds(381, 64, 116, 22);
		frame.getContentPane().add(quantitat);
		quantitat.setColumns(10);
		quantitat.setText(""+0);

		JLabel lblPreu = new JLabel("Preu Venda");
		lblPreu.setBounds(285, 102, 75, 16);
		frame.getContentPane().add(lblPreu);
		
		preuV = new JTextField();
		preuV.setBounds(381, 99, 116, 22);
		frame.getContentPane().add(preuV);
		preuV.setColumns(10);
		preuV.setText(0.0+"");
		
		JLabel lblProducte = new JLabel("Producte");
		lblProducte.setBounds(22, 67, 56, 16);
		frame.getContentPane().add(lblProducte);
		
		ArrayList<Producte> newProd = new ArrayList<>();
		String nomprod = "";
		for(Producte pl : Programa.elMeuMagatzem.getProductes())
		{
			if(!pl.getNomProducte().equals(nomprod)) {
				newProd.add(pl);
			}
			nomprod = pl.getNomProducte();
		}
		
		
		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(newProd.toArray()));
		comboBox.setBounds(90, 64, 136, 22);
		frame.getContentPane().add(comboBox);
		comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Producte){
                    Producte p = (Producte) value;
                    
                    setText(p.getNomProducte());
                }   
               return this;
            }
        } );
		
		
		JButton btnAfegir = new JButton("Afegir");
		btnAfegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producte p = (Producte) comboBox.getSelectedItem();
				int q = Integer.parseInt(quantitat.getText());
				Double preu = Double.parseDouble(preuV.getText());
				ComandaLinia com = new ComandaLinia(p,q,preu);
				ComandaWindow.cl.add(com);
				data[0] = p.getNomProducte();
				data[1] = q;
				data[2] = preu;
				tableModel.addRow(data);
			}
		});
		btnAfegir.setBounds(22, 411, 97, 25);
		frame.getContentPane().add(btnAfegir);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int click = composicio.getSelectedRow();
				tableModel.removeRow(click);
				ComandaWindow.cl.remove(click);
			}
		});
		btnBorrar.setBounds(129, 411, 97, 25);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		btnSortir.setBounds(516, 449, 97, 25);
		frame.getContentPane().add(btnSortir);
		
	}
}
