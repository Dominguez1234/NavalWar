package BattleShip;

import java.io.IOException;
import java.util.Scanner;

import Boats.*;
import Weapon.AbstractArme;
import Weapon.Arme;

public class TestTotalWar {
	
	private BattleShip bs;
	private boolean first;
	Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		try {
			new TestTotalWar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TestTotalWar() throws InterruptedException, ClassNotFoundException, IOException {
		
//		sc = new Scanner(System.in);
		
		System.out.println("-------- BATTLESHIP TOTALWAR --------\n");
		bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
		
		this.connexion();
		
		System.out.println("\n--------------------------------------\n");
		
		this.initialisation();
		
		System.out.println("Votre jeu :");
		System.out.println(bs.ocean.monJeu);
		
		Thread.sleep(200);
		
		if(!this.first)
			this.attendre();
		
		while(!bs.isGameOver()) {
			Thread.sleep(1000);
			this.attaquer();
			
			Thread.sleep(500);
			this.attendre();
		}
		
	}
	
	public void connexion() {
		bs.connexion("127.0.0.1");
		this.first = bs.wasFirst();
	}
	
	public void initialisation() {
		if(this.first) {
			bs.setPosBoat("Porte-Avions", new Coord(1, 1), Bateau.direction.horizontale);
			bs.setPosBoat("Croiseur", new Coord(3, 7), Bateau.direction.verticale);
			bs.setPosBoat("Destroyer", new Coord(7, 1), Bateau.direction.horizontale);
			bs.setPosBoat("Sous-Marin", new Coord(4, 5), Bateau.direction.verticale);
			bs.setPosBoat("Patrouilleur", new Coord(9, 8), Bateau.direction.horizontale);
		} else {
			bs.setPosBoat("Porte-Avions", new Coord(4, 4), Bateau.direction.horizontale);
			bs.setPosBoat("Croiseur", new Coord(4, 0), Bateau.direction.verticale);
			bs.setPosBoat("Destroyer", new Coord(2, 2), Bateau.direction.verticale);
			bs.setPosBoat("Sous-Marin", new Coord(0, 7), Bateau.direction.horizontale);
			bs.setPosBoat("Patrouilleur", new Coord(0, 5), Bateau.direction.verticale);
		}
	}
	
	public void attendre() throws ClassNotFoundException, IOException, InterruptedException {
		if(!bs.isGameOver()) {
			System.out.println("\n--------------------------------------\n");
			
			System.out.println("A l'adversaire de jouer...");
			while(bs.jAttendsLattaque())
				Thread.sleep(100);
		}
	}
	
	public void attaquer() throws ClassNotFoundException, IOException, InterruptedException {
		if(!bs.isGameOver()) {
			boolean continu = true;
			
			while(continu) {
				System.out.println("\n--------------------------------------\n");
				
				System.out.println(bs.ocean);
				
				Coord cible = new Coord();
				String nArme = "Nuke";
				int numArme;
				
				// Sélection arme
				System.out.println("Quelle arme utiliser ?");
				String[] l = {"Missile","Avion","Torpille","Nuke"};
				int i;
				AbstractArme tempArme;
				for(i=0;i<4;i++) {
					tempArme = bs.getAbstractArme(l[i]);
					System.out.println(i+" - "+tempArme.getNom()+" ("+tempArme.getNbrRestant()+" restant)");
				}
				System.out.print("\nVotre choix : ");
				numArme = sc.nextInt();
				nArme = l[numArme];
				
				// Sélection cible		
				AbstractArme arme = bs.getAbstractArme(nArme);		
				if(arme.getNbrRestant() == 0)
					nArme = "Missile";
				
				System.out.println("\n-- "+arme);
				
				System.out.print("Ligne : ");
				cible.x = sc.nextInt()-1;
				System.out.print("Colonne : ");
				cible.y = sc.nextInt()-1;
				
				// Envoi missible
				continu = bs.jAttaque(cible, nArme, Arme.Sens.HORIZONTAL);
				System.out.println(bs.ocean);
			}
		}
	}
	
}
