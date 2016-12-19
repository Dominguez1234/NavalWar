package tools;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BoatImageProvider {
	private static Map<String, String> mapImage;
	static {		
		mapImage = new HashMap<String, String>();
		for (int i = 0; i < BoatImages.values().length; i++) {
			mapImage.put(BoatImages.values()[i].nom, BoatImages.values()[i].imageFile);
		}	
	}
	private BoatImageProvider() {

	}	
	

	public static String getImageFile(String nomBateau){
		String ret, key, value;
		ret = null;
		key = nomBateau;
		value = mapImage.get(key);
		File g=new File("");
		ret = g.getAbsolutePath()+"/Images/" + value;
		return ret;		
	}

	/**
	 * Test unitaires
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(BoatImageProvider.getImageFile("Sous-Marin"));
	}

}