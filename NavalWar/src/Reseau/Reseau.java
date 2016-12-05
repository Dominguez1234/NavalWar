package Reseau;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Reseau {
	
	private int port;
	private String ipOther;
	private ServerSocket servSoc;
	private Socket soc;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	
	public Reseau(int newPort, String ip) throws IOException {
		this.port = newPort;
		this.ipOther = ip;
	}
	
	public void send(Tir tir) throws IOException {
		System.out.println("lol");
		
		soc = new Socket(this.ipOther,this.port);
		
		out = new ObjectOutputStream(soc.getOutputStream());
		out.flush(); 
		out.writeObject(tir); 
    	out.flush();
    	
    	out.close();
    	soc.close();
    	
    	System.out.println("Envoi objet "+tir.getClass()+" : "+tir.toString());
	}
	
	public Tir receive() throws ClassNotFoundException, IOException {
		Tir tir;
		
		servSoc = new ServerSocket(this.port);
		System.out.println("Socket serveur: " + servSoc);
		soc = servSoc.accept();
		in = new ObjectInputStream(soc.getInputStream());
		
		Object objetRecu = in.readObject();
    	tir = (Tir) objetRecu;
    	
    	in.close();
    	soc.close();
    	servSoc.close();
    	
    	System.out.println("Reception objet "+tir.getClass()+" : "+tir.toString());
		return tir;
	}
	
	public void end() throws IOException {
		in.close();
        out.close();
        soc.close();
        servSoc.close();
	}
	
}
