package BattleShip;

import java.util.ArrayList;

import Boats.AbstractBateau;
import Boats.Bateau;
import Boats.Croiseur;
import Boats.Destroyer;
import Boats.Patrouilleur;
import Boats.PorteAvions;
import Boats.SousMarin;

/*
 * Classe Flotte contenant tous les bateaux d'un joueur
 */

public class Flotte {
	
	// Attributs
	private Bateau bateaux[] = {
		new PorteAvions(),
		new Croiseur(),
		new Destroyer(),
		new SousMarin(),
		new Patrouilleur()
	};
	
	// Constructeur
	public void Bateau() {
		// I have nothing to do here
	}
	
	// Modifier la position d'un bateau
//	public void setPosition(String nomBateau, Coord refPosition, Bateau.direction direction) {
//		int i = this.getIdBateau(nomBateau);	// Récupère l'ID de la case où se trouve le bateau
//		if(i > -1) {							// Si le bateau existe dans le tableau
//			Coord newPos[] = {
//					new Coord(-1,-1), 
//					new Coord(-1,-1), 
//					new Coord(-1,-1), 
//					new Coord(-1,-1), 
//					new Coord(-1,-1)
//				};
//			int j;
//			boolean conflit = false;
//			Coord ref = new Coord(refPosition.x, refPosition.y);
//			
//			// Calcul de la position de chaque case du bateau
//			for (j = 0; j < bateaux[i].getNbrCases(); j++) {
//				newPos[j].x = ref.x;
//				newPos[j].y = ref.y;
//				if(this.isSomethingHere(newPos[j]))		// Vérifie qu'aucun bateau de s'y trouve déjà
//					conflit = true;
//				// Incrémentation en fonction de la direction
//				if(direction.equals(Bateau.direction.horizontale))
//					ref.y++;
//				else
//					ref.x++;
//			}
//
//			if(!conflit)	// Si aucun conflit avec un autre bateau
//				bateaux[i].setPositions(newPos);
//		}
//	}
	
	public void setPosition(String nomBateau, Coord refPosition, Bateau.direction direction) {
		int i = this.getIdBateau(nomBateau);	// Récupère l'ID de la case où se trouve le bateau
		boolean conflit = false;
		if(i > -1) {							// Si le bateau existe dans le tableau
			 ArrayList<Coord> newPos = bateaux[i].calculPositions(refPosition, direction);
			for(Coord pos : newPos) {
				if(this.isSomethingHere(pos))
					conflit = true;
			}
			if(!conflit)
				bateaux[i].setPositions(newPos);
		}
	}
	
	// Retourne le nom du bateau se trouvant à une position
	public String whoIsHere(Coord pos) {
		String result = "NULL";
		for (Bateau b : bateaux) {
			for (Coord c : b.getPositions()) {
				if(c.x != -1 && c.y != -1 && c.x == pos.x && c.y == pos.y)
					result = b.getNom();
			}
		}
		return result;
	}
	
	// Renvoie VRAI si un bateau est présent sur une case
	public boolean isSomethingHere(Coord newPos) {
		boolean result = false;
		
		if(!whoIsHere(newPos).equals("NULL"))
			result = true;
		
		return result;
	}
	
	// Renvoie VRAI si le bateau est coulé
	public boolean isDown(String nomBateau) {
		int i = this.getIdBateau(nomBateau);
		boolean result = false;
		if(i > -1)
			result = bateaux[i].isDown();
		return result;
	}
	
	// Renvoie VRAI si le bateau situé sur une case donnée est coulé.
	public boolean isDown(Coord pos) {
		boolean result = false;
		int id = this.getIdBateau(pos);
		if(id > -1)
			result = bateaux[id].isDown();
		return result;
	}
	
	// Renvoie VRAI si tous les bateaux sont coulés => fin de la partie
	public boolean areAllDown() {
		boolean result = true;
		for (Bateau b : bateaux) {
			result &= b.isDown();
		}
		return result;
	}
	
	// Exécute un tir (envoi l'information au bateau concerné)
	public void fire(Coord pos) {
		int id = this.getIdBateau(pos);
		if(id > -1)
			bateaux[id].fire();
	}
	
	// Renvoie l'ID du bateau dans le tableau
	private int getIdBateau(String nomBateau) {
		int i=0;
		while(i < bateaux.length && !bateaux[i].getNom().equals(nomBateau))
			i++;
		if(i == -1 && i >= bateaux.length)
			i = -1;
		return i;
	}
	
	// Renvoie l'ID du bateau situé sur une case
	private int getIdBateau(Coord position) {
		int id = -1;
		String name = this.whoIsHere(position);
		if(!name.equals("NULL")) {
			id = this.getIdBateau(name);
		}
		return id;
	}
	
	// Renvoie l'abstractBateau d'un bateau donné
	public AbstractBateau getAbstractBateau(String nom) {
		AbstractBateau ab = new AbstractBateau();
		for (Bateau b : bateaux) {
			if(b.getNom().equals(nom))
				ab = b.getAbstract();
		}
		return ab;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Bateau b : bateaux) {
			str += b.toString()+"\n";
		}
		
		int i,j;
		Coord p = new Coord(-1,-1);
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				p.x = i;
				p.y = j;
				if(this.isSomethingHere(p))
					str += "X  ";
				else
					str += "-  ";
			}
			str += "\n";
		}
		return str;
	}
	
}
