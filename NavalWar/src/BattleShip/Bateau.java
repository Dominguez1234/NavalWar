package BattleShip;

public abstract class Bateau {
	
	protected String nom;
	protected int nbrCases = 0;
	
	protected int nbrCasesTouchees = 0;
	protected int positions[][] = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
	
	protected void setPositions(int[][] newPositions) {
		for (int i = 0; i < newPositions.length; i++) {
			this.positions[i][0] = newPositions[i][0];
			this.positions[i][1] = newPositions[i][1];
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
