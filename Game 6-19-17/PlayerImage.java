
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class PlayerImage extends JPanel
{
   private BufferedImage objectImage;

   public  int xPosition,
               yPosition,
               imageWidth,
               imageHeight,
               imageXCenter,
               imageYCenter;

   public double rotationAngle;


   public PlayerImage(String objectImageName)
   {
      try //try image for loading errors
      {
         System.out.println("Loading image: " + objectImageName);
         objectImage = ImageIO.read(new File(objectImageName));
         imageWidth  = objectImage.getWidth();
         imageHeight = objectImage.getHeight();
         imageXCenter = (imageWidth / 2);
         imageYCenter = (imageHeight / 2);
         repaint();
      }
      catch (IOException ex)
      {
         ex.printStackTrace();
      }
   }

 /* Move player */
   public void forward(int speedmod)
   {
      yPosition = yPosition - (1 * speedmod);
      repaint();
   }
   public void backward(int speedmod)
   {
      yPosition = yPosition + (1 * speedmod);
      repaint();
   }
   public void leftward(int speedmod)
   {
      xPosition = xPosition + (1 * speedmod);
      repaint();
   }
   public void rightward(int speedmod)
   {
      xPosition = xPosition - (1 * speedmod);
      repaint();
   }
   


   public void setPosition(int xUpLeft, int yUpLeft)
   {
      xPosition = xUpLeft;
      yPosition = yUpLeft;
      repaint();
   }

   public void setAngle(double angle)
   {
      rotationAngle = angle;
      repaint();
   }

   @Override
   public Dimension getPreferredSize() //Tell java the size of the player image.
   {
      return new Dimension(objectImage.getWidth(), objectImage.getHeight());
   }

   @Override
   protected void paintComponent(Graphics g) //When java refreshes graphics it will run this function.
   {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g.create();
      g2d.rotate(rotationAngle, (xPosition + imageXCenter), (yPosition + imageYCenter));
      g2d.drawImage(objectImage, xPosition, yPosition, this);
      g2d.dispose();
   }
}
