package Weapon;

import BattleShip.Coord;

public class Nuke extends AbstractArme {
	public Nuke(Coord coord){
		super(coord);
	}

	@Override
	public String[] needBoat() {
		String tab[] = {"Sous-Marin"};
		return tab;
	}

	@Override
	public Coord[] zoneImpact() {
		
		int x = this.getX();
		int y = this.getY();
		Coord coord1= new Coord(x+1,y);
		Coord coord2= new Coord(x-1,y);
		Coord coord3= new Coord(x,y+1);
		Coord coord4= new Coord(x,y+1);
		
		Coord tabCoord[] =  {this.coord,coord1,coord2,coord3,coord4};
		
		return tabCoord;

	}
}
