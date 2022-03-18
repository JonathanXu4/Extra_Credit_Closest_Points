import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      float start = 0;
      float lap = 0;
      float total = 0;
      System.out.println(lap - start);
      int[][] hundredPoints = new int[100][2];
      for (int i = 0; i < hundredPoints.length; i++) {
         int[] points = new int[2];
         points[0] = in.nextInt();
         points[1] = in.nextInt();
         hundredPoints[i] = points;
      }
      // testing print
      for (int i = 0; i < hundredPoints.length; i++) {
         System.out.println(hundredPoints[i][0] + " " + hundredPoints[i][1]);
      }
   }
   
   public static double distance(int x1, int y1, int x2, int y2) {
      return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
   }
}