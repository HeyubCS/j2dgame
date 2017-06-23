import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.Math;
import java.io.File;
import java.io.IOException;

//For future study material: http://stackoverflow.com/questions/31171502/scroll-jscrollpane-by-dragging-mouse-java-swing

public class GraphicsPanel extends JPanel implements MouseListener
{
   private BufferedImage spearMan = null;
   private BufferedImage bg = null;
   public void drawPanel(String)
   {
      //TODO: Read world/system data from a file
      //TODO: Load player character/ship data from a file
      //TODO: Load objects from a data file
      try 
      {
         spearMan = ImageIO.read(new File("images/spearmanv3.png"));
         bg       = ImageIO.read(new File("images/bg.png"));
      }
      catch(IOException e)
      {
         //TODO: Error windows
         System.out.println("Failed to load image");
      }

      gameDrawer.drawImage(bg, 0, 0, this);
      //TODO: Whenever there is user input grid drawer should be called.
      int posX, posY = 0;
      gameDrawer.drawImage(spearMan, posX, posY, this);
   }

   /*This is where all the drawing happens */
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g.create();
      g2d.drawImage(bg, 0, 0, this);
      //TODO: fetch x and y positions and angle for player image.
      g2d.drawImage(spearMan, 0, 0, this);
      //TODO: Add a loop that draws all objects.
//      g2d.rotate(rotationAngle, (xPosition + imageXCenter), (yPosition + imageYCenter));
//      g2d.drawImage(objectImage, xPosition, yPosition, this);
      g2d.dispose();
   }
}

