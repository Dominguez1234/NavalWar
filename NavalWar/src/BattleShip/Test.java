package BattleShip;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import Boats.*;
import Reseau.*;
import Weapon.*;

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
		
		Thread.sleep(2000);
		
		while(true) {
			Coord cible = new Coord();
			Scanner sc = new Scanner(System.in);
			System.out.print("Ligne : ");
			cible.x = sc.nextInt()-1;
			System.out.print("Colonne : ");
			cible.y = sc.nextInt()-1;
			
			bs.jAttaque(cible, "Nuke", Arme.Sens.HORIZONTAL);
			System.out.println(bs.ocean);
			
			bs.jAttendsLattaque();
		}
		
		
		
	}
	
	
}