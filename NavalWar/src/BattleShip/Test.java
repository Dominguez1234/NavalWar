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
		System.out.println("Porte-Avions coul� ? "+flotte.isDown("Porte-Avions"));
		System.out.println("Tous les bateaux sont coul�s ? "+flotte.areAllDown());
		System.out.println("");
		
		System.out.println(flotte);*/
		
		Ocean oc = new Ocean(Ocean.modeJeu.TOTALWAR);
		oc.monJeu.setPosition("Porte-Avions", pos1, Bateau.direction.verticale);
		oc.monJeu.setPosition("Croiseur", pos2, Bateau.direction.horizontale);
		oc.monJeu.setPosition("Sous-Marin", pos3, Bateau.direction.horizontale);
		oc.monJeu.setPosition("Destroyer", pos4, Bateau.direction.verticale);
		oc.monJeu.setPosition("Patrouilleur", pos5, Bateau.direction.verticale);
//		System.out.println(oc.monJeu);
//		System.out.println(oc);
//		System.out.println(oc.fire(pos5));
//		System.out.println(oc);
//		System.out.println(oc.fire(new Coord(2,8)));
//		System.out.println(oc);
		
//		Missile m = new Missile();
//		Nuke m = new Nuke();
//		System.out.println("a :"+m+"\n");
//		String[] needs = m.needBoat();
//		Boolean tirPossible = false;
//		for (String n : needs) {
//			if(!oc.isDown(Ocean.joueur.moi, n)) {
//				tirPossible |= true;
//			}
//		}
//		if(tirPossible) {
//			Coord[] cibles = m.zoneImpact(new Coord(5, 5));
//			for (Coord tir : cibles) {
//				System.out.println("["+tir.x+";"+tir.y+"] "+oc.fire(tir));
//			}
//		} else
//			System.out.println("Aucun de vos bateau de peut tirer cette arme.");
//		System.out.println(oc);
		
// --------------------------------------------------------------------------------------------
		
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
		
		Reseau r = new Reseau(3339,"192.168.0.1");
		Tir tir = new Tir(new Coord(1,1),"Missile");
//		r.send(tir);
		
//		r.receive();
		
		r.end();
		
	}
	
}
