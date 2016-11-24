package Reseau;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import BattleShip.Coord;
 
public class SeveurObj {
    static final int port = 2011;
 
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(port);
        System.out.println("Socket serveur: " + s);
 
        Socket soc = s.accept();
 
        System.out.println("Serveur a accepte connexion: " + soc);
 
        ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
        out.flush();
 
        ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
 
        System.out.println("Serveur a cree les flux");
 
        Object objetRecu = in.readObject();
        Coord recu = (Coord) objetRecu;
        
        
        System.out.println("Serveur recoit: \n x : " + recu.x +"\n y : " + recu.y);
 
        in.close();
        out.close();
        soc.close();
        s.close();
    }
}