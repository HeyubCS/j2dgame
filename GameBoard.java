
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math.*;
import java.io.*;

public class GameBoard extends JFrame
{
   public static final int PRIMARY_WIDTH  = 800;
   public static final int PRIMARY_HEIGHT = 600;

   public static void main(String [] args)
   {
      new GameBoard();
   }
      boolean forward   = false;
      boolean backward  = false;
      boolean leftward  = false;
      boolean rightward = false;
   //This function might be modified to receive a file as a paramter, which in turn holds a variety of parameters
   // defining the game board. E.G., whether the game board is a planet or a sector in space.
   public GameBoard()
   {

      Scanner         keyboard = new Scanner(System.in); //reading user input
      JFrame          primaryWindow  = new JFrame(); //This is the window frame
      PlayerImage     image          = new PlayerImage("spearmanv4.png"); //PlayerImage is an extention of JPanel (it is a JPanel)
      primaryWindow.setSize(PRIMARY_WIDTH, PRIMARY_HEIGHT);
      primaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      primaryWindow.add(image);
      primaryWindow.setVisible(true);

      //KEY listener, obsolete, needs to be replaced with keybindings
      primaryWindow.addKeyListener(new KeyListener()
      {
         public void keyTyped(KeyEvent e) //I forgot what this does
         {
         }

         public void keyPressed(KeyEvent e) //while a key is pressed this event will loop.
         {
            if(e.getKeyCode() == 87) //w
            {
               image.forward(2);
            }
            else if(e.getKeyCode() == 83) //s
            {
               image.backward(2);
            }
            else if(e.getKeyCode() == 65)//a
            {
               image.rightward(2);
            }
            else if(e.getKeyCode() == 68)//d
            {
               image.leftward(2);
            }
         }

         public void keyReleased(KeyEvent e) //when a key is released this will execute
         {
            if(e.getKeyCode() == 87)
            {
               forward = false;
            }
            else if(e.getKeyCode() == 83)
            {
               backward = false;
            }
            else if(e.getKeyCode() == 65)
            {
               leftward = false;
            }
            else if(e.getKeyCode() == 68)
            {
               rightward = false;
            }
         }
      });

   }
}
