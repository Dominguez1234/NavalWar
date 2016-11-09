package BattleShip;

public class Test {
	
	public static void main(String[] args) {
		
		int[] newPos = {1,1};
		int[] newPos2 = {0,0};
		
		Flotte flotte = new Flotte();
		flotte.setPosition("Porte-Avions", newPos2, "verticale");
		flotte.setPosition("Croiseur", newPos, "horizontale");
		System.out.println(flotte);
		
	}
	
}
