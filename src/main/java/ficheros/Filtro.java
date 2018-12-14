package ficheros;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.Client;
import project.Comanda;
import project.ComandaEstat;
import project.Magatzem;
import project.Producte;
import project.Programa;
import project.Proveidor;
import project.Tipus;


public class Filtro {

	public static ArrayList<Comanda> comandaPerClient(Client c) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = Programa.elMeuMagatzem.getComandes();
		
		for (Comanda ca : allcomandes)
		{
			if(ca.getClient() == c)
			{
				comandes.add(ca);
			}
		}
		return comandes;
	}
	
	public static ArrayList<Comanda> comandaEstat(ComandaEstat ce) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = Programa.elMeuMagatzem.getComandes();
				
		for(Comanda ca : allcomandes)
		{
			if(ca.getEstat() == ce)
			{
				comandes.add(ca);
			}
		}
		
		return comandes;
	}
	
	public ArrayList<Comanda> comandaDataLl(Date d, int i) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = Programa.elMeuMagatzem.getComandes();
				
		for(Comanda ca : allcomandes)
		{
			switch(i) {
			case 0:
				if(ca.getDataLliurament() == d)
				{
					comandes.add(ca);
				}
				break;
			case 1:
				if(ca.getDataLliurament().compareTo(d) >= 0)
				{
					comandes.add(ca);
				}
				break;
			case 2:
				if(ca.getDataLliurament().compareTo(d) <= 0)
				{
					comandes.add(ca);
				}
				break;
				
			}
			
			
		}
		
		return comandes;
	}
	
	public ArrayList<Comanda> comandaDataC(Date d, int i) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = Programa.elMeuMagatzem.getComandes();
		
				
		for(Comanda ca : allcomandes)
		{
			switch(i) {
			case 0:
				if(ca.getDataComanda() == d)
				{
					comandes.add(ca);
				}
				break;
			case 1:
				if(ca.getDataComanda().compareTo(d) >= 0)
				{
					comandes.add(ca);
				}
				break;
			case 2:
				if(ca.getDataComanda().compareTo(d) <= 0)
				{
					comandes.add(ca);
				}
				break;
				
			}
		}
		
		return comandes;
	}
	
	
	
	public ArrayList<Producte> productePerProveidor(Proveidor p)
	{
		ArrayList<Producte> productes = new ArrayList<Producte>();
		
		List<Producte> allproductes = Programa.elMeuMagatzem.getProductes();
		
		for (Producte pr : allproductes)
		{
			if(pr.getProveidor() == p)
			{
				productes.add(pr);
			}
		}
		return productes;
	}
	
	public ArrayList<Producte> productePerTipus(Tipus t)
	{
		
		ArrayList<Producte> productes = new ArrayList<Producte>();
		
		List<Producte> allproductes = Programa.elMeuMagatzem.getProductes();
		
		for (Producte pr : allproductes)
		{
			if(pr.getTipus() == t)
			{
				productes.add(pr);
			}
		}
		
		return productes;
	}
	
	public ArrayList<Producte> producteLessStock(){
		
		ArrayList<Producte> productes = new ArrayList<Producte>();
		
		List<Producte> allproductes = Programa.elMeuMagatzem.getProductes();
		
		for (Producte pr : allproductes)
		{
			if(pr.getStock() < pr.getStockMinim())
			{
				productes.add(pr);
			}
		}
		return productes;
	}
	
	public ArrayList<Producte> productePerPreu(int i){
		
		ArrayList<Producte> productes = new ArrayList<Producte>();
		
		List<Producte> allproductes = Programa.elMeuMagatzem.getProductes();
		
		for (Producte pr : allproductes) {
			switch(i) {
			case 0:
				if(pr.getPreuVenda() > i) {
					productes.add(pr);
				}
				break;
			case 1:
				if(pr.getPreuVenda() < i) {
					productes.add(pr);
				}
				break;
			}
		}
		
		return productes;
	}
	
	
	
	/*
	 * switch(i) {
			case 0:
				
				break;
			case 1:
				break;
			case 2:
				break;
				
			}
	 */
	
}
