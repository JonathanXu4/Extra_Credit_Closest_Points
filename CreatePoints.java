import java.io.*;
import java.util.*;

public class CreatePoints {
   public static void main(String[] args) throws FileNotFoundException {
      PrintStream out = new PrintStream(new File("points.txt"));
      Random rand = new Random();
      // Random numbers between -50 to positive 50
      for (int i = 0; i < 100; i++) {
         out.print("[" + (rand.nextInt(101) - 50) + ", ");
         out.println(rand.nextInt(101) - 50 + "]");
      }
   }
}