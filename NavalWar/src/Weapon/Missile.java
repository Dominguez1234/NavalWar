package Weapon;

/*
 * Missile
 * Arme basique, attaque seulement une case
 */

import java.util.ArrayList;

import BattleShip.Coord;

public class Missile extends Arme {
	
	public Missile() {
		this.name = "Missile";
		this.needBoat.add("Porte-Avions");
		this.needBoat.add("Destroyer");
		this.needBoat.add("Sous-Marin");
		this.needBoat.add("Croiseur");
		this.needBoat.add("Patrouilleur");
	}
	
	@Override
	public  ArrayList<Coord> zoneImpact(Coord cible, Sens sens) {
		ArrayList<Coord> listCoord = new ArrayList<Coord>();
		listCoord.add(cible);
		return listCoord;
	}

	

}
