package BattleShip;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Classe qui permet de stocker les informations 
 * qui seront envoyées à l'adversaire via le réseau.
 */

public class Tir implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Attributs 
	private ArrayList<Coord> coordCibles = new ArrayList<>();
	private String nomArme;
	private ArrayList<Coord> coordTouchees = new ArrayList<>();
	private ArrayList<String> bateauxCoules = new ArrayList<>();
	public boolean gameOver;
	
	// Constructeurs
	public Tir(ArrayList<Coord> coord, String arme) {
		this.coordCibles = coord;
		this.nomArme = arme;
	}
	
	public Tir() {
		
	}
	
	// Ajoute une coordonnée cible (par tireur)
	public void addCible(Coord cible) {
		coordCibles.add(cible);
	}
	
	// Renvoie la liste des coordonnées visées
	public ArrayList<Coord> getCibles() {
		return coordCibles;
	}
	
	// Ajoute une coordonnée où un bateau a été touché (par victime)
	public void addTouche(Coord cible) {
		coordTouchees.add(cible);
	}
	
	// Renvoie la liste des coordonées où un bateau a été touché
	public ArrayList<Coord> getTouches() {
		return coordTouchees;
	}
	
	// Ajoute le nom d'un bateau qui a été coulé (victime)
	public void addBateauCoule(String bat) {
		bateauxCoules.add(bat);
	}
	
	// Renvoie la liste des bateau qui ont été coulés
	public ArrayList<String> getBateauxCoules() {
		return bateauxCoules;
	}

	@Override
	public String toString() {
		String str = "Tir de l'arme "+this.nomArme+" en "+this.coordCibles;
		
		if(!this.coordTouchees.isEmpty())
			str += "\nTouché aux coordonnées suivantes : "+this.coordTouchees;
		
		return str;
	}
	
	public String getNomArme() {
		return this.nomArme;
	}
	
}