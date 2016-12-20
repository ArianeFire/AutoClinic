package au.com.riosoftware.firstapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Véhicule")

public class Véhicule {
	
	@Id
	@Column(name = "IdVéhicule")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	private String marque ;
	private String Modéle;
	private String immatriculation;
	private int NumChassais;
	private String kilométrage;
	private String nivcarburant;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public Véhicule(String marque, String modéle, String immatriculation, int numChassais, String kilométrage,
			String nivcarburant) {
		super();
		this.marque = marque;
		Modéle = modéle;
		this.immatriculation = immatriculation;
		NumChassais = numChassais;
		this.kilométrage = kilométrage;
		this.nivcarburant = nivcarburant;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModéle() {
		return Modéle;
	}
	public void setModéle(String modéle) {
		Modéle = modéle;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public int getNumChassais() {
		return NumChassais;
	}
	public void setNumChassais(int numChassais) {
		NumChassais = numChassais;
	}
	public String getKilométrage() {
		return kilométrage;
	}
	public void setKilométrage(String kilométrage) {
		this.kilométrage = kilométrage;
	}
	public String getNivcarburant() {
		return nivcarburant;
	}
	public void setNivcarburant(String nivcarburant) {
		this.nivcarburant = nivcarburant;
	}

}
