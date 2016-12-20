package au.com.riosoftware.firstapp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;



@Entity
public class fiche implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull
	private String name;
	private String Etat;
	@OneToOne(cascade=CascadeType.ALL)
	private Assurance ass;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Véhicule vehicule ;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Client client;
	


	public fiche(String name, Assurance ass) {
		super();
		this.name = name;
		this.ass = ass;
	}
	public fiche(String ficheName, Assurance assurance, Véhicule véhicule, Client client, String etat) {
		super();
		this.id = id;
		this.name = name;
		Etat = etat;
		this.ass = ass;
		this.vehicule = vehicule;
		this.client = client;

	}
	
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Véhicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Véhicule vehicule) {
		this.vehicule = vehicule;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Assurance getAss() {
		return ass;
	}
	public void setAss(Assurance ass) {
		this.ass = ass;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public fiche(){
	}
	public fiche(String etat2) {
		this.Etat=etat2;
	}

}
