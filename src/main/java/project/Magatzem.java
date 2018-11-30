package project;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Magatzem")
public class Magatzem implements Serializable{
	@Id ()
	@Column(name = "magatzem")
	private List<Producte> magatzem = new ArrayList <Producte>();
	
	@Column(name = "clients")
	private List<Client>  clients = new ArrayList <Client> ();
	
	@Column(name = "comandes")
	private List<Comanda> comandes = new ArrayList <Comanda>();
	
	@Column(name = "proveidors")
	private List<Proveidor> proveidors = new ArrayList <Proveidor>(); 
    
	Magatzem(){
	}
	
	Magatzem(List<Producte> lp, List<Client> lc, List<Comanda> lm, List<Proveidor> lpv){
		magatzem = lp;
		clients = lc;
		comandes = lm;
		proveidors = lpv;
	}
	
	boolean afegirQuantitatProducte(int codiProducte, int quantitat){
		boolean trobat = false;
		for (Producte p: magatzem) {
			if (p.getCodiProducte() == codiProducte) {
				p.setStock(p.getStock() + quantitat);
				trobat = true;
				break;
			}
		}
		return trobat;
	}
	
	boolean afegirProducte(Producte prod) {
		boolean trobat = false;
		for (Producte p: magatzem) {
			if (p.getCodiProducte() == prod.getCodiProducte()) {
				trobat = true;
				break;
			}
		}
		if (trobat) 
			return false;
		else {
			magatzem.add(prod);
			return true;
		}
	}
	
	public List <Producte>getProductes(){
		return magatzem;
	}
	
	public List <Client> getClients(){
		return clients;
	}
	
	public List<Comanda> getComandes(){
		return comandes;
	}
	
	public List<Proveidor> getProveidors(){
		return proveidors;
	}
	
	public Deque<LotDesglossat> apilarCaducats () {
		Iterator<LotDesglossat> it = null;		
		Deque<LotDesglossat> pila = new ArrayDeque<LotDesglossat>();
		LotDesglossat ldg;
		Date avui = new Date();
		for (Producte p: magatzem) {
			it = p.lots.iterator();
			while (it.hasNext()) {
				ldg = it.next();
				if(ldg.getDataCaducitat().compareTo(avui)<0) {
					pila.push((ldg));
					it.remove();
				}
			}
		}
		return pila;
	}
		
	
	public boolean add(Producte p) {
		magatzem.add(p);
		return true;
	}
	
	public boolean delete(Producte p) {
		magatzem.remove(p);
		return true;
	}
	
	public void modify(Producte p) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Que quieres modificar?");
		System.out.println("1-Codi Producte");
		System.out.println("2-Nom Producte");
		System.out.println("3-Stock minim");
		System.out.println("4-Unitat de mesura");
		System.out.println("5-Tipus");
		System.out.println("6-Proveidor");
		System.out.println("7-Preu Venda");
		System.out.println("8-Pes");
		System.out.println("9-Composicio");
		int i= sc.nextInt();
		switch(i) {
		case 1:
			System.out.println("Introduir nou codi producte: ");
			int code = sc.nextInt();
			magatzem.get(magatzem.indexOf(p)).codiProducte=code;
			break;
		case 2:
			System.out.println("Introduir nou nom del Producte(sense espais: ");
			String name = sc.next();
			magatzem.get(magatzem.indexOf(p)).nomProducte=name;
			break;
		case 3:
			System.out.println("Introduir nou stock minim: ");
			int stock = sc.nextInt();
			magatzem.get(magatzem.indexOf(p)).stockMinim=stock;
			break;
		case 4:
			System.out.println("Nova unitat de mesura: ");
			String string = sc.next();
			magatzem.get(magatzem.indexOf(p)).unitat=Enum.valueOf(UnitatMesura.class, string);
			break;
		case 5:
			System.out.println("Nou tipus: ");
			String string2 = sc.next();
			magatzem.get(magatzem.indexOf(p)).tipus=Enum.valueOf(Tipus.class, string2);
			break;
		case 6:
			System.out.println("Introduir codi nou proveidor: ");
			int cp= sc.nextInt();
			List<Proveidor> lp = getProveidors();
			Proveidor proveidor= null;
			for(Proveidor prov: lp) {
				if(prov.idProveidor==cp) {
					proveidor=prov;
				}
			}
			magatzem.get(magatzem.indexOf(p)).proveidor=proveidor;
			break;
		case 7:
			System.out.println("Introduir nou preu: ");
			double preu = sc.nextDouble();
			magatzem.get(magatzem.indexOf(p)).preuVenda=preu;
			break;
		case 8:
			System.out.println("Introduir nou pes: ");
			double pes = sc.nextDouble();
			magatzem.get(magatzem.indexOf(p)).pes=pes;
			break;
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for (Producte p : magatzem)
			s +=  "\n" + p;
		s += "\nTotal " + magatzem.size() + " Refer�ncies";
		return s;
	}
		
}
