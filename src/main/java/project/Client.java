package project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client implements Serializable{
	@Id
	@Column(name = "idClient", updatable = true, nullable = false)
	protected int idClient;
	
	@Column(name = "nomClient",updatable = true, nullable = false)
	protected String nomClient;
	
	@Column(name = "CIF",updatable = true)
	protected String CIF;
	
	@Column(name = "actiu",updatable = true)
	protected boolean actiu;
	
	@Column(name = "direccio",updatable = true)
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

	Client() {
		idClient = Generador.getNextClient();
	}

	Client(String nom) {
		this();
		nomClient = nom;
	}

	Client(String nom, double lat, double lon) {
		this(nom);
		latitud = lat;
		longitud = lon;
	}
	//relacio 1 a n amb comanda
	//relacio 1 a 1 amb adreça
}