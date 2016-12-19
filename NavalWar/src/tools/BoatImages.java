package tools;

public enum BoatImages {
	
	SousMarin("Sous-Marin","soum_vert.png");
		public String nom;
	public  String imageFile ;   

	BoatImages(String nom,  String imageFile) { 
		this.nom = nom;
		this.imageFile = imageFile;
	}	
		public static void main(String[] args) {
			
			for (int i = 0; i < BoatImages.values().length; i++) {
				System.out.print(BoatImages.values()[i].nom + " \t"); 
				System.out.print(BoatImages.values()[i].imageFile + " \t"); 
				System.out.println();
			}
	}
}
