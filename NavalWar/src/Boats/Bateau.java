package Boats;

import BattleShip.Coord;

/*
 * Classe bateau
 * Doit �tre �tendu par une autre classe partant le nom du bateau
 */

public abstract class Bateau {
	
	// Attributs
	protected String nom;
	protected int nbrCases = 0;
	
	protected int nbrCasesTouchees = 0;
	protected Coord positions[] = {
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1)
	};
	
	public static enum direction {
		horizontale,
		verticale
	}
	
	// Modifier la position
	public void setPositions(Coord[] newPositions) {
		for (int i = 0; i < newPositions.length; i++) {
			this.positions[i].x = newPositions[i].x;	// x
			this.positions[i].y = newPositions[i].y;	// y
		}
	}
	
	// Renvoie un tableau avec toutes les coordon�es du bateau
	public Coord[] getPositions() {
		return this.positions;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbrCases() {
		return this.nbrCases;
	}
	
	public int getNbrCasesTouchees() {
		return this.nbrCasesTouchees;
	}
	
	// Renvoie VRAI si coul�
	public boolean isDown() {
		boolean down = false;
		if(this.nbrCasesTouchees >= this.nbrCases)
			down = true;
		return down;
	}
	
	// Comptabilise le tir
	public void fire() {
		this.nbrCasesTouchees++;
	}
	
	// Renvoie l'abstract du bateau
	public AbstractBateau getAbstract() {
		return new AbstractBateau(this.nom, this.nbrCases);
	}
	
	@Override
	public String toString() {
		String str = this.nom+" - "+this.nbrCases+" cases ("+this.nbrCasesTouchees+" touch�es)\nPositions : ";
		for (Coord pos : this.positions) {
			str += "["+pos.x+";"+pos.y+"] ";
		}
		
		str += "\nCoul� : "+this.isDown()+"\n";
		
		return str;
	}
	
}
