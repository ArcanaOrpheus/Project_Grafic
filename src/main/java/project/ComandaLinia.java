package project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ComandaLinia")
public class ComandaLinia implements Serializable{
	

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
}