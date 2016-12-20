package com.autoclinic.MODEL;


public class Piece {
	

	private String name;
	private String categorie;


	public Piece(String name, String cetegorie) {
		super();
		this.name = name;
		this.categorie = cetegorie;
	}
	public Piece(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}

