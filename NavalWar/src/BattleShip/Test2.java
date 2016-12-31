package BattleShip;

import java.io.IOException;
import java.util.Scanner;

import Boats.Bateau;
import Weapon.Arme;

public class Test2 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
			BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
			bs.connexion("127.0.0.1");
			
			bs.setPosBoat("Porte-Avions", new Coord(1,1), Bateau.direction.horizontale);
			bs.setPosBoat("Croiseur", new Coord(3,0), Bateau.direction.verticale);
			bs.setPosBoat("Sous-Marin", new Coord(4,5), Bateau.direction.horizontale);
			bs.setPosBoat("Destroyer", new Coord(2,9), Bateau.direction.verticale);
			bs.setPosBoat("Patrouilleur", new Coord(7,6), Bateau.direction.verticale);
			
			System.out.println("Test2 prêt\n");
			
//			Thread.sleep(1000);
			
//			while(true) {
//				bs.jAttendsLattaque();
				
//				Coord cible = new Coord();
//				Scanner sc = new Scanner(System.in);
//				System.out.print("Ligne : ");
//				cible.x = sc.nextInt()-1;
//				System.out.print("Colonne : ");
//				cible.y = sc.nextInt()-1;
//				
//				bs.jAttaque(cible, "Nuke", Arme.Sens.HORIZONTAL);
//				System.out.println(bs.ocean);
				
				
//			}
			
//			int i;
//			for(i=0;i<1;i++) {
//				Thread.sleep(500);
//				System.out.println("+++++ Test2 - Connexion "+i);
//				bs.waitAdversaire();
////				
////				Thread.sleep(500);
////				bs.jAttaque(new Coord(5,i), "Missile", Arme.Sens.HORIZONTAL);
////				Thread.sleep(500);
//			}
			
			int i;
			bs.waitAdversaire();
			for(i=0;i<5;i++) {
				Thread.sleep(2000);
				bs.jAttaque(new Coord(6,i), "Missile", Arme.Sens.HORIZONTAL);
				
				Thread.sleep(1000);
				bs.jAttendsLattaque();
			}
//			
//			System.out.println(bs.ocean);
		
	}
	
}
