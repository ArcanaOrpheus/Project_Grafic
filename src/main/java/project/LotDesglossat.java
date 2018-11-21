package project;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LotDesglossat")
public class LotDesglossat implements Comparable<LotDesglossat> {

	@Column(name = "quantitat",nullable = false)
	int quantitat = 1;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataEntrada",nullable = false)
	Date dataEntrada = new Date();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataCaducitat")
	Date dataCaducitat = null;
	
	@Column(name = "lot",nullable = false)
	int lot;
	
	LotDesglossat(int qLot, int duracio, int quantitat){
		lot = qLot;
		dataEntrada = new Date();
		this.quantitat = quantitat;
		
		if (duracio>0)	{
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(dataEntrada); 
	      calendar.add(Calendar.DAY_OF_YEAR, duracio);  
	      dataCaducitat = calendar.getTime();
		}
	}
	
	LotDesglossat(int qLot, Date dataCaducitat, int quantitat){
		lot = qLot;
		dataEntrada = new Date();
		this.dataCaducitat = dataCaducitat;
		this.quantitat = quantitat;
	}

	
	public Date getDataCaducitat() {
		return dataCaducitat;
	};
	
	public Date getDataEntrada() {
		return dataEntrada;
	};
	
	public int getQuantitat() {
		return quantitat;
	}
	
	public void setQuantitat (int q) {
		quantitat = q;
	}
	
	@Override
	public String toString() {
		return ("Lot: " + lot + "\tQuantitat: " + quantitat + "\tData Entrada: " + dataEntrada + "\tData Caducitat: " + dataCaducitat);
	}

	@Override	
	public int compareTo(LotDesglossat l) {
		if (this.getDataCaducitat()==null && l.getDataCaducitat() == null) 
			return (this.getDataEntrada().compareTo(l.getDataEntrada()));
		
		if (this.getDataCaducitat()!=null && l.getDataCaducitat() != null) 
			return (this.getDataCaducitat().compareTo(l.getDataCaducitat()));
		
		if (this.getDataCaducitat() == null) 
				return -1;
		
		return 1;

	}
	//relacio n a 1 amb producte
}