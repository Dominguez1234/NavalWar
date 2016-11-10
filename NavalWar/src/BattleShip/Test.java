package BattleShip;
import Weapon.*;

public class Test {
	
	public static void main(String[] args) {
		
//		int[] newPos = {1,1};
//		int[] newPos2 = {0,0};
//		int[] newPos3 = {5,4};
//		int[] newPos4 = {7,2};
//		int[] newPos5 = {1,8};

		Coord pos1 = new Coord(0,0);
		Coord pos2 = new Coord(1,1);
		Coord pos3 = new Coord(5,4);
		Coord pos4 = new Coord(7,2);
		Coord pos5 = new Coord(1,8);
		
		/*Flotte flotte = new Flotte();
		flotte.setPosition("Porte-Avions", newPos2, "verticale");
		flotte.setPosition("Croiseur", newPos, "horizontale");
		flotte.setPosition("Sous-Marin", newPos3, "horizontale");
		flotte.setPosition("Destroyer", newPos4, "verticale");
		flotte.setPosition("Patrouilleur", newPos5, "verticale");
		
		System.out.println("Test de position : "+flotte.isSomethingHere(newPos));
		System.out.println("Porte-Avions coulé ? "+flotte.isDown("Porte-Avions"));
		System.out.println("Tous les bateaux sont coulés ? "+flotte.areAllDown());
		System.out.println("");
		
		System.out.println(flotte);*/
		
//		Ocean oc = new Ocean();
//		oc.monJeu.setPosition("Porte-Avions", pos1, Bateau.direction.verticale);
//		oc.monJeu.setPosition("Croiseur", pos2, Bateau.direction.horizontale);
//		oc.monJeu.setPosition("Sous-Marin", pos3, Bateau.direction.horizontale);
//		oc.monJeu.setPosition("Destroyer", pos4, Bateau.direction.verticale);
//		oc.monJeu.setPosition("Patrouilleur", pos5, Bateau.direction.verticale);
//		System.out.println(oc.monJeu);
//		System.out.println(oc);
//		System.out.println(oc.fire(pos5));
//		System.out.println(oc);
//		System.out.println(oc.fire(new Coord(2,8)));
//		System.out.println(oc);
		
		Missile m = new Missile();
		System.out.println(m);
		
		
	}
	
}
