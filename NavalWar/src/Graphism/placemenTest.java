package Graphism;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Window;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextPane;


public class placemenTest extends JFrame implements MouseListener, MouseMotionListener, Observer {
   
	JLayeredPane layeredPane;
    JPanel Plateau;
    int xAdjustment;
    int yAdjustment;
    int xInit;
    int yInit;

    public placemenTest(){

    	Dimension dim = new Dimension(800,800);
        this.setPreferredSize(dim);
        this.setResizable(false);
        //  Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(dim);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        this.pack();

        //Add a chess board to the Layered Pane
        Plateau = new JPanel();
        layeredPane.add(Plateau, JLayeredPane.DEFAULT_LAYER);
        Plateau.setLayout( new GridLayout(10, 10) );
        Plateau.setPreferredSize( dim );
        Plateau.setBounds(0, 0, this.getContentPane().getWidth(), this.getContentPane().getHeight());

        for (int i = 0; i < 100; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            Plateau.add( square );
        }

    }

    public void mousePressed(MouseEvent e){

        Component c =  Plateau.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;

        this.xInit = e.getX() / c.getWidth();
        this.yInit = e.getY() / c.getHeight();

    }

    //Move the chess piece around

    public void mouseDragged(MouseEvent me) {
 
    }

    //Drop the chess piece back onto the chess board

    public void mouseReleased(MouseEvent e) {
     
    }

    public void mouseClicked(MouseEvent e) {

    }
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void update(Observable o, Object arg) {


        Plateau.removeAll();

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel( new BorderLayout() );
            Plateau.add( square );

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground( i % 2 == 0 ? new Color(44, 62, 80) : new Color(236, 240, 241) );
            else
                square.setBackground( i % 2 == 0 ? new Color(236, 240, 241) : new Color(44, 62, 80) );
        }


        this.revalidate();
    }
    public static void main(String[] args) {
    	placemenTest window = new placemenTest();
    	window.setVisible(true);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.pack();
	}


}