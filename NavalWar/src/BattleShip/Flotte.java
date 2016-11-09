package BattleShip;

public class Flotte {
	
	private Bateau bateaux[] = {
		new PorteAvions(),
		new Croiseur(),
		new Destroyer(),
		new SousMarin(),
		new Patrouilleur()
	};
	
	public void Bateau() {
		
		// I have nothing to do here
		
	}
	
	public void setPosition(String nomBateau, int[] refPosition, String direction) {
		int i = this.getIdBateau(nomBateau);
		if(i > -1)
			bateaux[i].setPositions(refPosition, direction);
	}
	
	public boolean isSomethingHere(int[] newPos) {
		boolean result = false;
		
		for (Bateau b : bateaux) {
			for (int[] pos : b.getPositions()) {
				if(pos[0] == newPos[0] && pos[1] == newPos[1])
					result = true;
			}
		}
		
		return result;
	}
	
	public boolean isDown(String nomBateau) {
		int i = this.getIdBateau(nomBateau);
		boolean result = false;
		if(i > -1)
			result = bateaux[i].isDown();
		return result;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Bateau b : bateaux) {
			str += b.toString()+"\n";
		}
		return str;
	}
	
	private int getIdBateau(String nomBateau) {
		int i=0;
		while(i < bateaux.length && !bateaux[i].getNom().equals(nomBateau))
			i++;
		if(i == -1 && i >= bateaux.length)
			i = -1;
		return i;
	}
	
}
