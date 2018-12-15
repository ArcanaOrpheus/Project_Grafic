package Windows;

import java.util.List;
import java.util.ArrayList;

import project.*;

public class Program {
	static ProducteWindow pw= new ProducteWindow();
	public static void main(String[] args) {
		create();
	}
	static Magatzem mgz ;
	public static void create() {
	mgz = new Magatzem(new ArrayList<Producte>(), new ArrayList<Client>(), new ArrayList<Comanda>(), new ArrayList<Proveidor>());
	Programa.generarDadesBasiques(mgz);
	System.out.println("Veure Magatzem:");
	System.out.println(mgz);
	pw.main(null);
	}
	
	public void ViewProd() {
		List<Producte> lp = mgz.getProductes();
		for(Producte p : lp) {
			
		}
	}
	
	public static void addProducte(Producte p) {
		mgz.add(p);
		System.out.println("Producte afegit");
	}
	public static void delProducte(String s) throws Exception{
		try {
			Producte p = null;
			for(Producte p2 : mgz.getProductes()) {
				if(p2.getNomProducte().equals(s)) p=p2;
			}
			mgz.getProductes().remove(mgz.getProductes().indexOf(p));
			System.out.println("Producte esborrat");
		} catch (Exception e) {
			e= new Exception("Producte inexistent");
		}
		
	}
	
}
