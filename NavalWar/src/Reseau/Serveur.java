package Reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Serveur {
	
	public static void main(String[] zero) {
		
		
		ServerSocket socketserver  ;
		Socket socketduserveur;
		BufferedReader in;
		PrintWriter out;
		Scanner sc = new Scanner(System.in);
		
		try {
		
			socketserver = new ServerSocket(2009);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socketduserveur = socketserver.accept(); 
		        System.out.println("Un joueur s'est connecté");
		        
		        out = new PrintWriter(socketduserveur.getOutputStream());
		        out.println("Vous êtes connecté au serveur NAVALOIRE !");
		        out.flush();
		        
		        in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
	        	String username = in.readLine();
	        	System.out.println("Le joueur s'appelle : "+username);
	        	
		        int i=1;
		        while(i==1){
		        	in = new BufferedReader(new InputStreamReader(socketduserveur.getInputStream()));
		        	String message = in.readLine();
		        	System.out.println(username+" dit : "+message);
		        
		        	out = new PrintWriter(socketduserveur.getOutputStream());
		        	System.out.println("Que voulez vous envoyer :\n");
		        	String str = sc.nextLine();		        	
		        	out.println(str);
		        	out.flush();
		        	System.out.println("Attendez que "+username+" ait envoyé un message\n");
		        	if(str.equals("fin")){
		        		socketduserveur.close();
				        socketserver.close();
		        	}
		        }
		        
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
