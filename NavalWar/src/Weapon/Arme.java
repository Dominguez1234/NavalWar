package Weapon;

import java.util.Arrays;


import BattleShip.Coord;

public abstract class Arme {
	
	public enum Sens {
		HORIZONTAL, VERTICAL;

	}
	
	protected String name;
	
	public String getName() {
		return this.name;
	}

	public abstract String[] needBoat();
	public abstract Coord[] zoneImpact(Coord cible, Sens sens);
	
	@Override
	public String toString() {
		return this.name+" (Arme) [needBoat()=" + Arrays.toString(needBoat()) + "]";
	}

	
}

