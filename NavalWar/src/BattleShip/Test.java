package BattleShip;

public class Test {
	
	public static void main(String[] args) {
		
		int[] newPos = {1,1};
		int[] newPos2 = {0,0};
		int[] newPos3 = {0,6};
		
		Flotte flotte = new Flotte();
		flotte.setPosition("Porte-Avions", newPos2, "verticale");
		flotte.setPosition("Croiseur", newPos, "horizontale");
		System.out.println(flotte);
		System.out.println("Test de position : "+flotte.isSomethingHere(newPos3));
		System.out.println("Porte-Avions coulé ? "+flotte.isDown("Porte-Avions"));
		
	}
	
}
