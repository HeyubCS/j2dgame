import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.Math;

//For future use: http://stackoverflow.com/questions/31171502/scroll-jscrollpane-by-dragging-mouse-java-swing

public class DrawPanel extends JPanel implements MouseListener
{
   public static final int  GRID_SIZE = 50;
   public static final int  GRID_LENGTH = 2500;
   public static final int  GRID_COUNT = 51; //GRID_LENGTH / GRID_SIZE + 1
   public static final int  MID_GRID = 25;

   public boolean showGrid = true;
   public BufferedImage spearMan;
   public BufferedImage bg;
   private boolean init = true; //declared here for loops that should only be run once
   int xMove;
   int yMove;
   boolean liveCommand;
   boolean unitSelected = false;
   public int[] xCoord = new int[GRID_COUNT];
   public int[] yCoord = new int[GRID_COUNT];

   public void drawBoard(Graphics2D gridDrawer)
   {
      int xLine = 0; //initial line position. For graph x = y
      int yLine = 0;

      /* Initialization stuff. */

      if (init)
      {
           this.addMouseListener(this);
         for(int i = 0; i < GRID_COUNT; i++)
         {
           xCoord[i] = (i * GRID_SIZE);
           yCoord[i] = (i * GRID_SIZE);
         }

         try 
         {
            spearMan = ImageIO.read(new File("spearmanv3.png"));
            bg       = ImageIO.read(new File("bg.png"));
         }
         catch(IOException e)
         {
            System.out.println("Failed to load image");
         }
         init = false;
      }

      /* Draw map grid */

      gridDrawer.drawImage(bg, 0, 0, this);
      if(showGrid)
      {
         gridDrawer.setColor(Color.GRAY); //gray grid

         /* vertical lines */
         for(int i = 0; i < GRID_COUNT; i++)
         {
            gridDrawer.drawLine(xLine, yLine, xLine, GRID_LENGTH);
            xLine += GRID_SIZE; //10 pixel grid.
         }
         xLine = 0; //Reset xLine to initial position

         /* horizontal lines */
         for(int i = 0; i < GRID_COUNT; i++)
         {
            gridDrawer.drawLine(xLine, yLine, GRID_LENGTH, yLine);
            yLine += GRID_SIZE;
         }
      }

      /* Draw movement grid */

      if (unitSelected)
      {
         System.out.println("Fill rect!!");
         gridDrawer.setColor(Color.BLUE);
         int maxMove = 4;
         int yChange = yMove;
         /* X */
      while (maxMove >= 1)
      {
         System.out.println(maxMove);
         for(int next = 0; next <= maxMove; next++)
         {
            
            //X Directions
            if(xMove + next <= GRID_COUNT)
            {
               gridDrawer.fill(new Rectangle((xCoord[xMove + next]), (yCoord[yChange]), GRID_SIZE, GRID_SIZE));
                System.out.println((xCoord[xMove + next]) + ", " + yCoord[yChange]);
            }
            if(xMove - next >= 0)
            {
              gridDrawer.fill(new Rectangle((xCoord[xMove - next]), (yCoord[yChange]), GRID_SIZE, GRID_SIZE));
            }
            //Y Directions
            if(yMove + next <= GRID_COUNT)
            {
               gridDrawer.fill(new Rectangle((xCoord[xMove]), (yCoord[yChange + next]), GRID_SIZE, GRID_SIZE));
            }
            if(yChange - next >= 0)
            {
              gridDrawer.fill(new Rectangle((xCoord[xMove]), (yCoord[yChange - next]), GRID_SIZE, GRID_SIZE));
            }
         }
         if (yChange > 0)
         {
            yChange --;
         }
         maxMove--;
      }
      }

      /* Draw spearman */
      gridDrawer.drawImage(spearMan, xCoord[xMove], yCoord[yMove], this);

   } 
   
   public void setPosition(int x, int y)
   {
         if( x >= 0 && x <= 49 && y >= 0 && y <= 49)
         {
            xMove = x;
            yMove = y;
            repaint();
         }
         else
            System.out.println("Coordinates must be between 0 and 49");
   }

   public void mapClicked(int pointX, int pointY)
   {
      int nextXMove;
      int nextYMove;
      System.out.println((unitSelected && pointX != xMove && pointY != yMove));
      if (unitSelected && pointX != xMove && pointY != yMove)
      {        
         repaint();
      /* find X coord */
         nextXMove = MID_GRID;
         while (!(pointX <= xCoord[nextXMove+1] && pointX >= xCoord[nextXMove]))
         {
            if(pointX <= xCoord[nextXMove])
            {
               nextXMove--;
            }
            else
            {
               nextXMove++;
            }
         }
      /* find Y coord */
         nextYMove = MID_GRID;
         while(!(pointY <= yCoord[nextYMove+1] && pointY >= yCoord[nextYMove]))
         {
            if(pointY <= yCoord[nextYMove+1])
            {
               nextYMove--;
            }
            else
            {
               nextYMove++;
            }
         }

/*
         if((nextXMove <= xMove + 4 && nextXMove >= xMove - 4) && 
               (nextYMove <= yMove + 3 && nextYMove >= yMove - 3)) */
         if ((Math.abs(xMove-nextXMove) + Math.abs(yMove-nextYMove)) <= 4)
         {
            System.out.println("Set position to: " + nextXMove + ", " + nextYMove);
            xMove = nextXMove;
            yMove = nextYMove;
            setPosition(xMove, yMove);
            unitSelected=false;   
         }
         else
         {
            System.out.println("Invalid move.");
         }
      }
      else if((!unitSelected) && (pointX >= xCoord[xMove] && pointX <= xCoord[xMove+1] &&
         pointY > yCoord[yMove] && pointY <yCoord[yMove+1]))
      {
         System.out.println("Unit selected!");
         unitSelected=true;
         repaint();
      }

   }


   public void paintComponent(Graphics g) 
   {
       super.paintComponent(g);
       drawBoard((Graphics2D) g);
   }

   @Override
   public Dimension getPreferredSize()
   {
      return new Dimension(GRID_LENGTH,GRID_LENGTH);
   }

   public void mouseClicked(MouseEvent event)
   {
   }

   public void mousePressed(MouseEvent event)
   {
   }

   public void mouseReleased(MouseEvent event)
   {
      //System.out.println("X, Y: " + event.getX() + ", " + event.getY());
      mapClicked(event.getX(), event.getY());
   }

   public void mouseExited(MouseEvent event)
   {
   }

   public void mouseEntered(MouseEvent event)
   {
   }
}
