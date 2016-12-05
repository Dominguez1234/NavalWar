package BattleShip;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Reseau.Tir;

public class Reseau {
	
	private int port = 2121;
	private String ipOther;
	private ServerSocket servSoc;
	private Socket soc;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public Reseau(int newPort, String ip) throws IOException {
		this.port = newPort;
		this.ipOther = ip;
	}
	
	public Reseau(String ip) throws IOException {
		this.ipOther = ip;
	}
	
	public void send(Tir tir) throws IOException {
		soc = new Socket(this.ipOther,this.port);
		
		out = new ObjectOutputStream(soc.getOutputStream());
		out.flush(); 
		out.writeObject(tir); 
    	out.flush();
    	
    	out.close();
    	soc.close();
	}
	
	public Tir receive() throws ClassNotFoundException, IOException {
		Tir tir;
		servSoc = new ServerSocket(this.port);
		soc = servSoc.accept();
		in = new ObjectInputStream(soc.getInputStream());
		
		Object objetRecu = in.readObject();
    	tir = (Tir) objetRecu;
    	
    	in.close();
    	soc.close();
    	servSoc.close();
		return tir;
	}
	
	public boolean connexion() {
		
		System.out.println("Tentative de connexion à l'adversaire...");
		
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
				soc = servSoc.accept();
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
