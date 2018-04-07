package com.snake.beans;

public class Bonus {

	private int id;
	private int idsnakeassocie;
	
	private String nom;
	private String effet;
	private String image;
	private int prix;
	
	public Bonus() {
		this.nom = null;
		this.effet = null;
		this.image = null;
		this.prix = -1;
		this.id = -1;
		this.idsnakeassocie = -1;
	}
	
	public Bonus(int pId, String pNom, String pEffet, String pImage, int pPrix, int pIdSnakeAssocie) {
		this.id = pId;
		this.nom = pNom;
		this.effet = pEffet;
		this.image = pImage;
		this.prix = pPrix;
		this.idsnakeassocie = pIdSnakeAssocie;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdsnakeassocie() {
		return idsnakeassocie;
	}

	public void setIdsnakeassocie(int idsnakeassocie) {
		this.idsnakeassocie = idsnakeassocie;
	}
}
