package com.snake.beans;

public class Bonus {

	private String nom;
	private String effet;
	private String image;
	private int prix;
	
	public Bonus() {
		this.nom = null;
		this.effet = null;
		this.image = null;
		this.prix = -1;
	}
	
	public Bonus(String pNom, String pEffet, int pPrix) {
		this.nom = pNom;
		this.effet = pEffet;
		this.image = null;
		this.prix = pPrix;
	}
	
	//Getters and Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEffet() {
		return effet;
	}
	public void setEffet(String effet) {
		this.effet = effet;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
}
