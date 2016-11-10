package Weapon;

import java.util.Arrays;

import BattleShip.Coord;

public abstract class AbstractArme implements Arme {
	
	public AbstractArme(Coord coord){
		super();
		this.coord = coord;
	}
	Coord coord;
	
	public abstract String[] needBoat();
	
	public abstract Coord[] zoneImpact();
	
	public int getX() {
		return this.coord.x;	
	}
	public Coord getCoord(){
		return this.coord;
	}
	
	public int getY() {
		return this.coord.y;	
	}
	public String getName(){
		return this.getClass().getSimpleName();
	}



	public static void main(String[] args){
		Arme missile = new Missile(new Coord (-1,22));
		Arme nuke = new Nuke(new Coord (1,2));
		System.out.println(nuke);
		System.out.println(missile);
	}

	@Override
	public String toString() {
		return "AbstractArme [coord=" + coord + ", needBoat()=" + Arrays.toString(needBoat()) + ", getName()="
				+ getName() + ", zoneImpact()="
						+ Arrays.toString(zoneImpact()) + "]";
	}


}
