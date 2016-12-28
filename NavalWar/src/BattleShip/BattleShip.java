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

/*
 * Contr�leur du jeu
 * Met en relation l'oc�an (flotte, bateaux), les armes, et le r�seau
 */

public class BattleShip {

	// Modes de jeux
	public static enum modeJeu {
		NORMAL,
		TOTALWAR
	}
	
	// Attributs
	private boolean online = false;
	private Reseau reseau;
	private Ocean ocean;
	
	
	// Liste des armes
	private Map<String, Arme> lArmes = new LinkedHashMap<>();
	
	// Constructeur
	public BattleShip(BattleShip.modeJeu mode) {
		// Cr�ation de l'oc�an
		ocean = new Ocean();
		
		// Armes disponibles
		lArmes.put("Missile", new Missile());
		if(mode.equals(BattleShip.modeJeu.TOTALWAR)) {
			lArmes.put("Nuke", new Nuke());
			lArmes.put("Torpille", new Torpille());
			lArmes.put("Avion", new Avion());
		}
	}
	
	// Lance la connexion avec l'adversaire
	public boolean connexion(String addr, int port) {
		try {
			this.reseau = new Reseau(addr, port);	// Cr�ation objet r�seau
			this.online = this.reseau.connexion();	// Tentative de connexion
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.online;
	}
	
	public boolean connexion(String addr) {
		try {
			this.reseau = new Reseau(addr);	// Cr�ation objet r�seau
			this.online = this.reseau.connexion();	// Tentative de connexion
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.online;
	}
	
	// Joueur local attaque l'adversaire
	public boolean jAttaque(Coord cible, String arme, Arme.Sens sens) throws IOException, ClassNotFoundException {
		if(this.online) {
			
			ArrayList<Coord> ciblesValides = new ArrayList<>();
			Tir tir;
			
			// S�lection de l'arme.
			if(this.lArmes.containsKey(arme) && this.lArmes.get(arme).getNbrRestant() > 0) {
				this.lArmes.get(arme).FireInTheHole();
				for (Coord c : this.lArmes.get(arme).zoneImpact(cible, sens)) {
					// V�rifier validit� coordon�es.
					if(c.coordonnees_valides()) {
						// V�rifier si la case a d�j� �t� attaqu�e.
						if(!ocean.wasAlreadyAttacked(Ocean.joueur.moi, c)) {
							ocean.addATargeted(Ocean.joueur.moi, c);
							// Ajout de la cible dans la liste des cibles valides
							ciblesValides.add(c);
						}
					}
					
				}
				
				// Envoi des cibles � l'ennemi
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
			
			// R�ception de la r�ponse
			tir = reseau.receive();
			System.out.println("Cibles touch�es : "+tir.getTouches());
			if(!tir.getBateauxCoules().isEmpty())
				System.out.println("Bateau(x) coul�(s) : "+tir.getBateauxCoules());
			for(Coord touche : tir.getTouches()) {			// Pour chaque case touch�, on modifie sur la map
				ocean.addATouched(Ocean.joueur.moi, touche);
			}
			
		}
		return true;
	}
	
	// L'adversaire attaque le joueur local
	public boolean jAttendsLattaque() throws ClassNotFoundException, IOException {
		System.out.println("En attente de r�ception...");
		Tir tir = reseau.receive();		// R�ception du Tir de l'adversaire
		boolean continueFire = true;
		String temp = "";
		System.out.println("R�ception : "+tir);
		
		for(Coord cible  : tir.getCibles()) {	// Pour chaque case cibl� par l'adversaire
			// Si on touche un bateau
			if(continueFire) {
				if(ocean.fire(cible)) {
					tir.addTouche(cible);
					// si le bateau touch� est coul�
					if(ocean.isDown(cible)) {
						temp = ocean.whoIsHere(cible);
						if(temp.equals("Sous-Matin"))
							continueFire = false;
						tir.addBateauCoule(temp);
						// Si tous les bateaux sont coul�s => fin de la partie
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
		
		reseau.send(tir);	// Renvoie de l'objet tir � l'adversaire
		
		return true;
	}
	
	// Modifier la position d'un bateau
	public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
		ocean.setPosBoat(nom, posOrigine, sens);
	}
	
	// Retourne l'abstract d'un bateau
	public AbstractBateau getAbstractBateau(String nom) {
		return this.ocean.getAbstractBateau(nom);
	}
	
	// Indique, pour une coordonn�e, si un bateau est pr�sent sur le jeu local
	public boolean isSomethingHere(Coord coord) {
		return this.ocean.isSomethingHere(coord);
	}
	
	// Renvoi le tableau de tirs
	public Touche[][] getTouches(Ocean.joueur cible) {
		return ocean.getTouches(cible);
	}
	
}
