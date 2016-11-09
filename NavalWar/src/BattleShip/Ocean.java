package BattleShip;

public class Ocean {
	
	private Flotte monJeu = new Flotte();
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
	
	public boolean wasAlreadyAttacked(String from, int[] coord) {
		boolean result = false;
		boolean[][] temp;
		if(from.equals("me"))
			temp = tirsFromMe;
		else
			temp = tirsFromEnnemi;
		
		int x = coord[0];
		int y = coord[1];
		if(temp[x][y])
			result = true;
		
		return result;
	}
	
}
