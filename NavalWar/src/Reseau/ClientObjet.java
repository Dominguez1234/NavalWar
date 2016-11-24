package Reseau;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import BattleShip.Coord;

public class ClientObjet {
public static void main(String[] zero) throws Exception {
		String serverName = "134.214.50.90";
		int serverPort = 2011;
		Socket socket;
		ObjectOutputStream out;
		ObjectInputStream in;
		Object objetRecu;
		
		Coord coord= new Coord(3, 5);
		//Scanner sc = new Scanner(System.in);


		
			socket = new Socket(serverName,serverPort);	
		    System.out.println("Demande de connexion");
		    System.out.println("Socket client: " + socket);
		    
		    //Création de l'objectoutputstream pour pouvoir envoyer un objet
		    out = new ObjectOutputStream(socket.getOutputStream());
	        //out.flush();
	        in = new ObjectInputStream(socket.getInputStream());
			    
			    //écriture de l'objet coord de type Coord
			    out.writeObject(coord);
			    out.flush();
			    System.out.println("Envoi de l'objet coord");
			    
			    //objetRecu = in.readObject();
			 
//	         //Vu que nous utilisons un buffer, nous devons utiliser la méthode flush
//	         //afin que les données soient bien écrite et envoyées au serveur
			in.close();
		    out.close();    
		    socket.close();
		       
	}


}
