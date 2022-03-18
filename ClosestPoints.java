import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      float start = 0;
      float lap = 0;
      float total = 0;
      start = System.nanoTime();
      lap = System.nanoTime();
      System.out.println(lap - start);
      while (in.hasNextInt()) {
         int[] points = new int[2];
         System.out.println(in.nextInt());
      }
      
      System.out.println(lap - start);
   }
   
   public static double distance(int x1, int y1, int x2, int y2) {
      return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
   }
}