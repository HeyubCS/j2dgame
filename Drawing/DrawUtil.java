public class DrawUtil
{
   public static final int  GRID_SIZE = 50;
   public static final int  GRID_LENGTH = 2500;
   public static final int  GRID_COUNT = 50; //GRID_LENGTH / GRID_SIZE

   public int[] createXAxis()
   {
      int[] xLines = new int[GRID_COUNT];
      for(int i = 0; i < GRID_COUNT; i++)
      {
         xLines[i] = (i * GRID_SIZE);
      }
      return xLines;
   }

   public int[] createYAxis()
   {
      int[] yLines = new int[GRID_COUNT];
      for(int i = 0; i < GRID_COUNT; i++)
      {
         yLines[i] = (i * GRID_SIZE);
      }
      return yLines;
   }

}
