package BattleShip;

public class BoucleReseau {
	
	public static void main(String[] args) {
		BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
		
		while(true)
			bs.connexion("127.0.0.1");
	}
	
	
}
