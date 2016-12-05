package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Boats.Bateau;
import Weapon.Arme;
import Weapon.Avion;
import Weapon.Missile;
import Weapon.Nuke;
import Weapon.Torpille;

public class BattleShip {
	
	private boolean online = false;
	private Reseau reseau;
	private Ocean ocean;
	
	// Modes de jeux
	public static enum modeJeu {
		NORMAL,
		TOTALWAR
	}
	
	private Map<String, Arme> lArmes = new LinkedHashMap<>();
	
	public BattleShip(BattleShip.modeJeu mode) {
		// Création de l'océan
		ocean = new Ocean();
		
		// Armes disponibles
		lArmes.put("Missile", new Missile());
		if(mode.equals(BattleShip.modeJeu.TOTALWAR)) {
			lArmes.put("Nuke", new Nuke());
			lArmes.put("Torpille", new Torpille());
			lArmes.put("Avion", new Avion());
		}
	}
	
	public boolean connexion(String addr, int port) {
		try {
			this.reseau = new Reseau(addr, port);
			this.online = this.reseau.connexion();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.online;
	}
	
	public boolean Jattaque(Coord cible, String arme, Arme.Sens sens) throws IOException {
		if(this.online) {
			
			boolean continueFire = true;
			ArrayList<Coord> ciblesValides = new ArrayList<>();
			
			// Sélection de l'arme.
			if(this.lArmes.containsKey(arme)) {
				for (Coord c : this.lArmes.get(arme).zoneImpact(cible, sens)) {
					// Vérifier validité coordonées.
					if(continueFire) {
						if(c.coordonnees_valides()) {
							// Vérifier si la case a déjà été attaquée.
							if(!ocean.wasAlreadyAttacked(Ocean.joueur.moi, c)) {
								ocean.addAShoot(Ocean.joueur.moi, cible);
								// Ajout de la cible dans la liste des cibles valides
								ciblesValides.add(c);
							}
						}
					}
				}
				
				// Envoi des cibles à l'ennemi
				Tir tir = new Tir(ciblesValides,arme);
				System.out.println("Envoi de tir : "+tir);
				reseau.send(tir);
			}
			
		}
		return false;
	}
	
	public boolean JattendsLattaque() throws ClassNotFoundException, IOException {
		System.out.println("En attente de réception...");
		Tir tir = reseau.receive();
		System.out.println("Réception : "+tir);
		return false;
	}
	
	public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
		ocean.setPosBoat(nom, posOrigine, sens);
	}
	
}
