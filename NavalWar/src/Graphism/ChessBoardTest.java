package Graphism;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChessBoardTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Image blackBlock=ImageIO.read(new File("c:/ddddd.png"));
            Image whiteBlock=ImageIO.read(new File("c:/ddddd.png"));

            Test board = new Test(whiteBlock,blackBlock);

            //add pieces to board
            board.addPiece(new ImageIcon("c:/dddddd.png"), "A1");//just one example

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}