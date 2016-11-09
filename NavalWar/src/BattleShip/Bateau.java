package BattleShip;

public abstract class Bateau {
	
	protected String nom;
	protected int nbrCases = 0;
	
	protected int nbrCasesTouchees = 0;
	protected int positions[][] = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
	
	protected void setPositions(int newPos[][]) {
		this.positions = newPos;
	}
	
	protected void setPositions(int ref[], String direction) {
		int x = ref[0];
		int y = ref[1];
		int i;

		for (i = 0; i < nbrCases; i++) {
			this.positions[i][0] = x;
			this.positions[i][1] = y;
			if(direction.equals("horizontale"))
				y++;
			else
				x++;
		}
	}
	
	public int[][] getPositions() {
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
	
	public boolean isDown() {
		boolean down = false;
		if(this.nbrCasesTouchees >= this.nbrCases)
			down = true;
		return down;
	}
	
	@Override
	public String toString() {
		String str = this.nom+" - "+this.nbrCases+" cases ("+this.nbrCasesTouchees+" touchées)\nPositions : ";
		for (int[] pos : this.positions) {
			str += "["+pos[0]+";"+pos[1]+"] ";
		}
		
		str += "\nCoulé : "+this.isDown()+"\n";
		
		return str;
	}
	
}
