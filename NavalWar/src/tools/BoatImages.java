package tools;

public enum BoatImages { //Enumeration pour recup les images
	PorteAvions("Porte-Avions","PorteAvion"),
	SousMarin("Sous-Marin","SousMarin"),
	Croiseur("Croiseur","Croiseur"),
	Destroyer("Destroyer","Destroyer"),
	Patrouilleur("Patrouilleur","Patrouilleur"); //String passe en argument, debut du nom de l'image
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
