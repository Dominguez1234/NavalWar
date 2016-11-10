package Weapon;

import BattleShip.Coord;

public class Missile extends AbstractArme {
	public Missile(Coord coord){
		super(coord);
	}

	@Override
	public String[] needBoat() {
		String tab[] = {"Sous-Marin", "Croiseur", "Patrouilleur","Porte-Avion","Destroyer"};
		return tab;
	}

	@Override
	public Coord[] zoneImpact() {
		Coord tabCoord[] =  {this.getCoord()};
		return tabCoord;

	}



}
