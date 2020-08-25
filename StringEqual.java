

public class StringEqual
{
    
  private static void printHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();
  }
  public static void main(String[] args)
  {
    String str1 = "abcd";
    String str2 = "abcdefg";
    String str3 = str1 + "efg";
    System.out.println("str2 = " + str2);
    System.out.println("str3 = " + str3);
    if (str2.equals(str3)) {
      System.out.println("The Strings str2 and str3 are the same.");
    }
    else {
      System.out.println("the Strings str2 and str3 are not the same.");
    }
  }
}
      