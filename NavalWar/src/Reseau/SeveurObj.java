package Reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import BattleShip.Coord;
 
public class SeveurObj {
    static final int port = 2012;
 
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        System.out.println("Socket serveur: " + s);
        
        //création des coordonnées à envoyer
        Coord envoi = new Coord(4,8);
        
        //création du socket
        Socket soc = s.accept();
        System.out.println("Serveur a accepte connexion: " + soc);
        
        //création du tunnel d'envoi
        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());

        out.flush();
        //création du tunnel de réception
        ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
      
        	//envoi objet
        	out.writeObject(envoi); 
        	out.flush();
        	System.out.println("Envoi de l'objet coord: \n x : " + envoi.x +"\n y : " + envoi.y);
        
        	//réception objet
        	Object objetRecu = in.readObject();
        	Coord recu = (Coord) objetRecu;
        	System.out.println("Serveur recoit: \n x : " + recu.x +"\n y : " + recu.y);
        
        //fermeture tunnel, socket
        in.close();
        out.close();
        soc.close();
        s.close();
    }
}