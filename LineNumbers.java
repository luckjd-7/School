import java.util.*;
import java.io.*;
public class LineNumbers
{ 
   private static void ProjectHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();}
  public static void main(String[] args) throws IOException
  {
    System.out.print("Please enter a File Name");
    Scanner scan = new Scanner(System.in);
    File file = new File(scan.nextLine());
    FileReader inReader = new FileReader(file);
    Scanner inFile = new Scanner(file);
     for(int count = 1; inFile.hasNextLine(); count++)
    {
       String line = inFile.nextLine();
       if(line.equals(""))
       {
         System.out.println(line);
         count--;
       }
       else
       {
        System.out.println(count + " " + line);
       }
     }
     scan.close();
     inReader.close();
     inFile.close();
  }
}
       