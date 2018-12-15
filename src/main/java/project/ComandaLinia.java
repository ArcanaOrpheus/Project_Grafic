package project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ComandaLinia")
public class ComandaLinia implements Serializable{
	
	@Id ()
	@Column(name = "producte",nullable = false)
	protected Producte producte;
	
	
	@Column(name = "quantitat",nullable = false)
	protected int quantitat;
	
	@Column(name = "preuVenda",nullable = false)
	protected double preuVenda;
	
	ComandaLinia(Producte p, int q, double preu) {
		producte = p;
		quantitat = q;
		preuVenda = preu;
	}

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public double getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(double preuVenda) {
		this.preuVenda = preuVenda;
	}
	
	
}