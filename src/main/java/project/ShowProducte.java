package project;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.*;

public class ShowProducte extends JFrame implements Serializable{
	

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame jf = new JFrame("Producte");
		
		
		Producte p1= new Producte();
		jf.setForeground(Color.CYAN);
		String codiProductes[]={""+p1.codiProducte};       
		jf.setLayout(null);  
		jf.setVisible(true);  
		jf.setSize(1600, 800);
		Showid(jf);
	}
	static void Showid(JFrame jf) {
		JLabel l2=new JLabel("id Producte");
		l2.setBounds(50, 50,90,20);
		jf.add(l2); 
		JTextField t1=new JTextField("Busca per id");  
	    t1.setBounds(140,50, 100, 20); 
	    t1.setLayout(null);;
	    t1.setVisible(true);
	    jf.add(t1);
	}
	
}