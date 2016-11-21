package BattleShip;

import Boats.Croiseur;
import Boats.Destroyer;
import Boats.Patrouilleur;
import Boats.PorteAvions;
import Boats.SousMarin;

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
	
	public void setPosition(String nomBateau, Coord refPosition, Bateau.direction direction) {
		int i = this.getIdBateau(nomBateau);
		if(i > -1) {
			Coord newPos[] = {
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1), 
					new Coord(-1,-1)
				};
			int j;
			boolean conflit = false;
			Coord ref = new Coord(refPosition.x, refPosition.y);

			for (j = 0; j < bateaux[i].getNbrCases(); j++) {
				newPos[j].x = ref.x;
				newPos[j].y = ref.y;
				if(this.isSomethingHere(newPos[j]))
					conflit = true;
				if(direction.equals(Bateau.direction.horizontale))
					ref.y++;
				else
					ref.x++;
			}
			if(!conflit)
				bateaux[i].setPositions(newPos);
		}
	}
	
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
	
	public boolean isSomethingHere(Coord newPos) {
		boolean result = false;
		
		if(!whoIsHere(newPos).equals("NULL"))
			result = true;
		
		return result;
	}
	
	public boolean isDown(String nomBateau) {
		int i = this.getIdBateau(nomBateau);
		boolean result = false;
		if(i > -1)
			result = bateaux[i].isDown();
		return result;
	}
	
	public boolean isDown(Coord pos) {
		boolean result = false;
		int id = this.getIdBateau(pos);
		if(id > -1)
			result = bateaux[id].isDown();
		return result;
	}
	
	public boolean areAllDown() {
		boolean result = true;
		for (Bateau b : bateaux) {
			result &= b.isDown();
		}
		return result;
	}
	
	public void fire(Coord pos) {
		int id = this.getIdBateau(pos);
		if(id > -1)
			bateaux[id].fire();
	}
	
	private int getIdBateau(String nomBateau) {
		int i=0;
		while(i < bateaux.length && !bateaux[i].getNom().equals(nomBateau))
			i++;
		if(i == -1 && i >= bateaux.length)
			i = -1;
		return i;
	}
	
	private int getIdBateau(Coord position) {
		int id = -1;
		String name = this.whoIsHere(position);
		if(!name.equals("NULL")) {
			id = this.getIdBateau(name);
		}
		return id;
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
