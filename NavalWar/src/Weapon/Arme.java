package Weapon;

import java.util.ArrayList;
import BattleShip.Coord;

public abstract class Arme {
	
	protected String name;
	ArrayList<String> needBat = new ArrayList<String>();
	
	public String getName() {
		return this.name;
	}

//	public abstract String[] needBoat();
	public abstract Coord[] zoneImpact(Coord cible);
	
	public ArrayList<String> getNeedBoat() {
		return this.needBat;
	}
	
	@Override
	public String toString() {
		return this.name+" (Arme) [needBoat()=" + this.needBat + "]";
	}
	
}

