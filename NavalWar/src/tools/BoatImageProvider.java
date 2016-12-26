package tools;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import Boats.Bateau;
import Boats.Bateau.direction;

public class BoatImageProvider {
	private static Map<String, String> mapImage; //Map qui fait correspondre le string au chemin de la premiere image
	static {		
		mapImage = new HashMap<String, String>();
		for (int i = 0; i < BoatImages.values().length; i++) {
			mapImage.put(BoatImages.values()[i].nom, BoatImages.values()[i].imageFile);
		}	
	}
	private BoatImageProvider() {

	}	
	

	public static String[] getImageFile(String nomBateau, direction dir){
		int k =3; // 2 Bateau possede 3 cases ( reduction des if)
		int j =1; // Incrementation du fichier image
		int i =0; 
		String[] ret; // recupere les images dans un tableau
		
		String key, value,img;
		key = nomBateau; // String passe en parametre
		value = mapImage.get(key);
		File g=new File("");
		if(nomBateau.equals("Porte-Avions")) // On change le nombre d'image en fonction du bateau
			k=5;
		if(nomBateau == "Croiseur")
			k=4;
		if(nomBateau == "Patrouilleur")
			k=2;
		ret = new String [k];
		if (dir.equals(Bateau.direction.verticale)){ // on selectionne des images differentes si le sens est verticale
		for(i=0;i<k;i++){
			img=g.getAbsolutePath()+"/Images/" + value + j + ".png";
			ret[i] = img;
			j++;
		}
		}
		else{ // si le sens est hroizontale
			for(i=0;i<k;i++){
				img=g.getAbsolutePath()+"/Images/" + value + "V" + j + ".png";
				ret[i] = img;
				j++;
			}
		}
		return ret; // retourne le tableau de chemin d'images
	}

	/**
	 * Test unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		String[] img;
		img =BoatImageProvider.getImageFile("Sous-Marin",Bateau.direction.verticale);
		for(String toPrint : img){
		System.out.println(toPrint);
	
	}
	}
}