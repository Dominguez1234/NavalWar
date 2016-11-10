package Weapon;

import BattleShip.Coord;

public interface Arme {
	
	public String getName();
	public int getX();
	public int getY();
	public Coord[]zoneImpact();
}

