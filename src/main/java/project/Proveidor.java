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

	public int getIdProveidor() {
		return idProveidor;
	}

	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}

	public String getNomProveidor() {
		return nomProveidor;
	}

	public void setNomProveidor(String nomProveidor) {
		this.nomProveidor = nomProveidor;
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

	//relacio 1 a 1 amb address
	//relacio 1 a n amb peticioproveidor
}