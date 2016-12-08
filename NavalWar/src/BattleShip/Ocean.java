package BattleShip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Boats.AbstractBateau;
import Boats.Bateau;
import Weapon.*;

/*
 * Classe Oc�an, repr�sentant le terrain de jeu.
 * Connais des informations sur les deux flottes.
 */

public class Ocean {
	
	// Attributs
	private Flotte monJeu = new Flotte();	// Flotte du joueur local
	
	// G�n�ration des maps 10x10 de chaque joueur avec, dans chaque case, un objet Touche.
	private Touche[][] tirsFromMe = {
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()},
			{new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche(),new Touche()}
	};
	private Touche[][] tirsFromEnnemi = tirsFromMe.clone();
	
	public static enum joueur {
		moi,
		ennemi
	}
	
	// Constructeur
	public Ocean() {
		
	}
	
	// Interroge si une case a d�j� �t� attaqu�.
	// Renvoie vrai ou faux
	public boolean wasAlreadyAttacked(Ocean.joueur from, Coord coord) {
		boolean result = false;
		Touche[][] temp;
		if(from.equals(Ocean.joueur.moi))
			temp = tirsFromMe;
		else
			temp = tirsFromEnnemi;
		
		result = temp[coord.x][coord.y].isTargeted;
		
		return result;
	}
	
	// Ex�cute un tir
	// Renvoi vrai si le tir a �t� ex�cut�
	public boolean fire(Coord tir) {
		boolean result = false;
		// V�rifier s'il y a un bateau sur la cible.
		if(this.monJeu.isSomethingHere(tir)) {
			result = true;
			this.tirsFromEnnemi[tir.x][tir.y].isTouche = true;
			this.monJeu.fire(tir);
		}
		return result;
	}
	
	// Retourne vrai si le bateau plac� � des coordon�es a �t� coul�
	public boolean isDown(Coord tir) {
		return this.monJeu.isDown(tir);
	}
	
	// Renvoie vrai si tous les bateaux sont coul�s => fin de la partie
	public boolean areAllDown() {
		return this.monJeu.areAllDown();
	}
	
	// Renvoie le nom du bateau qui se trouve � la position indiqu�e
	public String whoIsHere(Coord pos) {
		return this.monJeu.whoIsHere(pos);
	}

	// Passe un point de la map en "cibl�e".
	public void addATargeted(Ocean.joueur tireur, Coord coord) {
		if(tireur.equals(Ocean.joueur.moi))
			this.tirsFromMe[coord.x][coord.y].isTargeted = true;
		else
			this.tirsFromEnnemi[coord.x][coord.y].isTargeted = true;
	}
	
	// Passe un point de la map en "touch�".
	public void addATouched(Ocean.joueur tireur, Coord coord) {
		if(tireur.equals(Ocean.joueur.moi))
			this.tirsFromMe[coord.x][coord.y].isTouche = true;
		else
			this.tirsFromEnnemi[coord.x][coord.y].isTouche = true;
	}
	
	// Modifier la position d'un bateau
	// Se base sur la position d'origine (en haut � gauche) et sur le sens d'orientation
	public void setPosBoat(String nom, Coord posOrigine, Bateau.direction sens) {
		this.monJeu.setPosition(nom, posOrigine, sens);
	}
	
	// Renvoie la map de Touche d'un joueur
	public Touche[][] getTouches(Ocean.joueur plateau) {
		Touche[][] tmp;
		if(plateau.equals(Ocean.joueur.moi))
			tmp = this.tirsFromEnnemi;
		else
			tmp = this.tirsFromMe;
		return tmp;
	}
	
	// Renvoie l'abstract du bateau souhait�
	public AbstractBateau getAbstractBateau(String nom) {
		return this.monJeu.getAbstractBateau(nom);
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (Touche[] bs : tirsFromMe) {
			for (Touche b : bs) {
				str += b+"  ";
			}
			str += "\n";
		}
		str += "\n";
		return str;
	}
	
}
