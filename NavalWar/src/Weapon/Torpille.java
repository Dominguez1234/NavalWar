package Weapon;

/*
 * Torpille
 * Parcours une ligne ou colonne entière, jusqu'à l'impact avec un bateau ennemi
 */

import java.util.ArrayList;

import BattleShip.Coord;

public class Torpille extends Arme {

	public Torpille(){
		this.name = "Torpille";
		this.needBoat.add("Sous-Marin");
	}

	@Override
	public ArrayList<Coord> zoneImpact(Coord cible, Sens sens) {
		int x = cible.x;
		int y = cible.y;
		int i;
		ArrayList<Coord> listCoord = new ArrayList<Coord>();
		
		for(i=0;i<10;i++){
			if (sens.equals(Sens.HORIZONTAL))
				listCoord.add(new Coord(x,i));
			else
				listCoord.add(new Coord(i,y));
		}

		return listCoord;
	}
}
