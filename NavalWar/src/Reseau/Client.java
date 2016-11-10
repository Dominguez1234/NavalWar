package Reseau;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	
	public static void main(String[] zero) {
		
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		int i=1;
		Scanner sc = new Scanner(System.in);


		try {
		
			socket = new Socket("134.214.50.83",2009+);	
		    System.out.println("Demande de connexion");
		    System.out.println("Saississez votre pseudo:");
		    String nom = sc.nextLine();
		    out = new PrintWriter(socket.getOutputStream());
		    out.println(nom);
		    out.flush();

		    while(i==1){
		    	//lecture
		    	in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
			    String message_distant = in.readLine();
			    System.out.println(message_distant);
			    //String request = System.in.read();
			    //écriture
			    System.out.println("Votre message:");
			    String str = sc.nextLine();
			    out = new PrintWriter(socket.getOutputStream());
			    out.println(str);
			    out.flush();
			    
			    if (str.equals("fin")){
			    	socket.close();
			    	System.out.println("deconnexion");
			    }
		    }
//		    BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//		    bos.write(request.getBytes());
//	         //Vu que nous utilisons un buffer, nous devons utiliser la méthode flush
//	         //afin que les données soient bien écrite et envoyées au serveur
//	         bos.flush();
	         
		        
		    socket.close();
		       
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}