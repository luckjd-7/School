import java.util.*;
public class MiddleString
{
  private static void printHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();}
  public static void main(String[] args)
  {
    //String str1,str2,str3;
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter First String");
    String str1 = scan.next();
    Scanner scan1 = new Scanner(System.in);
    System.out.print("Enter Second String");
    String str2 = scan1.next();
    Scanner scan2 = new Scanner(System.in);
    System.out.print("Enter Third String");
    String str3 = scan2.next();
    int str4 = str1.compareTo(str2);
    int str5 = str2.compareTo(str3);
    int str6 = str1.compareTo(str3);
    //System.out.print(str4);
   // System.out.print(str5);
    //System.out.print(str6);
   // int str7 = 
    //if (str4 > str5 && str4 < str6 || str4 > str6 && str4 < str5)
    if ((str4 > 0 && str6 < 0) || (str4 < 0 && str6 > 0))
      System.out.print(str1);
    else if ((str5 < 0 && str4 < 0) || (str5 > 0 && str4 > 0))
    //else if (str5 > str4 && str5 < str6 || str5 > str6 && str5 < str4)
      System.out.print(str2);
    else if ((str6 > 0 && str5 < 0) || (str5 > 0 && str6 < 0))
   // else if (str6 > str5 && str6 < str4 || str6 > str4 && str6 < str5)
      System.out.print(str3);
  }}