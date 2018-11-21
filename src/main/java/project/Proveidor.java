package project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Proveidor")
public class Proveidor implements Serializable{
	@Id
	@Column(name = "idProveidor")
	protected int idProveidor;
	
	@Column(name = "nomProveidor")
	protected String nomProveidor;
	
	@Column(name = "CIF")
	protected String CIF;
	
	@Column(name = "actiu")
	protected boolean actiu;
	
	@Column(name = "direccio")
	protected String direccio;
	
	@Column(name = "poblacio")
	protected String poblacio;
	
	@Column(name = "pais")
	protected String pais;
	
	@Column(name = "personaContacte")
	protected String personaContacte;
	
	@Column(name = "telefon")
	protected String telefon;
	
	@Column(name = "latitud")
	protected double latitud;
	
	@Column(name = "longitud")
	protected double longitud;	
	Proveidor(){
		idProveidor = Generador.getNextProveidor();
	}
	
	Proveidor(String nom){
		this();
		nomProveidor = nom;
	}

	//relacio 1 a 1 amb address
	//relacio 1 a n amb peticioproveidor
}