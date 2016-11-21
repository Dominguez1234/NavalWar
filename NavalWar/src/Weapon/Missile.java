package Weapon;

import BattleShip.Coord;

public class Missile extends Arme {
	
	public void Missile() {
		
	}

	public String[] needBoat() {
		String tab[] = {"Sous-Marin", "Croiseur", "Patrouilleur","Porte-Avions","Destroyer"};
		return tab;
	}

	public Coord[] zoneImpact(Coord cible) {
		Coord tabCoord[] = {cible};
		return tabCoord;
	}

}
