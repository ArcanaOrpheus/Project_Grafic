package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Comanda")
public class Comanda implements Serializable{
	@Id ()
	@Column(name = "idComanda",nullable = false)
	protected int idComanda;
	
	@Column(name = "client",nullable = false)
	protected Client client;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataComanda",nullable = false)
	protected Date dataComanda;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataLliurament",nullable = false)
	protected Date dataLliurament;   
	
	public Date getDataComanda() {
		return dataComanda;
	}

	public Date getDataLliurament() {
		return dataLliurament;
	}

	public ComandaEstat getEstat() {
		return estat;
	}

	@Column(name = "estat",nullable = false)
	protected ComandaEstat estat;	

	@Column(name = "portes")
	protected Double portes;	

	@Column(name = "linies")
	protected List <ComandaLinia> linies;
	
	public Comanda() {
		idComanda = Generador.getNextComanda();
		dataComanda = new Date();
		dataLliurament = Tools.sumarDies(new Date(), 1);
		estat = ComandaEstat.PENDENT;
		portes = 0.0;
		linies = new ArrayList<ComandaLinia>();
	}

	Comanda(Client client) {
		this();
		this.client = client;
	};	
	

	public List <ComandaLinia> getLinies (){
		return linies;
	}
	
	Comparator<Comanda> cmp_id2 = new Comparator<Comanda>()
	{
		@Override
		public int compare(Comanda c1, Comanda c2) {
			return c2.idComanda - c1.idComanda;
		}

	};
	
	Comparator<Comanda> cmp_id = new Comparator<Comanda>()
	{
		@Override
		public int compare(Comanda c1, Comanda c2) {
			return c1.idComanda - c2.idComanda;
		}

	};
	
	
	//relacio n a n amb producte
		//relacio n a 1 amb client

	public Client getClient() {
		return client;
	}
	
	

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}

	public void setDataLliurament(Date dataLliurament) {
		this.dataLliurament = dataLliurament;
	}

	public void setEstat(ComandaEstat estat) {
		this.estat = estat;
	}

	public void setPortes(Double portes) {
		this.portes = portes;
	}

	public void setLinies(List<ComandaLinia> linies) {
		this.linies = linies;
	}

	public void setCmp_id2(Comparator<Comanda> cmp_id2) {
		this.cmp_id2 = cmp_id2;
	}

	public void setCmp_id(Comparator<Comanda> cmp_id) {
		this.cmp_id = cmp_id;
	}
	
	
}