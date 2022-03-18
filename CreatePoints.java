import java.io.*;
import java.util.*;

public class CreatePoints {
   public static void main(String[] args) throws FileNotFoundException {
      PrintStream out = new PrintStream(new File("points.txt"));
      Random rand = new Random();
      int[] x = new int[100];
      // Random numbers between -50 to positive 50
      for (int i = 0; i < 100; i++) {
         x[i] = rand.nextInt(101) - 50;
      }
      Arrays.sort(x);
      for (int i = 0; i < 100; i++) {
         out.println(x[i] + " " + (rand.nextInt(101) - 50));
      }
   }
}