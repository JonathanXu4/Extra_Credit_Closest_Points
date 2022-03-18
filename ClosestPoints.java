// Jonathan Xu
// Closest Points
// 
// This program compares a brute force and dynamic solution
// to the closest points problem
// It uses a file with 100 points created by the createPoints
// program

import java.io.*;
import java.util.*;

public class ClosestPoints {
   public static final int LOOPS = 10;
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(new File("points.txt"));
      double start;
      double end;
      Point[] points = new Point[100];
      for (int i = 0; i < points.length; i++) {
         points[i] = new Point(in.nextInt(), in.nextInt());
      }
      start = System.nanoTime();
      for (int i = 0; i < LOOPS; i++) {
         bruteForce(points);
      }
      end = System.nanoTime();
      System.out.println("brute force " + ((end - start) / LOOPS));
      start = System.nanoTime();
      for (int i = 0; i < LOOPS; i++) {
         // This is to waste time because the array is already sorted
         // in the file
         Arrays.sort(points);
         dynamic(points);
      }
      end = System.nanoTime();
      System.out.println("dynamic " + ((end - start) / LOOPS));
   }
   
   public static double dynamic(Point[] points) {
      // base case. Didn't work well at 2
      if (points.length <= 3) {
         return bruteForce(points);
      }
      double min = Math.min(dynamic(Arrays.copyOf(points, points.length / 2)),
                           dynamic(Arrays.copyOfRange(points, points.length / 2, points.length)));
      // Takes middle section of width 2 * min
      Point[] middle = new Point[points.length];
      int midIndex = 0;
      for (int i = 0; i < middle.length; i++) {
         if (Math.abs(points[i].x - points[points.length / 2].x) < min) {
            middle[midIndex] = points[i];
            midIndex++;
         }
      }
      // Remove blank values, important for length
      middle = Arrays.copyOf(middle, midIndex);
      Arrays.sort(middle);
      
      for (int i = 0; i < middle.length; i++) {
         for (int j = i + 1; j < middle.length && middle[j].y - middle[i].y < min; j++) {
            min = Math.min(min, distance(middle[i], middle[j]));
         }
      }
      
      return min;
   }
   
   // brute force solution
   public static double bruteForce(Point[] points) {
      // Set to arbitrarily large number
      double min = 1000000;
      for (int i = 0; i < points.length; i++) {
         for (int j = i + 1; j < points.length; j++) {
            min = Math.min(distance(points[i], points[j]), min);
         }
      }
      return min;
   }
   
   // distance formula
   public static double distance(Point a, Point b) {
      return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
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