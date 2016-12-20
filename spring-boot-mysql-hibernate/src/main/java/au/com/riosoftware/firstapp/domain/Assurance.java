package au.com.riosoftware.firstapp.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Assurance")
public class Assurance implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Name;
	
	@OneToMany(targetEntity=fiche.class ,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 private Set<fiche> fiches;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<fiche> getFiches() {
		return fiches;
	}

	public void setFiches(Set<fiche> fiches) {
		this.fiches = fiches;
	}
	
	 public String getName() {
	  return Name;
	 }
	 
	 public void setName(String Name) {
	  this.Name = Name;
	 }
	
	
		public Assurance( String name) {
			this.Name = name;
		}
		public Assurance(){	
		}
}
