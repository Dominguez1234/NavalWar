package BattleShip;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Classe qui permet de stocker les informations 
 * qui seront envoy�es � l'adversaire via le r�seau.
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
	
	// Ajoute une coordonn�e cible (par tireur)
	public void addCible(Coord cible) {
		coordCibles.add(cible);
	}
	
	// Renvoie la liste des coordonn�es vis�es
	public ArrayList<Coord> getCibles() {
		return coordCibles;
	}
	
	// Ajoute une coordonn�e o� un bateau a �t� touch� (par victime)
	public void addTouche(Coord cible) {
		coordTouchees.add(cible);
	}
	
	// Renvoie la liste des coordon�es o� un bateau a �t� touch�
	public ArrayList<Coord> getTouches() {
		return coordTouchees;
	}
	
	// Ajoute le nom d'un bateau qui a �t� coul� (victime)
	public void addBateauCoule(String bat) {
		bateauxCoules.add(bat);
	}
	
	// Renvoie la liste des bateau qui ont �t� coul�s
	public ArrayList<String> getBateauxCoules() {
		return bateauxCoules;
	}

	@Override
	public String toString() {
		String str = "Tir de l'arme "+this.nomArme+" en "+this.coordCibles;
		
		if(!this.coordTouchees.isEmpty())
			str += "\nTouch� aux coordonn�es suivantes : "+this.coordTouchees;
		
		return str;
	}
	
	public String getNomArme() {
		return this.nomArme;
	}
	
}