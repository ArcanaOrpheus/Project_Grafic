package project;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name = "PeticioProveidor")
public class PeticioProveidor implements Serializable{
	@Id
	@Column(name = "idComanda", updatable = true, nullable = false)
	protected int idComanda;
	
	@Column(name = "tipusPeticio")
	protected int tipusPeticio;
	
	@Column(name = "dataOrdre")
	protected Date dataOrdre;
	
	@Column(name = "dataRecepcio")
	protected Date dataRecepcio;   
	
	@Column(name = "estat")
	protected ComandaEstat estat;
	
	@ManyToOne
	@JoinColumn(name="proveidor")	//relacio n a 1 amb proveidor
	protected Proveidor proveidor;
	
	@ManyToOne
	@JoinColumn(name="producte")	//relacio n a 1 amb producte
	protected Producte producte;
	


}
