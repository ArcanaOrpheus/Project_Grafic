package project;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.List;

public class Programa implements Serializable{
	
	public static Magatzem elMeuMagatzem = new Magatzem(new ArrayList<Producte>(), new ArrayList<Client>(), new ArrayList<Comanda>(), new ArrayList<Proveidor>());
	
	
	public static void main(String[] args) {
		//1.- Generaci� d'un magatzem petit�
		
		generarDadesBasiques(elMeuMagatzem);
		System.out.println("Veure Magatzem:");
		System.out.println(elMeuMagatzem);
		
		//2.- Veure la composici� dels productes del magatzem
		for(Producte p: elMeuMagatzem.getProductes()) 
			if (p.getTipus() == Tipus.VENDIBLE) 
				System.out.println(p.veureComposicio());
	
		//3.- Veure magatzem ordenat per nom producte
		elMeuMagatzem.getProductes().sort(null);
		System.out.println("3.- Magatzem ordenat per nomProducte");
		System.out.println(elMeuMagatzem);
		
		//4.- Veure magatzem ordenat per stock
		
		System.out.println("3.- Magatzem ordenat per Stock");
		elMeuMagatzem.getProductes().sort(new CompararStock());
		System.out.println(elMeuMagatzem);	
		
		Producte.check(elMeuMagatzem.getProductes().get(0));
	}

	private static void generarDadesBasiques(Magatzem mgz) {
		
		//Prove�dors
		Proveidor pv1 = new Proveidor("UNOproveidor");
		Proveidor pv2 = new Proveidor ("DOSproveidor");
		
		// Productes, composici� i lots
		Producte pliv = new Producte("pLiviano", UnitatMesura.UNITAT,4);
		Producte pllim = new Producte("pLLimona", UnitatMesura.UNITAT,6);
	    Date dataCaducitat;
		Producte p = new Producte("sucre",UnitatMesura.GRAMS,100000);
	    
	    dataCaducitat = Tools.sumarDies(new Date(), 10);
		p.afegirLot(40000,dataCaducitat);
		p.afegirLot(30000, dataCaducitat);		
		dataCaducitat = Tools.sumarDies(dataCaducitat,20);
		p.afegirLot(70000, dataCaducitat);
		
		p.setProveidor(pv1);
		mgz.add(p);
		
		pliv.afegirComponent(p, 115);
		pllim.afegirComponent(p, 4);
		
		p = new Producte("ous", UnitatMesura.UNITAT,240);
		p.afegirLot(480, dataCaducitat);
		mgz.add(p);
		
		pliv.afegirComponent(p, 4);
		
		p = new Producte("farina", UnitatMesura.GRAMS,30000);
		p.afegirLot(10000, dataCaducitat);
		p.afegirLot(20000, dataCaducitat);
		
		p.setProveidor(pv1);
		mgz.add(p);
		
		pliv.afegirComponent(p, 115);
		
		p = new Producte("llevadura", UnitatMesura.GRAMS,5000);
		p.afegirLot(200, (new Date()));
		dataCaducitat = Tools.sumarDies(new Date(), -5);
		p.afegirLot(400, dataCaducitat);
		dataCaducitat = Tools.sumarDies(new Date(), 5);
		p.afegirLot(100, dataCaducitat);
		
		p.setProveidor(pv1);
		mgz.add(p);

		pliv.afegirComponent(p, 10);
		pllim.afegirComponent(p, 8);

		Producte pSec = new Producte("Secret", UnitatMesura.UNITAT,0);
		pSec.setStock(100);

		pliv.afegirComponent(pSec, 1);
		pllim.afegirComponent(pSec, 1);

		p = new Producte("nabius", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		p.setProveidor(pv2);
		mgz.add(p);
		
		pSec.afegirComponent(p, 100);
		mgz.add(pSec);
		
		p = new Producte("llimona", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		
		p.setProveidor(pv2);
		mgz.add(p);
		
		pliv.afegirComponent(p, 40);
		pllim.afegirComponent(p, 4);
		
		p = new Producte("albahaca", UnitatMesura.GRAMS,4000);
		dataCaducitat = Tools.sumarDies(new Date(), 15);
		p.afegirLot(2000, dataCaducitat);
		
		p.setProveidor(pv2);
		mgz.add(p);

		pllim.afegirComponent(pSec, 20);
		
		pliv.setTipus(Tipus.VENDIBLE);
		pllim.setTipus(Tipus.VENDIBLE);
		
		pliv.setPreuVenda(20);
		pllim.setPreuVenda(15);
		pllim.setStock(18);

		mgz.add(pliv);
		mgz.add(pllim);
		
		
		//clients
		Client c1 = new Client("La Canasta", 39.1174353, -5.7933869);
		Client c2 = new Client("Baires", 41.5442476, 2.0604163);
		Client c3 = new Client("Pierre Herme", 48.8513876, 2.3304912);
		Client c4 = new Client("Aux Pains de Papy", 51.5293753, -0.1903852);
		Client c5 = new Client("La Santiaguesa", 40.9284811, -5.2618384);
		mgz.getClients().add(c1);
		mgz.getClients().add(c2);
		mgz.getClients().add(c3);
		mgz.getClients().add(c4);
		mgz.getClients().add(c5);
		
		Comanda m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pliv,100,20));
		m1.getLinies().add(new ComandaLinia(pllim,40,12));
		mgz.getComandes().add(m1);

		m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pllim,20,15));
		m1.getLinies().add(new ComandaLinia(pllim,4,0));
		mgz.getComandes().add(m1);
		
		m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pliv,50,18));
		mgz.getComandes().add(m1);

		m1 = new Comanda(c1);
		m1.getLinies().add(new ComandaLinia (pliv,20,20));
		m1.getLinies().add(new ComandaLinia(pllim,1,0));
		mgz.getComandes().add(m1);
		
	}
	
	
}
