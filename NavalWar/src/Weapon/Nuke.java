package Weapon;

/*
 * Nuke
 * Bombe nucléaire, attaque une zone étendue
 */

import java.util.ArrayList;

import BattleShip.Coord;

public class Nuke extends Arme {	
	
	public Nuke() {
		this.name = "Nuke";
		this.needBoat.add("Destroyer");
		this.needBoat.add("Croiseur");
	}
	
	@Override
	public ArrayList<Coord> zoneImpact(Coord cible, Sens sens) {
		int x = cible.x;
		int y = cible.y;
		ArrayList<Coord> listCoord = new ArrayList<Coord>();
		listCoord.add(new Coord(x,y));
		listCoord.add(new Coord(x+1,y));
		listCoord.add(new Coord(x+2,y));
		listCoord.add(new Coord(x-1,y));
		listCoord.add(new Coord(x-2,y));
		listCoord.add(new Coord(x,y+1));
		listCoord.add(new Coord(x,y+2));
		listCoord.add(new Coord(x,y-1));
		listCoord.add(new Coord(x,y-2));
		listCoord.add(new Coord(x+1,y+1));
		listCoord.add(new Coord(x-1,y-1));
		listCoord.add(new Coord(x-1,y+1));
		listCoord.add(new Coord(x+1,y-1));

		return listCoord;
	}
}
