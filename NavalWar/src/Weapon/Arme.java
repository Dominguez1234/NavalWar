package Weapon;

import java.util.Arrays;

import java.util.ArrayList;

import BattleShip.Coord;

/*
 * Classe Arme
 * Contient les �l�ments de base d'une arme
 * Doit �tre �tendue
 */

public abstract class Arme {

	public enum Sens {
		HORIZONTAL, 
		VERTICAL;
	}
	
	// Attributs
	protected String name;
	protected ArrayList<String> needBoat = new ArrayList<String>();
	
	public abstract ArrayList<Coord> zoneImpact(Coord cible, Sens sens);
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getNeedBoat() {
		return this.needBoat;
	}

	@Override
	public String toString() {
		return this.name+" (Arme) [needBoat()=" + this.needBoat + "]";
	}

	
}

