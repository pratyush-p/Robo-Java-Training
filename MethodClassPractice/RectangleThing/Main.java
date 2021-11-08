import java.lang.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
  public static double perimeter(int length, int width) {
    double perim = length * 2 + width * 2;
    //System.out.println(perim);
    return perim;
  }
  public static double area(int length, int width) {
    double a = length * width;
    //System.out.println(a);
    return a;
  }
  public static void ToString(int length, int width) {
    System.out.println("Length is " + length);
    System.out.println("Width is " + width);
    System.out.println("Perim. is " + perimeter(length, width));
    System.out.println("Area is " + area(length, width));
  }


  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter Length");
    int length = myObj.nextInt();
    System.out.println("Enter Width");
    int width = myObj.nextInt();
    System.out.println("Area (1), Perim (2), String (3)");
    int activity = myObj.nextInt();
    if (activity == 1) {
      System.out.println("Area is " + area(length, width));
    } else if (activity == 2) {
      System.out.println("Perim. is " + perimeter(length, width));
    } else if (activity == 3) {
      ToString(length, width);
    }
  }

}
