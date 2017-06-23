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
import java.util.Scanner;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class drawFrame
{
   public static final int WINDOW_HEIGHT = 1000;
   public static final int WINDOW_WIDTH  = 1000;
   public static final int GRID_SIZE     = 50;
   public static final int GRID_COUNT    = 50;
   int xMove = 0;
   int yMove = 0;

   public int[] xCoord = new int[GRID_COUNT];
   public int[] yCoord = new int[GRID_COUNT];
    DrawPanel gridPanel = new DrawPanel();

  public void drawFrame()
  {
    JFrame mainFrame = new JFrame();
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JScrollPane scroll = new JScrollPane(gridPanel);

    mainFrame.add(BorderLayout.CENTER, scroll);
    mainFrame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
    mainFrame.setVisible(true);
    Scanner keyboard = new Scanner(System.in);

    for(;;)
    {
      xMove = keyboard.nextInt();
      yMove = keyboard.nextInt();
      gridPanel.setPosition(xMove, yMove);
    }
  }
}
