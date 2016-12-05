package BattleShip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Weapon.*;

public class Ocean {
	
	public Flotte monJeu = new Flotte();
	private Flotte ennemi = new Flotte();
	
//	private Map<String, Arme> lArmes = new LinkedHashMap<>();
	
	private Touche t = new Touche();
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
	
//	public static enum modeJeu {
//		NORMAL,
//		TOTALWAR
//	}
	
//	public Ocean(Ocean.modeJeu mode) {
//		lArmes.put("Missile", new Missile());
//		
//		if(mode.equals(Ocean.modeJeu.TOTALWAR)) {
//			lArmes.put("Nuke", new Nuke());
//			lArmes.put("Torpille", new Torpille());
//			lArmes.put("Avion", new Avion());
//		}
//	}
	
	public Ocean() {
		
	}
	
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
	
	/*public String fire(Coord cible, String arme, Arme.Sens sens) {
		// ----------------- VERSION TEMPORAIRE -----------------
		String str = "";
		boolean continueFire = true;
		
		// S�lection de l'arme.
		if(this.lArmes.containsKey(arme)) {
			for (Coord tir : this.lArmes.get(arme).zoneImpact(cible, sens)) {
				// V�rifier validit� coordon�es.
				if(continueFire) {
					if(tir.coordonnees_valides()) {
						// V�rifier si la case a d�j� �t� attaqu�e.
						if(!this.wasAlreadyAttacked(Ocean.joueur.moi, tir)) {
							this.tirsFromEnnemi[tir.x][tir.y].isTargeted = true;
							// V�rifier s'il y a un bateau sur la cible.
							if(this.monJeu.isSomethingHere(tir)) {
								str = "Touch� ! ";
								continueFire = false;
								this.tirsFromEnnemi[tir.x][tir.y].isTouche = true;
								this.monJeu.fire(tir);
								// V�rifier si le bateau touch� est coul�.
								if(this.monJeu.isDown(tir)) {
									str += "Coul� ! ";
									// V�rifier si tous les bateaux sont coul�s.
									if(this.monJeu.areAllDown())
										str += "Fin de la partie.";
								}
							} else
								str = "Loup�";
						} else
							str = "Cette case a d�j� �t� attaqu�e";
					} else
						str = "Coordonn�es invalides";
				}
			}
		} else
			str = "Arme inconnue";
		
		return str;
	}*/
	
	public void addAShoot(Ocean.joueur tireur, Coord coord) {
		if(tireur.equals(Ocean.joueur.moi))
			this.tirsFromMe[coord.x][coord.y].isTargeted = true;
		else
			this.tirsFromEnnemi[coord.x][coord.y].isTargeted = true;
	}
	
	public boolean isDown(Ocean.joueur flotte, String nomBateau) {
		boolean result = false;
		if(flotte.equals(Ocean.joueur.moi))
			result = monJeu.isDown(nomBateau);
		else
			result = ennemi.isDown(nomBateau);
		return result;
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
