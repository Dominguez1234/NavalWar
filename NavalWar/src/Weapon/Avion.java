package Weapon;

import java.util.ArrayList;

import BattleShip.Coord;

public class Avion extends Arme{

	public Avion(){
		this.name = "Avion";
		this .needBoat.add("Porte-Avions");
	}
	@Override
	public ArrayList<Coord> zoneImpact(Coord cible, Sens sens) {
	int x = cible.x;
	int y = cible.y;
	int i;
	ArrayList<Coord> listCoord = new ArrayList<Coord>();
		for (i=0;i<3;i++){
			listCoord.add(new Coord(x,y));
			if (sens.equals(Sens.HORIZONTAL))
				y++;
			else
				x++;
		}
		
		return listCoord;
	}

}
