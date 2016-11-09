package BattleShip;

public class Test {
	
	public static void main(String[] args) {
		
		int[] newPos = {1,1};
		int[] newPos2 = {0,0};
		int[] newPos3 = {5,4};
		int[] newPos4 = {7,2};
		int[] newPos5 = {1,8};
		
		Flotte flotte = new Flotte();
		flotte.setPosition("Porte-Avions", newPos2, "verticale");
		flotte.setPosition("Croiseur", newPos, "horizontale");
		flotte.setPosition("Sous-Marin", newPos3, "horizontale");
		flotte.setPosition("Destroyer", newPos4, "verticale");
		flotte.setPosition("Patrouilleur", newPos5, "verticale");
		
		System.out.println("Test de position : "+flotte.isSomethingHere(newPos));
		System.out.println("Porte-Avions coulé ? "+flotte.isDown("Porte-Avions"));
		System.out.println("Tous les bateaux sont coulés ? "+flotte.areAllDown());
		System.out.println("");
		
		System.out.println(flotte);
		
	}
	
}
