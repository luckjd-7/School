import java.util.*;
public class PrintStrings
{
  private static void printHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();}
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a word for comparison");
    String str1 = scan.next();
    Scanner scan2 = new Scanner(System.in);
    System.out.print("Enter a Second word for comparison");
    String str2 = scan2.next();
    int str3 = str1.compareTo(str2);
    if (str3 > 0)
      System.out.print(str1 + " comes after " + str2);
    else if (str3 < 0)
      System.out.print(str1 + " comes before " + str2);
    else if (str3 == 0)
      System.out.print(str1 + " is equal to " + str2);
      
  }
}