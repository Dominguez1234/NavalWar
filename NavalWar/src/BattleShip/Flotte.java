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
			Coord newPos[] = {
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1)
				};
			int x = refPosition[0];
			int y = refPosition[1];
			int j;
			boolean conflit = false;

			for (j = 0; j < bateaux[i].getNbrCases(); j++) {
				newPos[j].x = x;
				newPos[j].y = y;
				if(this.isSomethingHere(newPos[j]))
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
	
	public boolean isSomethingHere(Coord newPos) {
		boolean result = false;
		
		for (Bateau b : bateaux) {
			for (Coord pos : b.getPositions()) {
				if(pos.x != -1 && pos.y != -1 && pos.x == newPos.x && pos.y == newPos.y)
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
