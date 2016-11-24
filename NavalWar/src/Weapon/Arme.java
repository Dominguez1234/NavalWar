package Weapon;

import java.util.Arrays;

import java.util.ArrayList;

import BattleShip.Coord;

public abstract class Arme {
	
	public enum Sens {
		HORIZONTAL, 
		VERTICAL;
	}
	
	protected String name;
	protected ArrayList<String> needBat = new ArrayList<String>();
	
	public abstract ArrayList<Coord> zoneImpact(Coord cible, Sens sens);
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getNeedBoat() {
		return this.needBat;
	}

	@Override
	public String toString() {
		return this.name+" (Arme) [needBoat()=" + this.needBat + "]";
	}

	
}

