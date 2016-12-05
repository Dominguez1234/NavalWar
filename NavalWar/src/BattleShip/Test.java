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
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
// --------------------------------------------------------------------------------------------

		Coord pos1 = new Coord(0,0);
		Coord pos2 = new Coord(1,1);
		Coord pos3 = new Coord(5,4);
		Coord pos4 = new Coord(7,2);
		Coord pos5 = new Coord(1,8);
		
		Ocean oc = new Ocean(Ocean.modeJeu.TOTALWAR);
		oc.monJeu.setPosition("Porte-Avions", pos1, Bateau.direction.verticale);
		oc.monJeu.setPosition("Croiseur", pos2, Bateau.direction.horizontale);
		oc.monJeu.setPosition("Sous-Marin", pos3, Bateau.direction.horizontale);
		oc.monJeu.setPosition("Destroyer", pos4, Bateau.direction.verticale);
		oc.monJeu.setPosition("Patrouilleur", pos5, Bateau.direction.verticale);

//		Torpille m = new Torpille();
//
//		System.out.println(m);
//		System.out.println(m.zoneImpact(new Coord(1,1), Arme.Sens.VERTICAL));
//
//		
//		Scanner sc = new Scanner(System.in);
//		Coord cible = new Coord(-1,-1);
//		String arme = "Torpille";
//		while(true) {
//			System.out.println(oc);
//			
//			System.out.print("Ligne : ");
//			cible.x = sc.nextInt()-1;
//			System.out.print("Colonne : ");
//			cible.y = sc.nextInt()-1;
//			
//			System.out.println(oc.fire(cible,arme,Arme.Sens.HORIZONTAL));
//			
//		}
		
// --------------------------------------------------------------------------------------------
		
		Reseau r = new Reseau(3339,"134.214.50.88");
		Tir tir = new Tir(new Coord(1,1),"Missile");
		r.send(tir);
		
//		r.receive();
		
	}

}
