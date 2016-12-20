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
@Table(name = "Client")
public class Client {
	
@Id
@Column(name = "IdClient")
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;


private String noms;
private String Adresse;
private int telMobile;
private int fax;
private String Email;
private int tel;

public Client(String noms, String adresse, int telMobile, int fax, String email, int tel) {
	super();
	this.id = id;
	this.noms = noms;
	Adresse = adresse;
	this.telMobile = telMobile;
	this.fax = fax;
	Email = email;
	this.tel = tel;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public int getTel() {
	return tel;
}

public void setTel(int tel) {
	this.tel = tel;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getNoms() {
	return noms;
}
public void setNoms(String noms) {
	this.noms = noms;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}

public int getTelMobile() {
	return telMobile;
}
public void setTelMobile(int telMobile) {
	this.telMobile = telMobile;
}
public int getFax() {
	return fax;
}
public void setFax(int fax) {
	this.fax = fax;
}
}
