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
	
	public int[] zoneImpact(Coord coord) {
		int[] tabCoord = {this.coord.x,this.coord.y};
		return tabCoord;
	}
	
	public int getX() {
		return this.coord.x;	
	}
	
	public int getY() {
		return this.coord.y;	
	}
	public String getName(){
		return this.getClass().getSimpleName();
	}



	public static void main(String[] args){
		Arme missile = new Missile(new Coord (-1,22));
		System.out.println(missile);
	}

	@Override
	public String toString() {
		return "AbstractArme [coord=" + coord + ", needBoat()=" + Arrays.toString(needBoat()) + ", getName()="
				+ getName() + ", zoneImpact()="
						+ zoneImpact(coord) + "]";
	}


}
