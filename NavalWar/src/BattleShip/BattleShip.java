package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import Boats.AbstractBateau;
import Boats.Bateau;
import Weapon.Arme;
import Weapon.Avion;
import Weapon.Missile;
import Weapon.Nuke;
import Weapon.Torpille;

public class BattleShip {
	
	private boolean online = false;
	private Reseau reseau;
	public Ocean ocean;
	
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
	
	public boolean Jattaque(Coord cible, String arme, Arme.Sens sens) throws IOException, ClassNotFoundException {
		if(this.online) {
			
			ArrayList<Coord> ciblesValides = new ArrayList<>();
			Tir tir;
			
			// Sélection de l'arme.
			if(this.lArmes.containsKey(arme)) {
				for (Coord c : this.lArmes.get(arme).zoneImpact(cible, sens)) {
					// Vérifier validité coordonées.
					if(c.coordonnees_valides()) {
						// Vérifier si la case a déjà été attaquée.
						if(!ocean.wasAlreadyAttacked(Ocean.joueur.moi, c)) {
							ocean.addATargeted(Ocean.joueur.moi, c);
							// Ajout de la cible dans la liste des cibles valides
							ciblesValides.add(c);
						}
					}
					
				}
				
				// Envoi des cibles à l'ennemi
				tir = new Tir(ciblesValides,arme);
				System.out.println("Envoi de tir : "+tir);
				reseau.send(tir);
			}
			
			// --- A SUPPRIMER
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ----------------
			
			// Réception de la réponse
			tir = reseau.receive();
			System.out.println("Cibles touchées : "+tir.getTouches());
			if(!tir.getBateauxCoules().isEmpty())
				System.out.println("Bateau(x) coulé(s) : "+tir.getBateauxCoules());
			for(Coord touche : tir.getTouches()) {
				ocean.addATouched(Ocean.joueur.moi, touche);
			}
			
		}
		return false;
	}
	
	public boolean JattendsLattaque() throws ClassNotFoundException, IOException {
		System.out.println("En attente de réception...");
		Tir tir = reseau.receive();
		boolean continueFire = true;
		String temp = "";
		System.out.println("Réception : "+tir);
		
		for(Coord cible  : tir.getCibles()) {
			// Si on touche un bateau
			if(continueFire) {
				if(ocean.fire(cible)) {
					tir.addTouche(cible);
					// si le bateau touché est coulé
					if(ocean.isDown(cible)) {
						temp = ocean.whoIsHere(cible);
						if(temp.equals("Sous-Matin"))
							continueFire = false;
						tir.addBateauCoule(temp);
						// Si tous les bateaux sont coulés => fin de la partie
						if(ocean.areAllDown()) {
							tir.gameOver = true;
						}
					}
				}
			}
		}
		
		// --- A SUPPRIMER
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------
		
		reseau.send(tir);
		
		return false;
	}
	
	public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
		ocean.setPosBoat(nom, posOrigine, sens);
	}
	
	public AbstractBateau getAbstractBateau(String nom) {
		return this.ocean.getAbstractBateau(nom);
	}
	
}
