package Weapon;

import BattleShip.Coord;

public class Missile extends AbstractArme implements Arme {
	public Missile(Coord coord){
		super(coord);
	}

	@Override
	public String[] needBoat() {
		String tab[] = {"Sous-Marin", "Croiseur", "Patrouilleur","Porte-Avion","Destroyer"};
		return tab;
	}



}
