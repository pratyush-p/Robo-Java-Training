import java.lang.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
  public static int add(int num1, int num2){
    int sol = num1 + num2;
    return sol;
  }
  public static int sub(int num1, int num2){
    int sol = num1 - num2;
    return sol;
  }
  public static int mul(int num1, int num2){
    int sol = num1 * num2;
    return sol;
  }
  public static int div(int num1, int num2){
    int sol = num1 / num2;
    return sol;
  }


  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Select Operation: Add (1), Subtract (2), Multiply (3), Divide (4)");
    int operation = myObj.nextInt();
    System.out.println("Num 1:");
    int numone = myObj.nextInt();
    System.out.println("Num 2:");
    int numtwo = myObj.nextInt();
    if (operation == 1) {
      System.out.println(add(numone, numtwo));
    } else if (operation == 2) {
      System.out.println(sub(numone, numtwo));
    } else if (operation == 3) {
      System.out.println(mul(numone, numtwo));
    } else if (operation == 4) {
      if (numone == 0 && numtwo == 0) {
        System.out.println("Imagine that you have zero cookies and you split them evenly among zero friends. How many cookies does each person get? See? It doesn’t make sense. And Cookie Monster is sad that there are no cookies, and you are sad that you have no friends.");
      } else {
        System.out.println(div(numone, numtwo));
      }
      
    }
    
  }

}
