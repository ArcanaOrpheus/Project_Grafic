package ficheros;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.Client;
import project.Comanda;
import project.ComandaEstat;
import project.Magatzem;
import project.Producte;
import project.Proveidor;


public class Filtro {

	public ArrayList<Comanda> comandaPerClient(Magatzem m, Client c) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = m.getComandes();
		
		for (Comanda ca : allcomandes)
		{
			if(ca.getClient() == c)
			{
				comandes.add(ca);
			}
		}
		return comandes;
	}
	
	public ArrayList<Comanda> comandaEstat(Magatzem m, ComandaEstat ce) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = m.getComandes();
				
		for(Comanda ca : allcomandes)
		{
			if(ca.getEstat() == ce)
			{
				comandes.add(ca);
			}
		}
		
		return comandes;
	}
	
	public ArrayList<Comanda> comandaDataLl(Magatzem m, Date d) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = m.getComandes();
				
		for(Comanda ca : allcomandes)
		{
			if(ca.getDataLliurament() == d)
			{
				comandes.add(ca);
			}
		}
		
		return comandes;
	}
	
	public ArrayList<Comanda> comandaDataC(Magatzem m, Date d) {
		
		ArrayList<Comanda> comandes = new ArrayList<Comanda>();
		
		List<Comanda> allcomandes = m.getComandes();
				
		for(Comanda ca : allcomandes)
		{
			if(ca.getDataComanda() == d)
			{
				comandes.add(ca);
			}
		}
		
		return comandes;
	}
	
	
	
	public ArrayList<Producte> productePerProveidor(Magatzem m, Proveidor p)
	{
		ArrayList<Producte> productes = new ArrayList<Producte>();
		
		List<Producte> allproductes = m.getProductes();
		
		for (Producte pr : allproductes)
		{
			if(pr.getProveidor() == p)
			{
				productes.add(pr);
			}
		}
		return productes;
	}
	
	
	
	
}
