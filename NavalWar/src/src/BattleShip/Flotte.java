package BattleShip;

public class Flotte {
	
	private Bateau bateaux[] = {
		new PorteAvions(),
		new Croiseur()
	};
	
	public void Bateau() {
		
		// I have nothing to do here
		
	}
	
	public void setPosition(String nomBateau, int[] refPosition, String direction) {
		int i=0;
		while(i < bateaux.length && !bateaux[i].getNom().equals(nomBateau))
			i++;
		if(i > -1 && i < bateaux.length)
			bateaux[i].setPositions(refPosition, direction);
	}
	
	public boolean isSomethingHere(int[] pos) {
		boolean result = false;
		
		
		
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
	
}
