import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      float start = 0;
      float lap = 0;
      float total = 0;
      System.out.println(lap - start);
      Point[] hundredPoints = new Point[100];
      for (int i = 0; i < hundredPoints.length; i++) {
         hundredPoints[i] = new Point(in.nextInt(), in.nextInt());

      }
      // testing print
      
      /*for (int i = 0; i < hundredPoints.length; i++) {
         System.out.println(hundredPoints[i]);
      }*/
      start = System.nanoTime();
      for (int i = 0; i < hundredPoints.length; i++) {
         for (int j = i; j < hundredPoints.length; j++) {
            System.out.println(distance(hundredPoints[i].x, 
                                        hundredPoints[i].y,
                                        hundredPoints[j].x,
                                        hundredPoints[j].y));
         }
      }
      lap = System.nanoTime();
      System.out.println();
      System.out.println(lap - start);
   }
   
   public static double distance(int x1, int y1, int x2, int y2) {
      return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
   }
}

class Point implements Comparable<Point> {
   int x;
   int y;
   
   public Point(int x, int y){
      this.x = x;
      this.y = y;
   }
   
   public String toString() {
      return "(" + x + ", " + y + ")";
   }
   
   public int compareTo(Point other) {
      return y - other.y;
   }
}