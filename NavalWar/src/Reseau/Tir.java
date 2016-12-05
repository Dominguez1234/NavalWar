package Reseau;

import java.io.Serializable;
import java.util.ArrayList;

import BattleShip.Coord;
import Boats.Bateau;

public class Tir implements Serializable{
	
	private ArrayList<Coord> coordCibles = new ArrayList<>();
	public String nomArme;
	private ArrayList<Coord> coordTouchees = new ArrayList<>();
	private ArrayList<String> bateauxCoules = new ArrayList<>();
	
	public Tir(ArrayList<Coord> coord, String arme) {
		this.coordCibles = coord;
		this.nomArme = arme;
	}
	
	public Tir() {
		
	}
	
	public void addCible(Coord cible) {
		coordCibles.add(cible);
	}
	
	public ArrayList<Coord> getCibles() {
		return coordCibles;
	}
	
	public void addTouche(Coord cible) {
		coordTouchees.add(cible);
	}
	
	public ArrayList<Coord> getTouches() {
		return coordTouchees;
	}
	
	public void addBateauCoule(String bat) {
		bateauxCoules.add(bat);
	}
	
	public ArrayList<String> getBateauxCoules() {
		return bateauxCoules;
	}

	@Override
	public String toString() {
		return "Tir de l'arme "+this.nomArme+" en "+this.coordCibles;
	}
	
}