package Weapon;

import java.util.ArrayList;

import BattleShip.Coord;

public class Missile extends Arme {
	
	public Missile() {
		this.name = "Missile";
		this.needBat.add("Porte-Avions");
		this.needBat.add("Destroyer");
		this.needBat.add("Sous-Marin");
		this.needBat.add("Croiseur");
		this.needBat.add("Patrouilleur");
	}
	@Override
	public  ArrayList<Coord> zoneImpact(Coord cible, Sens sens) {
		ArrayList<Coord> listCoord = new ArrayList<Coord>();
		listCoord.add(cible);
		return listCoord;
	}

	

}
