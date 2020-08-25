// I used a if esle method to come up with this although the switch may have worked with less code
//I wanted to make a loop to ask again using "do while" loops but i couldnt figure out how to make it execute
//
//
//
import java.util.Scanner;

public class PhoneAlgorithm{
  
  // This is the privte helper method that displays information about
  // programmer, the course, and the project.
  private static void printHeading () {
    System.out.println("Joey Luck");
    System.out.println("Computer Science 201");
    System.out.println("Programming Project 1");
    System.out.println("Your Name in Code");
    System.out.println();
    
  }
  
  public static void main (String[] args){
   // String again = "";
    char letter = '0';
    int n;
      //char A = 2;
      //char B = 2;
      //char C = 2;
      //char D = 3;
      //char E = 3;
      //char F = 3;
      //char G = 4;
      //char H = 4;
      //char I = 4;
      //char J = 5;
      //char K = 5;
      //char L = 5;
      //char M = 6;
      //char N = 6;
      //char O = 6;
      //int P = 7;
      //int Q = 7;
      //int R = 7;
      //int S = 7;
      //int T = 8;
      //int U = 8;
      //int V = 8;
      //int W = 9;
      //int X = 9;
      //int Y = 9;
      //int Z = 9;
      //boolean '1' = true;
        //while('1'){
    
   
      Scanner in = new Scanner(System.in);
      System.out.print("Enter a single letter, and I will tell you what the corresponding digit is on the telephone: ");
      System.out.print("(note that only uppercase letters will be recognized, no non alphabet characters): ");
       letter = in.next().charAt(0);
        if (letter == 'A' || letter == 'B' || letter == 'C')
       {
         n = 2;
          System.out.println("The Digit 2 corresponds to the letter "+ letter +" on the telephone");
          
 //        else input.nextInt();
        }
        else if (letter == 'C' || letter == 'D' || letter == 'E')
        {   
          n = 3;
          System.out.println("The Digit 3 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'G' || letter == 'H' || letter == 'I')
             
        {
          n = 4;
          System.out.println("The Digit 4 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'J' || letter == 'K' || letter == 'L')
        {
          n = 5;
          System.out.println("The Digit 5 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'M' || letter == 'N' || letter == 'O')
        {
          n = 6;
          System.out.println("The Digit 6 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'P' || letter == 'Q' || letter == 'R'|| letter == 'S')
        {
          n = 7;
          System.out.println("The Digit 7 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'T' || letter == 'U' || letter == 'V')
        {
          n = 8;
          System.out.println("The Digit 8 corresponds to the letter "+ letter +" on the telephone");
         
        }
        else if (letter == 'W' || letter == 'X' || letter == 'Y'|| letter == 'Z')
        {
          n = 9;
          System.out.println("The Digit 9 corresponds to the letter "+ letter +" on the telephone");
        }
        else if (letter == 'a' || letter == 'b' || letter == 'c'|| letter == 'd' || letter == 'e' || letter == 'f')
        {
          System.out.println("Error only Uppercase letters may be used ");
        }
        else if (letter == 'g' || letter == 'h' || letter == 'i'|| letter == 'j' || letter == 'k' || letter == 'l')
        {
          System.out.println("Error only Uppercase letters may be used ");
        }
        else if (letter == 'm' || letter == 'n' || letter == 'o'|| letter == 'p' || letter == 'q' || letter == 'r')
        {
          System.out.println("Error only Uppercase letters may be used ");
        }
        else if (letter == 's' || letter == 't' || letter == 'u'|| letter == 'v' || letter == 'w' || letter == 'x')
        {
          System.out.println("Error only Uppercase letters may be used ");
        }
        else if (letter == 'y' || letter == 'z')
        {
          System.out.println("Error only Uppercase letters may be used ");
        }
    
      // Scanner scan = new Scanner(System.in);
       
          
       // System.out.println("would you like to try another letter? enter yes to try again or no to cancel: ");
        // again = scan.nextLine();
       // if (again.equals("y"))
       // {
          
         // String answer = in.next();
         // while(!answer.equals("n"))
           
          //  System.out.print("Enter a single letter, and I will tell you what the corresponding digit is on the telephone: ");
          // System.out.print("(note that only uppercase letters will be recognized, no non alphabet characters): ");
         // }
       // else if (again == "n")
       // {
          in.close();
         // scan.close();
        }
          //}
      //  }
        
  }
  
         
          
 

  