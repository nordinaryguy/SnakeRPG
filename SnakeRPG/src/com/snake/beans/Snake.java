package com.snake.beans;

import java.util.ArrayList;

public class Snake {
	
	private int iD;
	private int level;
	private int nbEnnemisTues;
	private int nbMorts;
	private int partiesGagnees;
	private int partiesPerdues;
	private int bonusPris;
	
	private String pseudo;
	private String password;
	private String couleur;
	private String image;
	
	private double xP;
	private double score;
	private double argent;
	
	private ArrayList<Bonus> bonusPossedes = new ArrayList<>();

	public Snake() {
		this.iD = -1;
		this.level = 1 ;
		this.nbEnnemisTues = 0;
		this.nbMorts = 0;
		this.partiesGagnees = 0;
		this.partiesPerdues = 0;
		this.bonusPris = 0;
		this.pseudo = null;
		this.password = null;
		this.couleur = null;
		this.image = null;
		this.xP = 0;
		this.score = 0;
		this.argent = 0;
	}
	
	public Snake(String pPseudo, String pPassword, String pCouleur) {
		this.iD = -1;
		this.level = 1 ;
		this.nbEnnemisTues = 0;
		this.nbMorts = 0;
		this.partiesGagnees = 0;
		this.partiesPerdues = 0;
		this.bonusPris = 0;
		this.pseudo = pPseudo;
		this.password = pPassword;
		this.couleur = pCouleur;
		this.image = null;
		this.xP = 0;
		this.score = 0;
		this.argent = 0;
	}
	
	//Getters and Setters
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNbEnnemisTues() {
		return nbEnnemisTues;
	}

	public void setNbEnnemisTues(int nbEnnemisTues) {
		this.nbEnnemisTues = nbEnnemisTues;
	}

	public int getNbMorts() {
		return nbMorts;
	}

	public void setNbMorts(int nbMorts) {
		this.nbMorts = nbMorts;
	}

	public int getPartiesGagnees() {
		return partiesGagnees;
	}

	public void setPartiesGagnees(int partiesGagnees) {
		this.partiesGagnees = partiesGagnees;
	}

	public int getPartiesPerdues() {
		return partiesPerdues;
	}

	public void setPartiesPerdues(int partiesPerdues) {
		this.partiesPerdues = partiesPerdues;
	}

	public int getBonusPris() {
		return bonusPris;
	}

	public void setBonusPris(int bonusPris) {
		this.bonusPris = bonusPris;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getxP() {
		return xP;
	}

	public void setxP(double xP) {
		this.xP = xP;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getArgent() {
		return argent;
	}

	public void setArgent(double argent) {
		this.argent = argent;
	}

	public ArrayList<Bonus> getBonusPossedes() {
		return bonusPossedes;
	}

	public void setBonusPossedes(ArrayList<Bonus> pBonusPossedes) {
		this.bonusPossedes = pBonusPossedes;
	}
}
