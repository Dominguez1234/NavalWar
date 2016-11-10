package BattleShip;

public class Ocean {
	
	public Flotte monJeu = new Flotte();
	private Flotte ennemi = new Flotte();
	
	private boolean[][] tirsFromMe = {
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false},
			{false,false,false,false,false,false,false,false,false,false}
	};
	
	private boolean[][] tirsFromEnnemi = tirsFromMe.clone();
	
	public static enum joueur {
		moi,
		ennemi
	}
	
	public boolean wasAlreadyAttacked(Ocean.joueur from, Coord coord) {
		boolean result = false;
		boolean[][] temp;
		if(from.equals(Ocean.joueur.moi))
			temp = tirsFromMe;
		else
			temp = tirsFromEnnemi;
		
		result = temp[coord.x][coord.y];
		
		return result;
	}
	
	public String fire(Coord tir) {
		String str = "";
		if(tir.coordonnees_valides()) {
			if(!this.wasAlreadyAttacked(Ocean.joueur.moi, tir)) {
				this.tirsFromEnnemi[tir.x][tir.y] = true;
				if(this.monJeu.isSomethingHere(tir)) {
					str = "Touch� ! ";
					this.monJeu.fire(tir);
					if(this.monJeu.isDown(tir)) {
						str += "Coul� ! ";
						if(this.monJeu.areAllDown())
							str += "Fin de la partie.";
					}
				} else
					str = "Loup�";
			} else
				str = "Cette case a d�j� �t� attaqu�e";
		} else
			str = "Coordonn�es invalides";
		
		return str;
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
		
		for (boolean[] bs : tirsFromMe) {
			for (boolean b : bs) {
				if(b) 
					str += "X  ";
				else
					str += "-  ";
			}
			str += "\n";
		}
		str += "\n";
		return str;
	}
	
}
