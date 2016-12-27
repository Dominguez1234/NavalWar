package Graphism;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BattleShip.BattleShip;
import BattleShip.Coord;
import Boats.AbstractBateau;
import Boats.Bateau;
import tools.BoatImageProvider;

public class MonPlateau extends AbstractPlateau {
	Bateau.direction dir = Bateau.direction.verticale;
	String mes = "Horizontal";
	private int xInit;
	private int yInit;
	 ArrayList<AbstractBateau> al;
	
	// ----- A SUPPRIMER
	BattleShip bs = new BattleShip(BattleShip.modeJeu.TOTALWAR);
	public MonPlateau(int posx, int posy, ArrayList<AbstractBateau> al) {
		super(posx, posy);
		this.al=al;
		// TODO Auto-generated constructor stub
	}

	static int index=0;
	@Override
	public void keyPressed(KeyEvent e) {
		if(MonPlateau.getIndex()<=4){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			dir= Bateau.direction.horizontale;
			mes="Vertical";
			BoardDeux.textArea.setText("sens : " + mes +"\nPlacer le "+al.get(MonPlateau.getIndex()).getNom()+"\n" +"("+al.get(MonPlateau.getIndex()).getNbrCases()+" cases)\n");
			}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dir = Bateau.direction.verticale;
			mes="Horizontal";
			BoardDeux.textArea.setText("sens : " + mes +"\nPlacer le "+al.get(MonPlateau.getIndex()).getNom()+"\n" +"("+al.get(MonPlateau.getIndex()).getNbrCases()+" cases)\n");
		}
		}
		else{}	
	}
	public static int getIndex(){
		return index;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int cox,coy,pos;
		Coord testCo = new Coord();
		boolean co_Valid=true;
		ArrayList<Coord> coo;
		if(index<=4){
			if (index==4){
				BoardDeux.textArea.setText("Cliquer sur jouez");
				BoardDeux.btnJouer.setEnabled(true);
				}
				else{			

					BoardDeux.textArea.setText("sens : " + mes +"\nPlacer le "+al.get(index+1).getNom()+"\n" +"("+al.get(index+1).getNbrCases()+" cases)\n");
					}
			Component c = Plateau.findComponentAt(e.getX(), e.getY());
			this.xInit = (e.getX() / ((c.getWidth())))+1;
	        this.yInit = (e.getY() / ((c.getHeight())))+1;
	        Coord coord = new Coord(xInit,yInit);
	        coo = al.get(index).calculPositions(coord, dir);	
	        System.out.println("\n\n"+coo+"\n");
	        
	        for(Coord o: coo){
	        	cox=(o.x)-1;
	        	coy=(o.y)-1;
	        	testCo.x =cox;
	        	testCo.y =coy;
	        	co_Valid &= testCo.coordonnees_valides(); // Check des bordures
	        	co_Valid &= !bs.isSomethingHere(o); //Check si il y a un bateau
	        	}
	       
	        if(co_Valid==true){ // Si toutes les conditions sont reunies
	        	
	     int i =0;
 		String[] img;
 		img =BoatImageProvider.getImageFile(al.get(index).getNom(), dir); // On récupere les images correspondant au bateau dans un tab
	        System.out.println(img[i]);	
 		bs.setPosBoat(al.get(index).getNom(),coord, dir); // maj de bs (placement du bateau)
	        for(Coord o: coo){ // Pour toutes les emplacements du bateau
	        	//Ajout des images
	         	pos = o.x-1 + (o.y-1)*10 ; // Calcul de la position de l'image en fonction de la co
	    			JLabel image = new JLabel( new ImageIcon(img[i]));// on va chercher l'image dans le tableau
	    			JPanel panel1 = (JPanel) Plateau.getComponent(pos); 
	    			panel1.add(image);
	    			i++;	
	        }
	        
	        index++;
	        }
	        else{	
	        	BoardDeux.textArea.setText("Erreur de placement");
	        }
		
	}
		else{

		}
			    		
	}

}
