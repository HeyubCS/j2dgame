import java.swing.*;
public class GameFrame
{

   GraphicsPanel mainPanel = new GraphicsPanel();
   //TODO: Replace background file path with system/world data filepath
   public void drawFrame(int frameWidth, int frameHeight, String background)
   {
      JFrame mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(frameWidth, frameHeight);
      mainFrame.add(BorderLayout.CENTER, mainpanel);
      mainFrame.setVisible(true);
   }
}
