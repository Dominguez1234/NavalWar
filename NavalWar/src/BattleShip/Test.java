package BattleShip;
import java.io.IOException;
import java.util.Scanner;

import Boats.*;
import Weapon.Arme;

public class Test {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
		bs.connexion("127.0.0.1");
		
		bs.setPosBoat("Porte-Avions", new Coord(0,0), Bateau.direction.verticale);
		bs.setPosBoat("Croiseur", new Coord(1,1), Bateau.direction.horizontale);
		bs.setPosBoat("Sous-Marin", new Coord(5,4), Bateau.direction.horizontale);
		bs.setPosBoat("Destroyer", new Coord(7,2), Bateau.direction.verticale);
		bs.setPosBoat("Patrouilleur", new Coord(1,8), Bateau.direction.verticale);
		
		
		System.out.println("Test prêt\n");
		
//		Thread.sleep(2000);
		
//		while(true) {
//			Coord cible = new Coord();
//			Scanner sc = new Scanner(System.in);
//			System.out.print("Ligne : ");
//			cible.x = sc.nextInt()-1;
//			System.out.print("Colonne : ");
//			cible.y = sc.nextInt()-1;
//			sc.close();
//			
//			bs.jAttaque(cible, "Nuke", Arme.Sens.HORIZONTAL);
//			System.out.println(bs.ocean);
//			
//			bs.jAttendsLattaque();
//		}
		
//		int i;
//		for(i=0;i<1;i++) {
//			System.out.println("+++++ Test - Connexion "+i);
//			bs.waitAdversaire();
//			
//			bs.jAttendsLattaque();
//			Thread.sleep(500);
//		}
		
		int i;
		bs.waitAdversaire();
		for(i=0;i<5;i++) {
			Thread.sleep(1000);
			bs.jAttendsLattaque();
			
			Thread.sleep(2000);
			bs.jAttaque(new Coord(4,i), "Missile", Arme.Sens.HORIZONTAL);
		}
//		
//		System.out.println(bs.ocean);
		
//		int tab1[] = {1,2,3,4,5};
//		System.out.println("Tab1[0] : "+tab1[0]);
//		
//		int tab2[] = tab1.clone();
//		System.out.println("Tab2[0] : "+tab2[0]);
//		
//		System.out.println("--- Modification ---");
//		
//		tab2[0] = 8;
//		System.out.println("Tab1[0] : "+tab1[0]);
//		System.out.println("Tab2[0] : "+tab2[0]);
	}
	
	
}