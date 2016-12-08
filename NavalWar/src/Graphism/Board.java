package Graphism;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class Board implements MouseListener, MouseMotionListener, Observer{

	private JFrame frame;
	public JPanel square;
	public JPanel panel;
	int xInit;
	int yInit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(31, 51, 200, 200);
		frame.getContentPane().add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		panel.setLayout(new GridLayout(10, 10, 0, 0));
		for (int i = 0; i < 100; i++) {
            square = new JPanel( new BorderLayout() );
            panel.add( square );
            square.setBorder(new LineBorder(new Color(0, 0, 0)));
 
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(277, 51, 200, 200);
		frame.getContentPane().add(panel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(31, 300, 200, 21);
		frame.getContentPane().add(textPane);
		//textPane.add(comp);
		
//		for (int j=0; j<5; j++){
//			Component comp = 
//		}
	
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());		
		Component c = panel.findComponentAt(e.getX(), e.getY());
		c.setBackground(Color.green);
		
	}
	public void mousePressed(MouseEvent e){
		
		//square.setBackground(Color.blue);

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
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
