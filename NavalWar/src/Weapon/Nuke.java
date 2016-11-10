package Weapon;

import BattleShip.Coord;

public class Nuke extends Arme {
	public void Nuke(Coord coord) {
		
	}

	public String[] needBoat() {
		String tab[] = {"Destroyer", "Croiseur"};
		return tab;
	}

	public Coord[] zoneImpact(Coord cible) {
		int x = cible.x;
		int y = cible.y;
		Coord coord1 = new Coord(x+1,y);
		Coord coord2 = new Coord(x+2,y);
		Coord coord3 = new Coord(x-1,y);
		Coord coord4 = new Coord(x-2,y);
		Coord coord5 = new Coord(x,y+1);
		Coord coord6 = new Coord(x,y+2);
		Coord coord7 = new Coord(x,y-1);
		Coord coord8 = new Coord(x,y-2);
		Coord coord9 = new Coord(x+1,y+1);
		Coord coord10 = new Coord(x-1,y-1);
		Coord coord11 = new Coord(x-1,y+1);
		Coord coord12 = new Coord(x+1,y-2);
		Coord tabCoord[] = {cible,coord1,coord2,coord3,coord4,coord5,coord6,coord7,coord8,coord9,coord10,coord11,coord12};
		return tabCoord;
	}
}
