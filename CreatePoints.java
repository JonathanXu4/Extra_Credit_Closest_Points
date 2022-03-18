import java.io.*;
import java.util.*;

public class CreatePoints {
   public static final int AMOUNT = 100;
   public static void main(String[] args) throws FileNotFoundException {
      PrintStream out = new PrintStream(new File("points.txt"));
      Random rand = new Random();
      for (int i = 0; i < AMOUNT; i++) {
         out.println((i - (AMOUNT / 2)) + " " + (rand.nextInt(AMOUNT + 1) - (AMOUNT / 2)));
      }
   }
}