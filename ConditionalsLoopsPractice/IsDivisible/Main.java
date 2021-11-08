import java.lang.*;
public class Main
{
		/**prints if the test parameter is divisible by the divisor parameter
		*@param(int test) letter to test
		*@param(int divisor) number to divide
*/
  public static boolean isDivisible(int test, int divisor)
  {
      float test_float = test;
      float divisor_float = divisor;
      float final_product;
      final_product = test_float/divisor_float;
      int final_int_product = test/divisor;
      if (final_product == final_int_product) {
          return true;
      }
      //return false;
      //System.out.println("failed");
      return false;
  } 
  public static void main(String[] args) {
  System.out.println(isDivisible(10, 2));
  }
}
