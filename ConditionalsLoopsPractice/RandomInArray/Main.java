import java.lang.*;
import java.util.stream.*;
import java.util.Arrays;

public class Main
{
  static int random = 20;
  //random is changing constantly in external code
  //use the random variable like it is a normal variable
  
  /*prints true when random is within the given range
  * @param(int lower) lower bound to check, inclusive
  * @param(int upper) upper bound to check, inclusive
  */
  public static boolean withinRange(int lower, int upper)
  {
    int[] nums = java.util.stream.IntStream.rangeClosed(lower, upper).toArray();
    for (int i : nums) {
      if (random == i) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    
    System.out.println(withinRange(1, 10));
  }

}
