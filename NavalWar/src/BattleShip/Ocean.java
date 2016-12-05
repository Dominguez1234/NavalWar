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
		
		// Sélection de l'arme.
		if(this.lArmes.containsKey(arme)) {
			for (Coord tir : this.lArmes.get(arme).zoneImpact(cible, sens)) {
				// Vérifier validité coordonées.
				if(continueFire) {
					if(tir.coordonnees_valides()) {
						// Vérifier si la case a déjà été attaquée.
						if(!this.wasAlreadyAttacked(Ocean.joueur.moi, tir)) {
							this.tirsFromEnnemi[tir.x][tir.y].isTargeted = true;
							// Vérifier s'il y a un bateau sur la cible.
							if(this.monJeu.isSomethingHere(tir)) {
								str = "Touché ! ";
								continueFire = false;
								this.tirsFromEnnemi[tir.x][tir.y].isTouche = true;
								this.monJeu.fire(tir);
								// Vérifier si le bateau touché est coulé.
								if(this.monJeu.isDown(tir)) {
									str += "Coulé ! ";
									// Vérifier si tous les bateaux sont coulés.
									if(this.monJeu.areAllDown())
										str += "Fin de la partie.";
								}
							} else
								str = "Loupé";
						} else
							str = "Cette case a déjà été attaquée";
					} else
						str = "Coordonnées invalides";
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
