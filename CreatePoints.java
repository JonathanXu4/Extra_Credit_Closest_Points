import java.io.*;
import java.util.*;

public class CreatePoints {
   public static void main(String[] args) throws FileNotFoundException {
      PrintStream out = new PrintStream(new File("points.txt"));
      Random rand = new Random();
      for (int i = 0; i < 100; i++) {
         out.println((i - 50) + " " + (rand.nextInt(101) - 50));
      }
   }
}