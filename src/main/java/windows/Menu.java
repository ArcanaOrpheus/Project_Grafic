package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.Programa;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		Programa.main(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaWindow.main(null);
			}
		});
		btnNewButton.setBounds(244, 92, 201, 34);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Gestió de Productes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProducteWindow.main(null);
			}
		});
		button.setBounds(244, 133, 201, 34);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Gestió de Comandes");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComandaWindow.main(null);
			}
		});
		button_1.setBounds(244, 175, 201, 34);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/tastat.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(12, 13, 243, 236);
		contentPane.add(lblNewLabel);
		
		JLabel lblTastatBlau = new JLabel("Tastat Blau");
		lblTastatBlau.setFont(new Font("Stencil", Font.PLAIN, 30));
		lblTastatBlau.setBounds(199, 26, 232, 45);
		contentPane.add(lblTastatBlau);
	}
}
