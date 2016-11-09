package BattleShip;

public class Test {
	
	public static void main(String[] args) {
		
		int[] newPos = {1,1};
		int[] newPos2 = {0,0};
		int[] newPos3 = {0,6};
		
		Flotte flotte = new Flotte();
		flotte.setPosition("Porte-Avions", newPos2, "verticale");
		flotte.setPosition("Croiseur", newPos, "horizontale");
		System.out.println(flotte);
		System.out.println("Test de position : "+flotte.isSomethingHere(newPos));
		System.out.println("Porte-Avions coulé ? "+flotte.isDown("Porte-Avions"));
		System.out.println("");
		
		int i,j;
		int[] p = {-1,-1};
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				p[0] = i;
				p[1] = j;
				if(flotte.isSomethingHere(p))
					System.out.print("X  ");
				else
					System.out.print("-  ");
			}
			System.out.println("");
		}
		
	}
	
}
