package Weapon;

public abstract class AbstractArme implements Arme {
	
	public AbstractArme(Coord coord){
		super();
		this.coord = coord;
	}
	Coord coord;
	
	public abstract void needBoat();
	
	public abstract void zoneImpact();
	
	public int getX() {
		return this.coord.x;	
	}
	
	public int getY() {
		return this.coord.y;	
	}
	public String getName(){
		return this.getClass().getSimpleName();
	}


	@Override
	public String toString() {
		return "AbstractArme [coord=" + coord + ", getName()=" + getName() + "]";
	}
	public static void main(String[] args){
		Arme missile = new Missile(new Coord (-1,22));
		System.out.println(missile);
		System.out.println(Coord.coordonnees_valides(-1, 22));
	}
}
