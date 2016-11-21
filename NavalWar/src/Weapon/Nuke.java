package Weapon;

import BattleShip.Coord;

public class Nuke extends Arme {
	public void Nuke() {
		
	}

	public String[] needBoat() {
		String tab[] = {"Destroyer", "Croiseur"};
		return tab;
	}
	
	@Override
	public Coord[] zoneImpact(Coord cible, Sens sens) {
		int x = cible.x;
		int y = cible.y;
		Coord tabCoord[] ={
		cible,
		 new Coord(x+1,y),
		 new Coord(x+2,y),
		 new Coord(x-1,y),
		 new Coord(x-2,y),
		 new Coord(x,y+1),
		 new Coord(x,y+2),
		 new Coord(x,y-1),
		 new Coord(x,y-2),
		 new Coord(x+1,y+1),
		 new Coord(x-1,y-1),
		 new Coord(x-1,y+1),
		 new Coord(x+1,y-1)};
		return tabCoord;
	}
}
