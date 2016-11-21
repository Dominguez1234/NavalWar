package Weapon;

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
	public Coord[] zoneImpact(Coord cible, Sens sens) {
		Coord tabCoord[] = {cible};
		return tabCoord;
	}

	

}
