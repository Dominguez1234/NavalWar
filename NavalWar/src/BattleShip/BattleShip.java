package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import Boats.AbstractBateau;
import Boats.Bateau;
import Weapon.AbstractArme;
import Weapon.Arme;
import Weapon.Avion;
import Weapon.Missile;
import Weapon.Nuke;
import Weapon.Torpille;

/*
 * Contrôleur du jeu
 * Met en relation l'océan (flotte, bateaux), les armes, et le réseau
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
	public Ocean ocean;
	private boolean gameOver = false;
	private boolean IAmWinner = false;
	
	
	// Liste des armes
	private Map<String, Arme> lArmes = new LinkedHashMap<>();
	
	// Constructeur
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
	
	// Lance la connexion avec l'adversaire
	public boolean connexion(String addr, int port) {
		try {
			this.reseau = new Reseau(addr, port);	// Création objet réseau
			this.online = this.reseau.connexion();	// Tentative de connexion
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.online;
	}
	
	public boolean connexion(String addr) {
		try {
			this.reseau = new Reseau(addr);	// Création objet réseau
			this.online = this.reseau.connexion();	// Tentative de connexion
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.online;
	}
	
	public boolean waitAdversaire() {
		this.reseau.connexion();
		return this.reseau.getWasFirst();
	}
	
	// Joueur local attaque l'adversaire
	public boolean jAttaque(Coord cible, String arme, Arme.Sens sens) throws IOException, ClassNotFoundException {
		boolean result = false;
		if(this.online) {
			
			ArrayList<Coord> ciblesValides = new ArrayList<>();
			Tir tir;
			
			// Sélection de l'arme.
			if(this.lArmes.containsKey(arme) && this.lArmes.get(arme).getNbrRestant() > 0) {
				this.lArmes.get(arme).FireInTheHole();
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
				tir = null;
			
				// --- A SUPPRIMER
				try {
					Thread.sleep(100);
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
				for(Coord touche : tir.getTouches()) {			// Pour chaque case touché, on modifie sur la map
					ocean.addATouched(Ocean.joueur.moi, touche);
					result = true;
				}
				if(tir.getNomArme().equals("Torpille") && tir.getTouches().size() > 0) {
					Coord c = tir.getTouches().get(0);
					int i;
					for(i=(c.y)+1;i<10;i++)
						ocean.deleteTargetFromTorpille(new Coord(c.x,i));
				}
				
				if(tir.gameOver) {
					this.gameOver = true;
					this.IAmWinner = true;
				}
				
			}
			
		}
		return result;
	}
	
	// L'adversaire attaque le joueur local
	public boolean jAttendsLattaque() throws ClassNotFoundException, IOException {
		boolean result = false;
		System.out.println("En attente de réception...");
		Tir tir = reseau.receive();		// Réception du Tir de l'adversaire
		boolean continueFire = true;
		String temp = "";
		System.out.println("Réception : "+tir);
		
		for(Coord cible  : tir.getCibles()) {	// Pour chaque case ciblé par l'adversaire
			// Si on touche un bateau
			if(continueFire) {
				ocean.addATargeted(Ocean.joueur.ennemi, cible);
				if(ocean.fire(cible)) {
					tir.addTouche(cible);
					result = true;
					ocean.addATouched(Ocean.joueur.ennemi, cible);
					if(tir.getNomArme().equals("Torpille"))
						continueFire = false;
					// si le bateau touché est coulé
					if(ocean.isDown(cible)) {
						tir.addBateauCoule(ocean.whoIsHere(cible));
						// Si tous les bateaux sont coulés => fin de la partie
						if(ocean.areAllDown()) {
							tir.gameOver = true;
							this.gameOver = true;
						}
					}
				}
			}
		}
		
		// --- A SUPPRIMER
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ----------------
		
		reseau.send(tir);	// Renvoie de l'objet tir à l'adversaire
		
		return result;
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	// Modifier la position d'un bateau
	public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
		ocean.setPosBoat(nom, posOrigine, sens);
	}
	
	// Retourne l'abstract d'un bateau
	public AbstractBateau getAbstractBateau(String nom) {
		return this.ocean.getAbstractBateau(nom);
	}
	
	// Indique, pour une coordonnée, si un bateau est présent sur le jeu local
	public boolean isSomethingHere(Coord coord) {
		return this.ocean.isSomethingHere(coord);
	}
	
	// Renvoi le tableau de tirs
	public Touche[][] getTouches(Ocean.joueur cible) {
		return ocean.getTouches(cible);
	}
	
	public Ocean.joueur getWinner() {
		Ocean.joueur result;
		if(this.IAmWinner)
			result = Ocean.joueur.moi;
		else
			result = Ocean.joueur.ennemi;
		return result;
	}
	
	public float getRatio(Ocean.joueur joueur) {
		return ocean.getRatio(joueur);
	}
	
	public boolean wasFirst() {
		return reseau.getWasFirst();
	}
	
	public AbstractArme getAbstractArme(String name) {
		AbstractArme result = null;
		if(lArmes.containsKey(name))
			result = new AbstractArme(name, lArmes.get(name).getNbrRestant());
		return result;
	}
	
}
