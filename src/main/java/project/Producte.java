package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Producte")
public class Producte implements Comparable<Producte>, Serializable {
	@Id()
	@Column(name = "codiProducte")
	protected int codiProducte;

	@Column(name = "nomProducte")
	protected String nomProducte;
	
	@Column(name = "stock")
	protected int stock;
	
	@Column(name = "stockMinim")
	protected int stockMinim;
	
	@Column(name = "unitat")
	protected UnitatMesura unitat;
	
	@Column(name = "composicio")
	protected Map<Producte, Integer> composicio;	
	
	@OneToMany(mappedBy="curso", cascade= CascadeType.ALL)
	protected List <LotDesglossat> lots;
	
	@Column(name = "tipus")
	protected Tipus tipus;
	
	@Column(name = "proveidor")
	protected Proveidor proveidor;
	
	@Column(name = "preuVenda")
	protected double preuVenda;
	
	@Column(name = "pes")
	protected double pes;
	
	public void afegirLot (int quantitat, Date dataCaducitat) {
		int qLot = Generador.getNextLot();
		lots.add(new LotDesglossat(qLot,dataCaducitat,quantitat));
	}
	
	public String veureLots() {
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}
	
	public String getNomProducte() {
		return nomProducte;
	}

	public void setNomProducte(String nom) {
		nomProducte = nom;
	}

	@Override
	public String toString() {
		String cadena = "Producte: " + codiProducte + "\t - " + nomProducte + "\tStock Total: " + getStock() + " " + unitat ;
		cadena = cadena + "\tStockM�nim:" + stockMinim + "\t" + tipus;
		return cadena;
	}

	Producte() {
		codiProducte = Generador.getNextProducte();
		lots = new ArrayList<LotDesglossat>();
		composicio = new HashMap<Producte,Integer>();
		tipus = Tipus.INGREDIENT;
		stockMinim = 0;
		stock = 0;
	}

	Producte(String nomProducte){
		this();
		this.nomProducte = nomProducte;
	}
	
	Producte(String nomProducte, UnitatMesura u, int sm){
		this(nomProducte);
		this.setUnitatMesura(u);
		this.stockMinim = sm;
	};
	
	
	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}
	
	public Tipus getTipus() {
		return tipus;
	}
	
	public void setProveidor(Proveidor pv) {
		this.proveidor = pv;
	}
	
	public Proveidor getProveidor() {
		return proveidor;
	}
	
	
	public UnitatMesura getUnitatMesura() {
		return unitat;
	}

	public void setUnitatMesura(UnitatMesura unitatm) {
		unitat = unitatm;
	}

	void setStock(int q) {
		stock = q;
	}

	public void setStockMinim(int stockM) {
		stockMinim = stockM;
	}

	public int getStockMinim() {
		return stockMinim;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public Map <Producte,Integer> getComposicio() {
		return composicio;
	}

	public void afegirComponent(Producte p, int q) {
		composicio.put(p, q);
	}

	public String veureComposicio() {
		String cadena = "";
		Set<Producte> claus = composicio.keySet();
		cadena = getNomProducte() + " --> ";
		for(Producte p: claus)  
			cadena += p.getNomProducte() + "(" + composicio.get(p) + ") ";
		return cadena;
	}
	
	public int compareTo(Producte p) {
		return (getNomProducte().compareTo(p.getNomProducte()));
	}

	public int getCodiProducte() {
		return codiProducte;
	}

	private int calcularStockLote() {
		int q =0;
		for(LotDesglossat l:lots) {
			q+=l.getQuantitat();
		}
		return q;
	}
	
	
	public int getStock() {
		return(stock + this.calcularStockLote());
	}
	
	public String veureLotsOrdenats() {
		lots.sort(null);
		String cadena = "";
		for(LotDesglossat ld: lots) {
			cadena+="   "+ ld + "\n";
		}
		return cadena;
	}

	public boolean Add(Magatzem mg, Producte p) {
		mg.add(p);
		return true;
	}

	public boolean Delete(Magatzem mg, Producte p) {
		List <Producte> lp = mg.getProductes();
		int i=(Integer) null;
		for(Producte p2: lp) {
			if(p2.equals(p)) {
				i=lp.indexOf(p2);
			}
		}
		mg.getProductes().remove(i);
		return true;
	}
	
	public static void check(Producte p) {
		Map<Producte, Integer> l= p.getComposicio();
		System.out.println(p.nomProducte+" composicio");
		for(Producte p2: l.keySet()) {
			System.out.println(p2+" "+l.get(p2));
		}
}
	
	//relacio 1 a n amb lot
	//relacio n a n amb ell mateix
	//relacio 1 a n amb peticionsproveidor
	//relacio n a n amb comanda
	
	
}