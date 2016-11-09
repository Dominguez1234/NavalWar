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
		if(i > -1) {
			int newPos[][] = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
			int tempPos[] = {-1,-1};
			int x = refPosition[0];
			int y = refPosition[1];
			int j;
			boolean conflit = false;

			for (j = 0; j < bateaux[i].getNbrCases(); j++) {
				newPos[j][0] = x;
				newPos[j][1] = y;
				tempPos[0] = x;
				tempPos[1] = y;
				if(this.isSomethingHere(tempPos))
					conflit = true;
				if(direction.equals("horizontale"))
					y++;
				else
					x++;
			}
			if(!conflit)
				bateaux[i].setPositions(newPos);
		}
	}
	
	public boolean isSomethingHere(int[] newPos) {
		boolean result = false;
		
		for (Bateau b : bateaux) {
			for (int[] pos : b.getPositions()) {
				if(pos[0] != -1 && pos[1] != -1 && pos[0] == newPos[0] && pos[1] == newPos[1])
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
	
	public boolean areAllDown() {
		boolean result = true;
		for (Bateau b : bateaux) {
			result &= b.isDown();
		}
		return result;
	}
	
	private int getIdBateau(String nomBateau) {
		int i=0;
		while(i < bateaux.length && !bateaux[i].getNom().equals(nomBateau))
			i++;
		if(i == -1 && i >= bateaux.length)
			i = -1;
		return i;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Bateau b : bateaux) {
			str += b.toString()+"\n";
		}
		
		int i,j;
		int[] p = {-1,-1};
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				p[0] = i;
				p[1] = j;
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
