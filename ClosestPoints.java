import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      float start = 0;
      float lap = 0;
      float total = 0;
      System.out.println(lap - start);
      Point[] points = new Point[100];
      for (int i = 0; i < points.length; i++) {
         points[i] = new Point(in.nextInt(), in.nextInt());
      }
      // testing print
      
      /*for (int i = 0; i < points.length; i++) {
         System.out.println(points[i]);
      }*/
      start = System.nanoTime();
      System.out.println(bruteForce(points));
      lap = System.nanoTime();
      System.out.println();
      System.out.println(lap - start);
      start = System.nanoTime();
      dynamic(points);
      lap = System.nanoTime();
      System.out.println();
      System.out.println(lap - start);
   }
   
   public static void dynamic(Point[] points) {
      Point[] first = Arrays.copyOfRange(points, 0, points.length / 2);
      Point[] second = Arrays.copyOfRange(points, points.length / 2, points.length);
   }
   
   // brute force solution
   public static double bruteForce(Point[] points) {
      // Set to arbitrarily large number
      double min = 1000000;
      for (int i = 0; i < points.length; i++) {
         for (int j = i; j < points.length; j++) {
            min = Math.min(distance(points[i].x, points[i].y, points[j].x, points[j].y), min);
         }
      }
      return min;
   }
   
   // distance formula
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
   
   // sort by y, list is already sorted by x
   public int compareTo(Point other) {
      return y - other.y;
   }
}