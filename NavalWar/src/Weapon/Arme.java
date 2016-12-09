package Weapon;

import java.util.Arrays;

import java.util.ArrayList;

import BattleShip.Coord;

/*
 * Classe Arme
 * Contient les éléments de base d'une arme
 * Doit être étendue
 */

public abstract class Arme {

	public enum Sens {
		HORIZONTAL, 
		VERTICAL;
	}
	
	// Attributs
	protected String name;
	protected ArrayList<String> needBoat = new ArrayList<String>();
	protected int nbrRestant = 0;
	
	public abstract ArrayList<Coord> zoneImpact(Coord cible, Sens sens);
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getNeedBoat() {
		return this.needBoat;
	}
	
	public int getNbrRestant() {
		return this.nbrRestant;
	}
	
	public void FireInTheHole() {
		this.nbrRestant--;
	}

	@Override
	public String toString() {
		return this.name+" (Arme) [needBoat()=" + this.needBoat + "]";
	}

	
}

