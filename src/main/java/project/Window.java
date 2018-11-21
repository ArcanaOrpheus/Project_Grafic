package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;

public class Window {

	private JFrame frmProducte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmProducte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProducte = new JFrame();
		frmProducte.setTitle("Producte");
		frmProducte.setBounds(100, 100, 731, 539);
		frmProducte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
