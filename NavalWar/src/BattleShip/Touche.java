package BattleShip;

public class Touche {
	
	public boolean isTargeted;
	public boolean isTouche;

	public Touche(){
		this.isTargeted = false;
		this.isTouche = false;
	}

	@Override
	public String toString() {
		String affiche="";
		if(isTargeted == true){
			if(isTouche == true)
				affiche = "X";
			else
				affiche= "O";
		}
		else{	
			affiche = "-";	
		}
		return affiche;
	}	
}
