package BattleShip;

public abstract class Bateau {
	
	protected String nom;
	protected int nbrCases = 0;
	
	protected int nbrCasesTouchees = 0;
//	protected int positions[][] = {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
	protected Coord positions[] = {
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1), 
		new Coord(-1,-1)
	};
	
//	protected void setPositions(int[][] newPositions) {
//		for (int i = 0; i < newPositions.length; i++) {
//			this.positions[i][0] = newPositions[i][0];	// x
//			this.positions[i][1] = newPositions[i][1];	// y
//		}
//	}
	
	protected void setPositions(Coord[] newPositions) {
		for (int i = 0; i < newPositions.length; i++) {
			this.positions[i].x = newPositions[i].x;	// x
			this.positions[i].y = newPositions[i].y;	// y
		}
	}
	
//	public int[][] getPositions() {
//		return this.positions;
//	}
	
	public Coord[] getPositions() {
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
		String str = this.nom+" - "+this.nbrCases+" cases ("+this.nbrCasesTouchees+" touch�es)\nPositions : ";
		for (Coord pos : this.positions) {
			str += "["+pos.x+";"+pos.y+"] ";
		}
		
		str += "\nCoul� : "+this.isDown()+"\n";
		
		return str;
	}
	
}
