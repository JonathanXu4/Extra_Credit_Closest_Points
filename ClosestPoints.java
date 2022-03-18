import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      float start = 0;
      float lap = 0;
      float total = 0;
      Point[] points = new Point[100];
      for (int i = 0; i < points.length; i++) {
         points[i] = new Point(in.nextInt(), in.nextInt());
      }
      start = System.nanoTime();
      System.out.println("dist " + bruteForce(points));
      lap = System.nanoTime();
      System.out.println("brute force " + (lap - start));
      start = System.nanoTime();
      System.out.println(dynamic(points));
      lap = System.nanoTime();
      System.out.println();
      System.out.println("dynamic " + (lap - start));
   }
   
   public static double dynamic(Point[] points) {
      if (points.length <= 3) {
         return bruteForce(points);
      }
      double min = Math.min(dynamic(Arrays.copyOfRange(points, 0, points.length / 2)),
                           dynamic(Arrays.copyOfRange(points, points.length / 2, points.length)));
      // Takes middle section of size min
      Point[] middle = new Point[points.length];
      int midIndex = 0;
      for (int i = 0; i < middle.length; i++) {
         if (Math.abs(points[i].x - points[points.length / 2].x) < min) {
            middle[midIndex] = points[i];
            midIndex++;
         }
      }
      middle = Arrays.copyOfRange(middle, 0, midIndex);
      Arrays.sort(middle);
      
      
      return min;
   }
   
   // brute force solution
   public static double bruteForce(Point[] points) {
      // Set to arbitrarily large number
      double min = 1000000;
      for (int i = 0; i < points.length; i++) {
         for (int j = i + 1; j < points.length; j++) {
            min = Math.min(distance(points[i].x, points[i].y, points[j].x, points[j].y), min);
         }
      }
      return min;
   }
   
   // distance formula
   public static double distance(double x1, double y1, double x2, double y2) {
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