import java.lang.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
  public static double area(double input) {
    double sol = Math.PI * Math.pow(input, 2);
    return sol;
  }
  public static double circum(double input) {
    double sol = 2 * Math.PI * input;
    return sol;
  }


  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Circum (1), or Area (2)");
    int calctype = myObj.nextInt();
    System.out.println("Input Temp:");
    double radius = myObj.nextDouble();
    if (calctype == 1) {
      System.out.println(circum(radius));
    }
    if (calctype == 2) {
      System.out.println(area(radius));
    }
  }

}
