
//SimpleArrayExample
// This is the main class that uses the Numbers class to add a list of numbers and multiply a list of numbers. 
// This example demonstrates the use of a simple one dimensional array.
//
// Written by George Cardwell
//
// CSC-202  Computer Science II Fall 2016
//
import java.util.Scanner;

public class SimpleArrayExample
{   
  public static void main(String[] args )
  {
    int upperLimit;
    Scanner scan = new Scanner(System.in);      // Setup scanner to read input from the keyboard.
    System.out.print("Enter the number of numbers you wisht to enter: ");
    upperLimit = scan.nextInt();                // Imput the number of numbs the list will contain. 
    Numbers LN = new Numbers(upperLimit);       // Create a Numbers object with a list of size upperLimit.
    LN.inputNums();                             // Input numbers form the list and then display the sum of all numbers in the list
                                                // and the product numbers in the list.
    System.out.println("The sum of the numbers is " + LN.sumNumbers() + " The product of the numbers is " + LN.multiplyNumbers() );
  }
} 