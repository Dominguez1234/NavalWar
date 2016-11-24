package Weapon;

import BattleShip.Coord;

public class Torpille extends Arme {

	
	public void Torpille(){
		this.name = "Torpille";
		this.needBat.add("Sous-Marin");
	}

	@Override
	public Coord[] zoneImpact(Coord cible, Sens sens) {
		int x = cible.x;
		int y = cible.y;
		int i;
		Coord[] tabCoord = new Coord[10];
		for(i=0;i<10;i++){
			if (sens.equals(Sens.HORIZONTAL))
				tabCoord[i] = new Coord(x,i);	
			else
				tabCoord[i] = new Coord(i,y);
		}
		return tabCoord;
		
	}
}
