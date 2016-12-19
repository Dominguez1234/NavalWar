package BattleShip;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Classe permetant la connexion TCP entre les deux joueurs.
 * Permet d'envoyer et recevoir des objets de type Tir
 */

public class Reseau {
	
	// Attributs
	private int port = 2121;
	private String ipOther;
	private ServerSocket servSoc;
	private Socket soc;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	// Constructeur avec IP et port
	public Reseau(String ip, int newPort) throws IOException {
		this.port = newPort;
		this.ipOther = ip;
	}
	
	// Constructeur avec IP
	public Reseau(String ip) throws IOException {
		this.ipOther = ip;
	}
	
	// Envoyer un objet de type Tir
	public void send(Tir tir) throws IOException {
		soc = new Socket(this.ipOther,this.port);			// Création du socket
		
		out = new ObjectOutputStream(soc.getOutputStream());// Tunnel de sortie
		out.flush(); 
		out.writeObject(tir); 								// Envoi de l'objet
    	out.flush();
    	
    	// Fermeture du tunnel et du socket
    	out.close();
    	soc.close();
	}
	
	// Réception d'un objet de type Tir
	public Tir receive() throws ClassNotFoundException, IOException {
		Tir tir;
		servSoc = new ServerSocket(this.port);				// Création du port d'écoute
		soc = servSoc.accept();								// En attente de la connexion d'un client
		in = new ObjectInputStream(soc.getInputStream());	// Tunnel d'entrée
		
    	tir = (Tir) in.readObject();						// Réception de l'objet Tir
    	
    	// Fermeture du tunnel, socket, et port d'écoute
    	in.close();
    	soc.close();
    	servSoc.close();
    	
    	// Retourne l'objet Tir
		return tir;
	}
	
	// Vérifie la connexion entre deux joueurs
	public boolean connexion() {
		
		System.out.println("Tentative de connexion à "+this.ipOther+":"+this.port+"...");
		
		try {
			// Connexion en tant que client
			soc = new Socket(this.ipOther,this.port);
			soc.close();
			System.out.println("Connexion réussie");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// Erreur : aucun serveur => passage en mode serveur en attendant l'adversaire
			System.out.println("En attente de l'adversaire...");
			
			try {
				servSoc = new ServerSocket(this.port);
				soc = servSoc.accept();					// En attente que l'adversaire essaie de se connecter
				System.out.println("Connexion réussie");
				soc.close();
				servSoc.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		return true;
	}
	
}
