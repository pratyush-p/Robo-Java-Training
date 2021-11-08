import java.lang.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
  public static double convertF(double input) {
    double sol = (input * 9/5) + 32;
    return sol;
  }
  public static double convertC(double input) {
    double sol = (input - 32) * 5/9;
    return sol;
  }


  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Input Temp Type ('1' for C, '2' for F):");
    int temptype = myObj.nextInt();
    System.out.println("Input Temp:");
    double temp = myObj.nextDouble();
    if (temptype == 1) {
      System.out.println(convertF(temp));
    }
    if (temptype == 2) {
      System.out.println(convertC(temp));
    }
  }

}
