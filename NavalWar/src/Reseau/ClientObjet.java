package Reseau;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import BattleShip.Coord;

public class ClientObjet {
	
	public static void Envoi(Tir tir) throws UnknownHostException, IOException{
		String serverName = "134.214.50.91"; //adresse IP du serveur distant
		int serverPort = 2012; //port
		Socket socket;
		ObjectOutputStream out;
		socket = new Socket(serverName,serverPort);	//création de la socket
		out = new ObjectOutputStream(socket.getOutputStream());
		out.flush(); 
		out.writeObject(tir);
		out.flush();
		out.close();    
		socket.close();	
		
	}
	public static void main(String[] zero) throws Exception {
	
		String serverName = "134.214.50.91"; //adresse IP du serveur distant
		int serverPort = 2012; //port
		Socket socket;
		ObjectOutputStream out;
		ObjectInputStream in;
		Object objetRecu;
		int i=1;
		
		Coord coord= new Coord(3, 5);
		Object obj;
		//Scanner sc = new Scanner(System.in);


		
		socket = new Socket(serverName,serverPort);	//création de la socket
		System.out.println("Demande de connexion");
		System.out.println("Socket client: " + socket);
		    
		//Création de l'objectoutputstream pour pouvoir envoyer un objet
		out = new ObjectOutputStream(socket.getOutputStream());
		out.flush();
		// création du flux de reception
	    in = new ObjectInputStream(socket.getInputStream());
			    

			//écriture de l'objet coord de type Coord dans le flux d'output
	    out.writeObject(coord);
	    out.flush();
	    System.out.println("Envoi de l'objet coord"); 
	    Object objet = in.readObject();
		Coord recu = (Coord) objet;	      
		System.out.println("Serveur recoit: \n x : " + recu.x +"\n y : " + recu.y);
			 
        //Vu que nous utilisons un buffer, nous devons utiliser la méthode flush
		//afin que les données soient bien écrite et envoyées au serveur
		in.close(); 
		out.close();    
		socket.close();		       
	}

}
