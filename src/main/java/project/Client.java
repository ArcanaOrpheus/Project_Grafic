package project;

import java.io.Serializable;
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

	public Client() {
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPersonaContacte() {
		return personaContacte;
	}

	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return nomClient;
	}
	
	
	
	
}