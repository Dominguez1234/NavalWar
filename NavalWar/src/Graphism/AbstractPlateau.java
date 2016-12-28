package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public abstract class AbstractPlateau implements MouseListener, MouseMotionListener, Observer, KeyListener {
	public AbstractPlateau(int posx, int posy) {
		super();
		this.posx = posx;
		this.posy = posy;
	}
	public int posx,posy;
	public  JPanel plateau;
	public JPanel square;
	
	public JPanel creationPlateau(){
		
		plateau = new JPanel();
		plateau.setBounds(posx, posy, 325, 325);
		plateau.setBorder(new LineBorder(Color.BLACK));
		plateau.setLayout(new GridLayout(10, 10, 0, 0));
		for(int i = 0; i < 100; i++){
			JPanel square = new JPanel(new BorderLayout());
			plateau.add(square);
			square.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		plateau.addMouseListener(this);
		plateau.addMouseMotionListener(this);
		plateau.addKeyListener(this);
		plateau.setFocusable(true);
		return plateau;
	}
	
	public JPanel Chiffres(){
		//Lettres du dessus
       int posChiffresX = posx-33;
		        //Chiffre � gaucheframe
		  		JPanel Chiffres = new JPanel();
		  		Chiffres.setBounds(posChiffresX, posy, 26, 325);
		  		Chiffres.setOpaque(false);
		  		
		  		GridLayout grilleChiffres = new GridLayout(10, 0);
		  		Chiffres.setLayout(grilleChiffres);
		  		JLabel[] lbls1 = new JLabel[10];
			      for (int i = 0; i < 10; i++) {
			    	  lbls1[i] = new JLabel(i+1 + "");
			    	  Chiffres.add(lbls1[i]);
			      }
			      return Chiffres;
	}
	public JPanel Lettres(){
		int posChiffresy = 107;
		JPanel Lettres = new JPanel();
		Lettres.setBounds(posx, posChiffresy, 325, 26);
		Lettres.setOpaque(false);
		
		GridLayout grilleLettres = new GridLayout(0, 10);
		Lettres.setLayout(grilleLettres);
		JLabel[] lbls = new JLabel[10];
		String[] labelLettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < 10; i++) {
        	lbls[i] = new JLabel("    " + labelLettres[i] + "");
        	Lettres.add(lbls[i]);

        }
        return Lettres;
	}
	@Override
	public abstract void keyPressed(KeyEvent e);
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void  mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public  abstract void mouseClicked(MouseEvent e);
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
