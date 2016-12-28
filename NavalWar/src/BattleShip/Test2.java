package BattleShip;

import java.io.IOException;

import Boats.Bateau;

public class Test2 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

//		Coord pos1 = new Coord(1,1);
//		Coord pos2 = new Coord(3,0);
//		Coord pos3 = new Coord(4,5);
//		Coord pos4 = new Coord(2,9);
//		Coord pos5 = new Coord(7,6);
//		
//		Ocean oc = new Ocean(Ocean.modeJeu.TOTALWAR);
//		oc.monJeu.setPosition("Porte-Avions", pos1, Bateau.direction.horizontale);
//		oc.monJeu.setPosition("Croiseur", pos2, Bateau.direction.verticale);
//		oc.monJeu.setPosition("Sous-Marin", pos3, Bateau.direction.horizontale);
//		oc.monJeu.setPosition("Destroyer", pos4, Bateau.direction.verticale);
//		oc.monJeu.setPosition("Patrouilleur", pos5, Bateau.direction.verticale);
		
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
// ----- Test du réseau
		
//		Reseau r = new Reseau(3339,"127.0.0.1");
//		Tir tir = new Tir(new Coord(1,1),"Missile");
//		r.send(tir);
		
//		Tir tir = r.receive();
		
// --------------------------------------------------------------------------------------------
		
		// Connexion à l'autre
//		String ip = "127.0.0.1";
//		int port = 3339;
//		
//		Reseau r = new Reseau(ip,port);
//		r.connexion();
//		
//		Tir t = r.receive();
//		System.out.println("Nous sommes touchés !");
//		t.addTouche(new Coord(1,2));
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		r.send(t);
		
// --------------------------------------------------------------------------------------------
		
		while(true) {
			BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
			bs.connexion("127.0.0.1", 3131);
			
			bs.setPosBoat("Porte-Avions", new Coord(1,1), Bateau.direction.horizontale);
			bs.setPosBoat("Croiseur", new Coord(3,0), Bateau.direction.verticale);
			bs.setPosBoat("Sous-Marin", new Coord(4,5), Bateau.direction.horizontale);
			bs.setPosBoat("Destroyer", new Coord(2,9), Bateau.direction.verticale);
			bs.setPosBoat("Patrouilleur", new Coord(7,6), Bateau.direction.verticale);
			
			System.out.println("Test2 prêt\n");
			
			Thread.sleep(1000);
			bs.JattendsLattaque();
		}
		
		
	}
	
}
